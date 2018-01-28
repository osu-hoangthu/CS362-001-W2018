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
	  public void test01()  throws Throwable  {
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
	 @Test
	public void appointmentMade(){
	 	Appt isFalse;
	 	isFalse = new Appt(9, 35, 5,12, 2018, "Date Night", "Gonna be lit");
	 	assertNotNull(isFalse);
	 }
}
