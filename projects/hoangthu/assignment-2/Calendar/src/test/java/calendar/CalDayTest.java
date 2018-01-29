package calendar;

import org.junit.Test;

import java.util.LinkedList;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

public class CalDayTest {
    @Test
    public void getdayExists(){
        LinkedList<CalDay> today = new LinkedList<CalDay>();
        assertNotNull(today);
    }

    @Test
    public void testgetMonth(){
        CalDay day;
        GregorianCalendar test;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        day = new CalDay(test);
        assertEquals(5, day.getMonth());
    }

    @Test
    public void testgetDay(){
        CalDay day;
        GregorianCalendar test;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        day = new CalDay(test);
        assertEquals(21, day.getDay());
    }


    @Test
    public void testgetYear(){
        CalDay day;
        GregorianCalendar test;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        day = new CalDay(test);
        assertEquals(2018, day.getYear());
    }

    @Test
    public void testAddAppt(){
        Appt appointment;
        CalDay linkedAppt;
        GregorianCalendar test;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        linkedAppt.addAppt(appointment);
        assertEquals(1, linkedAppt.getAppts().size());
    }

    @Test
    public void testApptSize(){
        Appt appointment;
        CalDay linkedAppt;
        GregorianCalendar test;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        linkedAppt.addAppt(appointment);
        assertEquals(1, linkedAppt.getSizeAppts());
    }

    @Test
    public void testAppointmentAdded(){
        Appt appointment;
        CalDay linkedAppt;
        GregorianCalendar test;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        linkedAppt.addAppt(appointment);
        assertNotNull(linkedAppt);
    }

    @Test
    public void testtoString(){
        Appt appointment;
        CalDay linkedAppt;
        GregorianCalendar test;
        test = new GregorianCalendar();
        test.set(GregorianCalendar.YEAR, 2018);
        test.set(GregorianCalendar.MONTH, 5);
        test.set(GregorianCalendar.DATE, 21);
        linkedAppt = new CalDay(test);
        appointment = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
        linkedAppt.addAppt(appointment);
        assertNotNull(linkedAppt.toString());
    }
}
