package in.nandhini.service;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;

import in.nandhini.util.DateTime;
import in.nandhini.validation.FacilityValidation;
import in.nandhini.validation.RoomChoiceValidation;

public class BillManager {

	/*
	 * calling the appropriate manager to calculate the total bill amount with user
	 * choice of input from test case.
	 */

	public static LinkedHashMap<String, Double> totalBill(List<String> list) {
		// checking Check-In date is valid or not
		String startDate = null;
		// checking Check-Out date is valid or not
		String endDate = null;
		startDate = list.get(0);
		DateTime.checkInDate(startDate);

		endDate = list.get(1);
		DateTime.checkOutDate(startDate, endDate);

		// calculating total hours
		double totalHours = HourCalculator.findingHours(startDate, endDate);

		// calculating amount with choice of room selection
		String roomChoice = list.get(2);
		double roomCharge = RoomChoiceValidation.roomsPrice(roomChoice);

		// calculating amount with choice of AC/NON-AC
		String acChoice = list.get(3);
		double acCharge = FacilityValidation.acNonAcSelection(acChoice);

		// calculating amount with choice of with food / without food
		String poolChoice = list.get(4);
		double poolCharge = FacilityValidation.poolAccess(poolChoice);

		// calculating amount with choice of Pick-Up and drop
		String pickUpDropChoice = list.get(5);
		double pickUpDropCharge = FacilityValidation.transportSelection(pickUpDropChoice);

		// getting all individual amount and adding together to get a bill
		double totalAmount = (acCharge * totalHours) + roomCharge + poolCharge + pickUpDropCharge;
		
		// amount with 7% GST
		double amountWithGst = (totalAmount * 0.07) + totalAmount;

		// to avoid negative values
		double billAmount = (float) Math.abs(amountWithGst);

		// format to two decimal points
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		String total = numberFormat.format(billAmount);
		double totalBill = Double.parseDouble(total);
		System.out.println(totalBill);

		// create map to store all price details
		LinkedHashMap<String, Double> bill = new LinkedHashMap<>();
		bill.put(roomChoice, roomCharge);
		bill.put(acChoice, acCharge);
		bill.put(poolChoice, poolCharge);
		bill.put(pickUpDropChoice, pickUpDropCharge);
		bill.put("Total", totalAmount);
		bill.put("Total with GST", totalBill);

		return bill;
	}
}
