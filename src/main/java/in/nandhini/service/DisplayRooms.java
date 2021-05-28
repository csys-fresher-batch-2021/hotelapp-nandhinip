package in.nandhini.service;

import java.util.HashMap;
import java.util.Map;

import in.nandhini.model.MessageConstants;

public class DisplayRooms {

	/**
	 * as constructor concept require at least one non-public constructor
	 */
	private DisplayRooms() {
		throw new IllegalArgumentException();
	}

	/**
	 * hash map declaration
	 */

	private static Map<String, Double> roomAvailable = new HashMap<>();
	static {
		roomAvailable.put(MessageConstants.MOUNTAINVIEW, 25000.0);
		roomAvailable.put(MessageConstants.OCEANVIEW, 20000.0);
		roomAvailable.put(MessageConstants.CITYVIEW, 15000.0);
	}

	/**
	 * method to access the HashMap outside the class
	 * 
	 * @return HashMap
	 */
	public static Map<String, Double> getRoomAvailable() {
		return roomAvailable;
	}

	public static void setRoomAvailable(Map<String, Double> roomAvailable) {
		DisplayRooms.roomAvailable = roomAvailable;
	}

}
