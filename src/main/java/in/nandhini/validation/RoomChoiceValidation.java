package in.nandhini.validation;

import in.nandhini.exception.IllegalArgumentExp;
import in.nandhini.model.MessageConstants;
import in.nandhini.service.DisplayRooms;

public class RoomChoiceValidation {
	
	private RoomChoiceValidation() {
		IllegalArgumentExp.illegalArgumentConstructor();
	}
	/**
	 * displaying chosen room with amount
	 * 
	 * @param roomChoice
	 * @return roomAmount
	 */
	public static double roomsPrice(String roomChoice) {
		double roomAmount = 0;
		if (roomChoice.equalsIgnoreCase(MessageConstants.MOUNTAINVIEW)|| 
			roomChoice.equalsIgnoreCase(MessageConstants.OCEANVIEW) ||
			roomChoice.equalsIgnoreCase(MessageConstants.CITYVIEW)) {
			/* Get values based on key */
			roomAmount = DisplayRooms.getRoomAvailable().get(roomChoice);
			System.out.println("Amount for the room you've booked for " + roomChoice + "with Rs." + roomAmount);
		} else {
			IllegalArgumentExp.illegalArgumentChoice();
		}
		return roomAmount;
	}
}
