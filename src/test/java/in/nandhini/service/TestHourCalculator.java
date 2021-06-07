package in.nandhini.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHourCalculator {

	/**
	 * To calculate the total hours spent in hotel
	 */
	@Test
	public void checkHourcalc() {
		String startDate = "2021-06-06T01:10";// Given startDate
		String endDate = "2021-06-06T06:30";// Given endDate
		double output = HourCalculator.findingHours(startDate, endDate);
		assertEquals(5.33,output,0.001);
	}

	/**
	 * to check with invalid date format
	 */
	@Test
	public void validdateCheck() {
		String startDate = "2021-06-05T01:10";// Given startDate
		String endDate = "2021-06-06T06:30";// Given endDate
		double output = HourCalculator.findingHours(startDate, endDate);
		assertEquals(29.33,output,0.001);

	}

}
