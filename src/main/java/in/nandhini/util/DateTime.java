package in.nandhini.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import in.nandhini.exception.IllegalArgumentExp;

public class DateTime {
	
	/**
	 * Checking checking date is valid or not
	 * 
	 * @param datestr
	 * @return String statement whether the date is before current date or today's
	 *         date or future date
	 */
	public static boolean checkInDate(String datestr) {
		boolean result= false;
		try {
			String inDate=datestr.substring(0,10);
			LocalDate today=LocalDate.now();
			LocalDate in = LocalDate.parse(inDate);
			System.out.println(in);
			if (in.isAfter(today)|| in.equals(today)) { // TO CHECK THE DATE IS VALID OR NOT
				result =true;
			}
		} catch (NullPointerException e) {
			IllegalArgumentExp.illegalArgumentDate();
		} 
		return result;
	}

	/**
	 * Checking Check-Out date
	 * 
	 * @param startDate
	 * @param endDate
	 * @return String statement whether the date is before the Check-In date or
	 *         check-In and check-Out date are same
	 */
	public static boolean checkOutDate(String startDate, String endDate) {
		boolean result=false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date in = sdf.parse(startDate);
			Date out = sdf.parse(endDate);
			if (out.after(in) || in.equals(out)) {
				result = true;
			}
		} catch (NullPointerException | ParseException e) {
			IllegalArgumentExp.illegalArgumentDate();
		}
		return result;
	}
}
