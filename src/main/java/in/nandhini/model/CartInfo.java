package in.nandhini.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CartInfo {

	/**
	 * Cart data to be stored in List
	 */
	private Integer id;
	private LocalDateTime checkIn;
	private String suite;
	private String acChoice;
	private String poolChoice;
	private String transport;
	private Double amount;

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
