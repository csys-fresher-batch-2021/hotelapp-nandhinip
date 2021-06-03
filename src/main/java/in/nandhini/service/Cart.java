package in.nandhini.service;

import java.time.LocalDateTime;
import java.util.List;

import in.nandhini.dao.YourCart;
import in.nandhini.model.CartInfo;
import in.nandhini.util.DateTime;

public class Cart {
	
	public static List<CartInfo> cartDetails(long mobNo) {
		List<CartInfo>cart=null;
		boolean exists = false;
		try {
			exists = YourCart.exists(mobNo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(exists) {
			try {
				cart=YourCart.getCart(mobNo);
				System.out.println(cart);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}return cart;
	}
	
	public static boolean cancelOrder(int id) {
		boolean cancelled = false;
		LocalDateTime modDate=DateTime.localDate();
		try {
			cancelled = YourCart.cancelOrder(id,modDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cancelled;
	}

}
