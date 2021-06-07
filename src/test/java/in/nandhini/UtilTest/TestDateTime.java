package in.nandhini.UtilTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.nandhini.model.MessageConstants;
import in.nandhini.util.DateTime;

public class TestDateTime {

	/**
	 * Test case to check the Check-In date is valid or not
	 */
	@Test
	public void testCheckInPastDays() {
		try {
			String bdate = "2021-03-04";
			DateTime.checkInDate(bdate);
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALID_DATE, e.getMessage());
		}
	}

	@Test
	public void testcheckInfutureDays() {
		String bdate = "2021-06-07";
		boolean Output = DateTime.checkInDate(bdate);
		assertTrue(Output);
	}

	/**
	 * to compare the Check-Out date with Check-In date
	 */
	@Test
	public void checkOuttodays() {
		String startDate = "2021-06-06 01:10";// Given startDate
		String endDate = "2021-06-06 06:30";// Given endDate
		boolean output = DateTime.checkOutDate(startDate, endDate);
		assertTrue(output);
	}

	@Test
	public void checkOutfuturedays() {
		String startDate = "2021-06-06 01:10";// Given startDate
		String endDate = "2021-06-07 06:30";// Given endDate
		boolean output = DateTime.checkOutDate(startDate, endDate);
		assertTrue(output);
	}

	@Test
	public void checkOutpastdays() {
		try {
			String startDate = "2021-06-06 01:10";// Given startDate
			String endDate = "2021-06-03 06:30";// Given endDate
			DateTime.checkOutDate(startDate, endDate);
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALID_DATE, e.getMessage());
		}
	}

	@Test
	public void emptyStringInput() {
		try {
			String startDate = " ";// Given startDate
			String endDate = " ";// Given endDate
			DateTime.checkOutDate(startDate, endDate);
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALID_DATE, e.getMessage());
		}
	}

	@Test
	public void nullInput() {
		try {
			String startDate = null;// Given startDate
			String endDate = null;// Given endDate
			DateTime.checkOutDate(startDate, endDate);
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALID_DATE, e.getMessage());
		}
	}

	@Test
	public void wrongformatInput() {
		try {
			String startDate = "2021-06 ";// Given startDate
			String endDate = " 2021-06-";// Given endDate
			DateTime.checkOutDate(startDate, endDate);
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALID_DATE, e.getMessage());
		}
	}
}
