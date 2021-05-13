package in.nandhini.service;

import java.util.HashMap;
import java.util.Map;

public class DisplayRooms {

	/**
	 * as constructor concept require at least one non-public constructor 
	 */
	private DisplayRooms() {
		throw new IllegalArgumentException();
	}
	
	/**
	 * hash map declaration for rooms available
	 */
	
	private static Map<String, Double> roomAvailable = new HashMap<>();
	static {
		roomAvailable.put(MessageConstants.MOUNTAINVIEW, 25000.0);
		roomAvailable.put(MessageConstants.OCEANVIEW, 20000.0);
		roomAvailable.put(MessageConstants.CITYVIEW, 15000.0);
	}
	
	/**
	 * method to access the HashMap outside the class
	 * @return HashMap
	 */
	public static Map<String, Double> getRoomAvailable() {
		return roomAvailable;
	}

}
