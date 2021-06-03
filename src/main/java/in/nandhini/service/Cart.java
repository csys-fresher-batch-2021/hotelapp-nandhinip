package in.nandhini.service;

import java.time.LocalDateTime;
import java.util.List;

import in.nandhini.dao.YourCart;
import in.nandhini.exception.InvalidException;
import in.nandhini.model.CartInfo;
import in.nandhini.util.DateTime;

public class Cart {

	private Cart() throws InvalidException {
		throw new InvalidException("Invalid Entry");
	}

	/**
	 * if cart exists, it collect the details of cart from database
	 * 
	 * @param mobNo
	 * @return
	 */
	public static List<CartInfo> cartDetails(long mobNo) {
		List<CartInfo> cart = null;
		boolean exists = false;
		try {
			exists = YourCart.exists(mobNo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (exists) {
			try {
				cart = YourCart.getCart(mobNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cart;
	}

	/**
	 * service layer call to DAO to cancel the room booking
	 * 
	 * @param id
	 * @return
	 */
	public static boolean cancelOrder(int id) {
		boolean cancelled = false;
		LocalDateTime modDate = DateTime.localDate();
		try {
			cancelled = YourCart.cancelOrder(id, modDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cancelled;
	}

}
