package in.nandhini.service;

import in.nandhini.exception.InvalidEntry;
import in.nandhini.validation.CardValidation;

public class OnlinePayment {

	/**
	 * Constructor
	 * @throws InvalidEntry
	 */
	private OnlinePayment() throws InvalidEntry {
		throw new InvalidEntry("Invalid Entry into constructor");
	}

	public static boolean allCardOrientedValidityCheck(String cardNo, String year, String cvv) {
		boolean valid = false;
		boolean cardNoValid = CardValidation.cardNumberLength(cardNo);
		boolean yearValid = CardValidation.creditcardValidyear(year);
		boolean cvvValid = CardValidation.cvvNo(cvv);
		if (cardNoValid && yearValid && cvvValid) {
			valid = true;
		} else {
			throw new IllegalArgumentException("Invalid Card");
		}
		return valid;
	}
}
