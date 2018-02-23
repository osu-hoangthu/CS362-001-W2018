package calendar;

import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.sql.Time;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[]{"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class
		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
		return methodArray[n]; // return the method name
	}
	 @Test
	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 long randomseed = System.currentTimeMillis(); //10
		 Random random = new Random(randomseed);

		 try{
		 	for(int iter = 0; elapsed < TestTimeout; iter++){
		 		GregorianCalendar cal;
		 		Appt appt;
				TimeTable time;
				CalDay test;

				cal = new GregorianCalendar();

				int year = ValuesGenerator.RandInt(random);
				int month = ValuesGenerator.getRandomIntBetween(random, 1, 10);
				int day = ValuesGenerator.RandInt(random);
				int hour = ValuesGenerator.RandInt(random);
				int minute = ValuesGenerator.RandInt(random);

				cal.set(GregorianCalendar.DATE, day);
				cal.set(GregorianCalendar.MONTH, month);
				cal.set(GregorianCalendar.YEAR, year);

				time = new TimeTable();
				test = new CalDay(cal);
				appt = new Appt(hour, minute, day, month, year, "Assignment Due", "Due today, do today");
				LinkedList<Appt> listAppt = new LinkedList<Appt>();
				listAppt.add(appt);
				test.addAppt(appt);

		 		for(int i = 0; i < NUM_TESTS; i++){
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					if(methodName.equals("deleteAppt")){
						time.deleteAppt(listAppt, appt);
						int newHour = ValuesGenerator.getRandomIntBetween(random, -5, 0);
						appt = new Appt(newHour, minute, day, month, year, "Assignment Due", "Due today, do today");
						listAppt.add(appt);
						test.addAppt(appt);
						time.deleteAppt(listAppt, appt);
					}else if(methodName.equals("getApptRange")){
						GregorianCalendar first, last;
						first = new GregorianCalendar();
						last = new GregorianCalendar();

						appt = new Appt(3, 30, 4, 5, 2015, "movie night", "");
						listAppt.add(appt);
						test.addAppt(appt);

						int year1 = ValuesGenerator.getRandomIntBetween(random, 2015, 2016);
						int year2 = ValuesGenerator.getRandomIntBetween(random, 2016, 2018);
						int month1 = ValuesGenerator.getRandomIntBetween(random, 1, 6);
						int month2 = ValuesGenerator.getRandomIntBetween(random, 7, 12);
						int day1 = ValuesGenerator.getRandomIntBetween(random, 1, 15);
						int day2 = ValuesGenerator.getRandomIntBetween(random, 15, 31);

						first.set(GregorianCalendar.YEAR, year1);
						first.set(GregorianCalendar.MONTH, month1);
						first.set(GregorianCalendar.DATE, day1);

						last.set(GregorianCalendar.YEAR, year2);
						last.set(GregorianCalendar.MONTH, month2);
						last.set(GregorianCalendar.DATE, day2);

						time.getApptRange(listAppt, first, last);
					}
				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iter % 10000) == 0 && iter != 0)
					System.out.println("TimeTable elapsed time: " + elapsed + " of " + TestTimeout);
			}
		 }catch(NullPointerException e){}
		 System.out.println("TimeTable Testing Done");
	 }


	
}
