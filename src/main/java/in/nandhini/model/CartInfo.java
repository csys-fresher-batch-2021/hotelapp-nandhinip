package in.nandhini.model;

import java.time.LocalDateTime;

public class CartInfo {

	/**
	 * Cart data to be stored in List
	 */
	public Integer id;
	public LocalDateTime checkIn;
	public String suite;
	public String acChoice;
	public String poolChoice;
	public String transport;
	public Double amount;

	public CartInfo(int id, LocalDateTime checkIn, String acChoice, String suiteType, String tansportChoice,
			String poolChoice, Double amount) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.suite = suiteType;
		this.acChoice = acChoice;
		this.poolChoice = poolChoice;
		this.transport = tansportChoice;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CartInfo [id=" + id + ", checkIn=" + checkIn + ", suite=" + suite + ", acChoice=" + acChoice
				+ ", poolChoice=" + poolChoice + ", transport=" + transport + ", amount=" + amount + "]";
	}

}
