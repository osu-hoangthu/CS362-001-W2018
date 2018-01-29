package calendar;

import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class TimeTableTest {
    @Test
    public void createTimeTable(){
        TimeTable create;
        create = new TimeTable();
        assertNotNull(create);
    }

    @Test
    public void testDeletionofOne(){
        Appt appointment;
        CalDay linkedAppt;
        GregorianCalendar test;
        TimeTable time;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appointment);
        linkedAppt.addAppt(appointment);
        assertNull(time.deleteAppt(listAppt, appointment));
    }

    @Test
    public void testDeletionofTwo(){
        Appt appointment, nextAppointment;
        CalDay linkedAppt;
        GregorianCalendar test;
        TimeTable time;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        nextAppointment = new Appt(5, 35, 5,4, 2018, "Party Night", "Gonna need a new liver");
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appointment);
        listAppt.add(nextAppointment);
        linkedAppt.addAppt(nextAppointment);
        linkedAppt.addAppt(appointment);
        assertNotNull(time.deleteAppt(listAppt, nextAppointment ));
    }

    @Test
    public void testPermuteFailure(){
        Appt appointment, nextAppt;
        CalDay linkedAppt;
        GregorianCalendar test;
        TimeTable time;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        nextAppt = new Appt(5, 30, 12,4, 2018, "Date Night", "Gonna be more lit than last week");
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appointment);
        linkedAppt.addAppt(appointment);
        listAppt.add(nextAppt);
        linkedAppt.addAppt(nextAppt);
        int pv[];
        pv = new int[2];
        pv[0] = 1;
        pv[1] = 0;
        assertNull(time.permute(listAppt, pv));
    }
    @Test
    public void testPermuteSuccess(){
        Appt appointment, nextAppt;
        CalDay linkedAppt;
        GregorianCalendar test;
        TimeTable time;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        nextAppt = new Appt(5, 30, 12,4, 2018, "Date Night", "Gonna be more lit than last week");
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appointment);
        linkedAppt.addAppt(appointment);
        listAppt.add(nextAppt);
        linkedAppt.addAppt(nextAppt);
        int pv[];
        pv = new int[1];
        pv[0] = 1;
        assertNotNull(time.permute(listAppt, pv));
    }

    @Test
    public void testTimeRangeByMonthly(){
        GregorianCalendar first, last, test;
        Appt appointment;
        CalDay linkedAppt;
        TimeTable time;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        first = new GregorianCalendar();
        first.set(GregorianCalendar.YEAR, 2017);
        first.set(GregorianCalendar.MONTH, 3);
        first.set(GregorianCalendar.DATE, 21);
        last = new GregorianCalendar();
        last.set(GregorianCalendar.YEAR, 2018);
        last.set(GregorianCalendar.MONTH, 1);
        last.set(GregorianCalendar.DATE, 15);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,1, 2018, "Date Night", "Gonna be lit");
        int [] falsearr = new int[0];
        appointment.setRecurrence(falsearr, 2, 1,1);
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appointment);
        linkedAppt.addAppt(appointment);
        assertNotNull(time.getApptRange(listAppt,first,last));
    }

    @Test
    public void testTableRangeRecurByYearly(){
        GregorianCalendar first, last, test;
        Appt appointment;
        CalDay linkedAppt;
        TimeTable time;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        first = new GregorianCalendar();
        first.set(GregorianCalendar.YEAR, 2017);
        first.set(GregorianCalendar.MONTH, 3);
        first.set(GregorianCalendar.DATE, 21);
        last = new GregorianCalendar();
        last.set(GregorianCalendar.YEAR, 2018);
        last.set(GregorianCalendar.MONTH, 1);
        last.set(GregorianCalendar.DATE, 15);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,1, 2018, "Date Night", "Gonna be lit");
        int [] falsearr = new int[0];
        appointment.setRecurrence(falsearr, 3, 1,1);
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appointment);
        linkedAppt.addAppt(appointment);
        assertNotNull(time.getApptRange(listAppt,first,last));
    }

    @Test
    public void testTableRangeRecurByDaily(){
        GregorianCalendar first, last, test;
        Appt appointment;
        CalDay linkedAppt;
        TimeTable time;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        first = new GregorianCalendar();
        first.set(GregorianCalendar.YEAR, 2017);
        first.set(GregorianCalendar.MONTH, 3);
        first.set(GregorianCalendar.DATE, 21);
        last = new GregorianCalendar();
        last.set(GregorianCalendar.YEAR, 2018);
        last.set(GregorianCalendar.MONTH, 1);
        last.set(GregorianCalendar.DATE, 15);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,1, 2018, "Date Night", "Gonna be lit");
        int [] falsearr = new int[0];
        appointment.setRecurrence(falsearr, 1, 1,1);
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appointment);
        linkedAppt.addAppt(appointment);
        assertNotNull(time.getApptRange(listAppt,first,last));
    }
}
