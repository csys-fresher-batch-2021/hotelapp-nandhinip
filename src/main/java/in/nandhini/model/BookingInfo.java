package in.nandhini.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookingInfo {

	/**
	 * constructor for BookingInfo
	 * 
	 */
	public BookingInfo() {
		super();
	}

	/**
	 * used lombok for toString, getter and setter
	 */
	private Long mobNo;
	private String name;
	private Timestamp checkIn;
	private Timestamp bookDate;
	private String suite;
	private String acChoice;
	private String poolChoice;
	private String transport;
	private Double amount;
	private Boolean status;
	private Timestamp modDate;

}
