package in.nandhini.service;

import java.util.HashMap;
import java.util.Map;

public class DisplayRooms {
	/**
	 * hash map declaration
	 */
	private static Map<String, Double> roomAvailable = new HashMap<String, Double>();
	static {
		roomAvailable.put(MessageConstants.moutainView, 25000.0);
		roomAvailable.put(MessageConstants.oceanView, 20000.0);
		roomAvailable.put(MessageConstants.cityView, 15000.0);
	}
	public static Map<String, Double> getAvailableRooms() {
		return roomAvailable;
	}

	/**
	 * listing the rooms available in the hotel
	 */
	public static void displayRoomTypes() {
		System.out.println("/*** Available Rooms ***/");
		for (String rooms : DisplayRooms.roomAvailable.keySet()) {
			double price = DisplayRooms.roomAvailable.get(rooms);
			System.out.println("Room --> " + rooms + ", Price --> " + price);
		}
	}
}
