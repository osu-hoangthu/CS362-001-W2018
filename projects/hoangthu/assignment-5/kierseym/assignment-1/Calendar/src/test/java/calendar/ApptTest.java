package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void appointmentMade(){
		Appt Appointment;
		Appointment = new Appt(9, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertNotNull(Appointment);
	}

	@Test
	public void WrongAppointment(){
		Appt Appointment;
		Appointment = new Appt(59, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertFalse(Appointment.getValid());
	}

	@Test
	public void RightAppointment(){
		Appt Appointment;
		Appointment = new Appt(4, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertTrue(Appointment.getValid());
	}

	@Test
	public void getStartingHour(){
		Appt getHour;
		getHour = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertEquals(5, getHour.getStartHour());
	}

	@Test
	public void getMinute(){
		Appt getMinute;
		getMinute = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertEquals(35, getMinute.getStartMinute());
	}

	@Test
	public void getDayWrong(){
		Appt getDay;
		getDay = new Appt(5, 35, 49,4, 2018, "Date Night", "Gonna be lit");
		assertFalse(getDay.getValid());
	}

	@Test
	public void getHourWrong(){
		Appt getDay;
		getDay = new Appt(59, 35, 49,4, 2018, "Date Night", "Gonna be lit");
		assertFalse(getDay.getValid());
	}

	@Test
	public void getMinuteWrong(){
		Appt getDay;
		getDay = new Appt(5, 100, 49,4, 2018, "Date Night", "Gonna be lit");
		assertFalse(getDay.getValid());
	}

	@Test
	public void getValidDay(){
		Appt getDay;
		getDay = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertEquals(5, getDay.getStartDay());
	}

	@Test
	public void getdayTrue(){
		Appt getDay;
		getDay = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertTrue(getDay.getValid());
	}

	@Test
	public void getYear(){
		Appt testYear;
		testYear = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertEquals(2018, testYear.getStartYear());
	}

	@Test
	public void getTitle(){
		Appt name;
		name = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		assertEquals("Date Night", name.getTitle());
	}

	@Test
	public void getDescription(){
		Appt desc;
		desc = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		desc.setDescription("Boring night");
		assertEquals("Boring night", desc.getDescription());
	}

	@Test
	public void testSetHour(){
		Appt hour;
		hour = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		hour.setStartHour(5);
		assertEquals(5, hour.getStartHour());
	}

	@Test
	public void testSetMinute(){
		Appt min;
		min = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		min.setStartMinute(35);
		int testMin;
		testMin = min.getStartMinute();
		assertEquals(35, testMin);
	}

	@Test
	public void testSetDay(){
		Appt day;
		day = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		int testDay;
		day.setStartDay(5);
		testDay = day.getStartDay();
		assertEquals(5, testDay);
	}

	@Test
	public void testSetMonth(){
		Appt month;
		month = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		int testMonth;
		month.setStartMonth(4);
		testMonth = month.getStartMonth();
		assertEquals(4, testMonth);
	}

	@Test
	public void testSetYear(){
		Appt year;
		year = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		year.setStartYear(2018);
		int testYear;
		testYear = year.getStartYear();
		assertEquals(2018, testYear);
	}

	@Test
	public void testSetTitle(){
		Appt name;
		name = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		name.setTitle("Not Date Night");
		String testTitle;
		testTitle = name.getTitle();
		assertEquals("Not Date Night", testTitle);
	}

	@Test
	public void testSetDescription(){
		Appt description;
		description = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		description.setDescription("Break ups happen");
		String testDescription;
		testDescription = description.getDescription();
		assertEquals("Break ups happen", testDescription);
	}

	@Test
	public void testSetNullDescription(){
		Appt description;
		description = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		description.setDescription("");
		String testDescription;
		testDescription = description.getDescription();
		assertEquals("", testDescription);
	}


	@Test
	public void testRecurrenceNumber(){
		Appt recurN;
		recurN = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		int number;
		int [] falsearr = new int[0];
		recurN.setRecurrence(falsearr, 1, 1, 12);
		number = recurN.getRecurNumber();
		assertEquals(12, number);
	}

	@Test
	public void testRecurrenceBy(){
		Appt recurN;
		recurN = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		int number;
		int [] falsearr = new int[0];
		recurN.setRecurrence(falsearr, 1, 1, 12);
		number = recurN.getRecurBy();
		assertEquals(1, number);
	}

	@Test
	public void testIsRecurring(){
		Appt recurN;
		recurN = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		int [] falsearr = new int[0];
		recurN.setRecurrence(falsearr, 1, 1, 12);
		assertTrue(recurN.isRecurring());
	}

	@Test
	public void testRecurInc(){
		Appt recurN;
		recurN = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		int number;
		int [] falsearr = new int[0];
		recurN.setRecurrence(falsearr, 1, 1, 12);
		number = recurN.getRecurBy();
		assertEquals(1, number);
	}

	@Test
	public void testRecurArr(){
		Appt recurN;
		recurN = new Appt(5, 35, 5,4, 2018, "Date Night", "Gonna be lit");
		int [] falsearr = new int[0];
		recurN.setRecurrence(falsearr, 1, 1, 12);
		assertNotNull(recurN.getRecurDays());
	}

}