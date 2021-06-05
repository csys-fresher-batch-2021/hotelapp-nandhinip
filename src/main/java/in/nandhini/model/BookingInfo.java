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
	public BookingInfo(long mobNo, String name, Timestamp bookDate, Timestamp checkin, String suiteType,
			String acChoice, String poolChoice, String tansportChoice, double amount, boolean status,
			Timestamp modDate) {
		super();
		this.mob_No = mobNo;
		this.name = name;
		this.bookDate = bookDate;
		this.checkIn = checkin;
		this.suite = suiteType;
		this.acChoice = acChoice;
		this.poolChoice = poolChoice;
		this.transport = tansportChoice;
		this.amount = amount;
		this.status = status;
		this.modDate = modDate;
	}


	public Long mob_No;
	public String name;
	public Timestamp checkIn;
	public Timestamp bookDate;
	public String suite;
	public String acChoice;
	public String poolChoice;
	public String transport;
	public Double amount;
	public Boolean status;
	public Timestamp modDate;

}
