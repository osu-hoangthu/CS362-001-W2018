package calendar;


import jdk.vm.ci.meta.Value;
import org.junit.Test;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[]{"addAppt"};// The list of the of methods to be tested in the Appt class
		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 try{
		 	for(int i = 0; elapsed < TestTimeout; i++){
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
				GregorianCalendar test;
				test = new GregorianCalendar();
				CalDay cal;
				int year = ValuesGenerator.RandInt(random);
				int month = ValuesGenerator.getRandomIntBetween(random, 1, 10);
				int day = ValuesGenerator.RandInt(random);


				test.set(GregorianCalendar.YEAR, year);
				test.set(GregorianCalendar.MONTH, month);
				test.set(GregorianCalendar.DATE, day);

				cal = new CalDay(test);

				for(int iter = 0; iter < NUM_TESTS; iter++){
					String methodName = CalDayRandomTest.RandomSelectMethod(random);
					if(methodName.equals("addAppt")){
						Appt appointment;
						year = ValuesGenerator.getRandomIntBetween(random, 0, 2019);
						int minute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
						int hour = ValuesGenerator.getRandomIntBetween(random, 1,24);
						day = ValuesGenerator.getRandomIntBetween(random, 0, 31);
						month = ValuesGenerator.getRandomIntBetween(random, 1, 12);

						appointment = new Appt(hour, minute, day, month, year, "Date Night", "Trying to get lit");
						cal.addAppt(appointment);
					}
				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((i % 10000) == 0 && i!= 0)
					System.out.println("CalDay elapsed time: " + elapsed + " of " + TestTimeout);
			}
		 }catch(NullPointerException e){}
		 System.out.println("CalDay Testing Finished...");
	 }
}
