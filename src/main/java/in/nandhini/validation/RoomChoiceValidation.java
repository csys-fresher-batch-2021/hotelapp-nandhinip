package in.nandhini.validation;

import in.nandhini.exception.InvalidException;
import in.nandhini.model.MessageConstants;
import in.nandhini.service.DisplayRooms;

public class RoomChoiceValidation {

	private RoomChoiceValidation() {
		throw new IllegalArgumentException();
	}

	/**
	 * displaying chosen room with amount
	 * 
	 * @param roomChoice
	 * @return roomAmount
	 * @throws InvalidException
	 */
	public static double roomsPrice(String roomChoice) {
		double roomAmount = 0;
		if (roomChoice.equalsIgnoreCase(MessageConstants.MOUNTAINVIEW)
				|| roomChoice.equalsIgnoreCase(MessageConstants.OCEANVIEW)
				|| roomChoice.equalsIgnoreCase(MessageConstants.CITYVIEW)) {
			/* Get values based on key */
			try {
				roomAmount = DisplayRooms.getRoomAvailable().get(roomChoice);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
		return roomAmount;
	}
}
