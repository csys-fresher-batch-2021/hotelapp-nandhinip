package in.nandhini.service;

import java.util.HashMap;
import java.util.Map;

import in.nandhini.exception.IllegalArgumentExp;
import in.nandhini.model.MessageConstants;

public class DisplayFacility {
	private DisplayFacility() {
		IllegalArgumentExp.illegalArgumentConstructor();
	}

	/**
	 * hash map declaration
	 */
	private static Map<String, Double> acOption = new HashMap<>();
	static {
		getAcOption().put(MessageConstants.WITHAC, 30.0);
		getAcOption().put(MessageConstants.WITHOUTAC, 10.0);
	}

	private static Map<String, Double> poolAccessOption = new HashMap<>();
	static {
		poolAccessOption.put(MessageConstants.WITHPOOL, 2500.0);
		poolAccessOption.put(MessageConstants.WITHOUTPOOL, 0.0);
	}

	private static Map<String, Double> transportOption = new HashMap<>();
	static {
		getTransportOption().put(MessageConstants.TRANSPORT, 1000.0);
		getTransportOption().put(MessageConstants.NOTRANSPORT, 0.0);
	}

	public static Map<String, Double> getAcOption() {
		return acOption;
	}

	/**
	 * @return the transportOption
	 */
	public static Map<String, Double> getTransportOption() {
		return transportOption;
	}

	/**
	 * @return the poolAccessOption
	 */
	public static Map<String, Double> getPoolAccessOption() {
		return poolAccessOption;
	}
}
