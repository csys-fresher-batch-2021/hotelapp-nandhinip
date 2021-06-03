package in.nandhini.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.nandhini.dao.BookingDAO;
import in.nandhini.exception.InvalidException;
import in.nandhini.model.BookingInfo;
import in.nandhini.util.DateTime;

public class Booking {

	private Booking() throws InvalidException {
		throw new InvalidException("Invalid Entry");
	}

	/**
	 * service layer to DAO layer to add room booking data
	 * 
	 * @param choice
	 */
	public static void bookRoomData(List<Object> choice) {
		LocalDateTime bookDate = DateTime.localDate();
		try {
			BookingDAO.save(choice, bookDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * service layer to DAO layer to get room booking data
	 * 
	 * @return
	 */
	public static List<BookingInfo> getBookingDetails() {
		List<BookingInfo> book = null;
		try {
			book = BookingDAO.getAllBookingDetails();
			System.out.println(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	/**
	 * Get availability of rooms in hotel data is collected from database
	 * 
	 * @return
	 */
	public static List<Integer> getAvailability() {
		List<Integer> avail = null;
		try {
			int mv = BookingDAO.getMVRoomAvailability();
			int ov = BookingDAO.getOVRoomAvailability();
			int cv = BookingDAO.getCVRoomAvailability();
			avail = new ArrayList<>(Arrays.asList(mv, ov, cv));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avail;
	}
}
