package in.nandhini.model;

public class MessageConstants {

	/**
	 * as constructor concept require at least one non-public constructor
	 */
	private MessageConstants() {
		throw new IllegalArgumentException();
	}

	/**
	 * Message Constants for some Constant String
	 */
	public static final String MOUNTAINVIEW = "Mountain View";
	public static final String OCEANVIEW = "Night Ocean View";
	public static final String CITYVIEW = "Night City View";
	public static final String TRANSPORT = "With Transport";
	public static final String NOTRANSPORT = "Without Transport";
	public static final String WITHAC = "AC";
	public static final String WITHOUTAC = "FAN";
	public static final String WITHPOOL = "Pool Access";
	public static final String WITHOUTPOOL = "Without Pool Access";
	public static final String CARD_EXPIRED = "Card Expired";
	public static final String INVALID_CARD_NO = "Invalid Card Number";
	public static final String INVALIDCHOICE = "Invalid Choice";
	public static final String INVALID_DATE = "Invalid Date";
	public static final String NULL_VALUE = "Given Null Value";
	public static final String DATE_FORMAT = "yyyy-mm-dd";
	public static final String CVV = "Invalid CVV";
}
