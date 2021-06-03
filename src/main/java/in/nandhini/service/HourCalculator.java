package in.nandhini.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HourCalculator {

	/**
	 * calculating total hours of stay using try catch exception concept
	 * 
	 * @param startDate
	 * @param endDate
	 * @return float type returns a total hours of stay in hotel
	 */
	public static double findingHours(String cin, String cout) {
		String startDate=cin.substring(0, 16);
		String endDate=cout.substring(0,16);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		double totalHour = 0;
		// Try Class
		try {
			Date d1 = sdf.parse(startDate);
			Date d2 = sdf.parse(endDate);
			long differenceInTime = d2.getTime() - d1.getTime();
			totalHour = differenceInTime / 3600000;
			System.out.println("Total Hours spent at Hotel: " + totalHour);
		} catch (ParseException e) {
			totalHour = 0;
		}
		return totalHour;
	}
}
