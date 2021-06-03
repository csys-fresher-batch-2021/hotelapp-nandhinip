package in.nandhini.validation;

import java.time.YearMonth;

import in.nandhini.exception.InvalidException;
import in.nandhini.model.MessageConstants;

public class CardValidation {


	/**
	 * to check the card validity
	 * 
	 * @param cardex
	 * @return boolean
	 * @throws InvalidException 
	 */
	public static boolean creditcardValidyear(String cardex)  {
		boolean valid=true;
		YearMonth cardexpirydate = YearMonth.parse(cardex);
		YearMonth now = YearMonth.now();
		if (cardexpirydate.isBefore(now)) {
			valid =false;
			throw new IllegalArgumentException(MessageConstants.CARD_EXPIRED);
		}
		return valid;
	}

	/**
	 * to check card number's length
	 * 
	 * @param CardNumber
	 * @return
	 * @throws InvalidException 
	 */
	public static boolean cardNumberLength(String cardNumber) {
		boolean valid=true;
		String cardNumberTrim = cardNumber.trim();
		if (cardNumberTrim.length() != 16){// TO CHECK THE LENGTH OF A STRING
			throw new IllegalArgumentException(MessageConstants.INVALID_CARD_NO);
		}
		return valid;
	}
	
	public static boolean cvvNo(String cvv) {
		boolean valid=false;
		boolean len=cvv.length()==3;
		boolean regex=cvv.matches("[0-9]+");
		if( regex && len) {
			valid=true;
		}else {
			throw new IllegalArgumentException(MessageConstants.CVV);
		}
		return valid;
	}
}
