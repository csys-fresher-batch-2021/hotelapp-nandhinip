package in.nandhini.validation;

import java.time.YearMonth;

import in.nandhini.exception.IllegalArgumentExp;

public class CardValidation {


	/**
	 * to check the card validity
	 * 
	 * @param cardex
	 * @return boolean
	 */
	public static boolean creditcardValidyear(String cardex) {
		boolean valid=true;
		YearMonth cardexpirydate = YearMonth.parse(cardex);
		YearMonth now = YearMonth.now();
		if (cardexpirydate.isBefore(now)) {
			valid =false;
			IllegalArgumentExp.cardExpired();
		}
		return valid;
	}

	/**
	 * to check card number's length
	 * 
	 * @param CardNumber
	 * @return
	 */
	public static boolean cardNumberLength(String cardNumber) {
		boolean valid=true;
		String cardNumberTrim = cardNumber.trim();
		if (cardNumberTrim.length() != 16){// TO CHECK THE LENGTH OF A STRING
			valid =false;
			IllegalArgumentExp.invalidCardNo();
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
			IllegalArgumentExp.invalidCVV();
		}
		return valid;
	}
}
