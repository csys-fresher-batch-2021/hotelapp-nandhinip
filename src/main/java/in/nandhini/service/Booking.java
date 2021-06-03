package in.nandhini.service;

import java.time.LocalDateTime;
import java.util.List;

import in.nandhini.dao.BookingDAO;
import in.nandhini.model.BookingInfo;
import in.nandhini.util.DateTime;

public class Booking {

	public static void bookRoomData(List<Object> choice) {
		LocalDateTime bookDate=DateTime.localDate();
		try {
			BookingDAO.save(choice,bookDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<BookingInfo> getBookingDetails() {
		List<BookingInfo> book = null;
		try {
			book=BookingDAO.getAllBookingDetails();
			System.out.println(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
}
