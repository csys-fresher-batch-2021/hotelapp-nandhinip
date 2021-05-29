package in.nandhini.exception;

import in.nandhini.model.MessageConstants;

public class NullPointerExp {
	
	private NullPointerExp() {
		throw new IllegalArgumentException();
	}

	public static void nullInput() {
		throw new NullPointerException(MessageConstants.NULL_VALUE);
	}
}
