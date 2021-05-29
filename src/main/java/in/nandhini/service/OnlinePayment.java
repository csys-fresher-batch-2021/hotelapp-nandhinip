package in.nandhini.service;

import in.nandhini.exception.IllegalArgumentExp;
import in.nandhini.exception.RunTimeExp;
import in.nandhini.validation.CardValidation;

public class OnlinePayment {
	
	private OnlinePayment() {
		IllegalArgumentExp.illegalArgumentConstructor();
	}

	public static boolean allCardOrientedValidityCheck(String cardNo, String year, String cvv) {
		boolean valid = false;
		boolean cardNoValid = CardValidation.cardNumberLength(cardNo);
		boolean yearValid = CardValidation.creditcardValidyear(year);
		boolean cvvValid = CardValidation.cvvNo(cvv);
		if (cardNoValid && yearValid && cvvValid) {
			valid = true;
		} else {
			RunTimeExp.cardValidation();
		}
		return valid;
	}
}
