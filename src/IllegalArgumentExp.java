package in.nandhini.exception;

import in.nandhini.model.MessageConstants;

public class IllegalArgumentExp {

	private IllegalArgumentExp() {
		throw new IllegalArgumentException();
	}

	public static void illegalArgumentChoice() {
		throw new IllegalArgumentException(MessageConstants.INVALIDCHOICE);
	}

	public static void illegalArgumentConstructor() {
		throw new IllegalArgumentException(MessageConstants.INVALID_ENTRY);
	}

	public static void illegalArgumentDate() {
		throw new IllegalArgumentException(MessageConstants.INVALID_DATE);
	}

	public static void cardExpired() {
		throw new IllegalArgumentException(MessageConstants.CARD_EXPIRED);
	}

	public static void invalidCardNo() {
		throw new IllegalArgumentException(MessageConstants.INVALID_CARD_NO);
	}

	public static void invalidCVV() {
		throw new IllegalArgumentException(MessageConstants.CVV);
	}
}
