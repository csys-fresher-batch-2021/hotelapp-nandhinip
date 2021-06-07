package in.nandhini.validation;

import in.nandhini.exception.InvalidException;
import in.nandhini.service.DisplayFacility;
import in.nandhini.model.MessageConstants;

public class FacilityValidation {

	private FacilityValidation() throws InvalidException {
		throw new InvalidException("Invalid Entry");
	}

	/**
	 * to check AC selection is valid or not
	 * 
	 * @param acChoice
	 * @return acCharges
	 * @throws InvalidException
	 */
	public static double acNonAcSelection(String acChoice) {
		double acCharges = 0;
		if (acChoice.equalsIgnoreCase(MessageConstants.WITHAC)
				|| acChoice.equalsIgnoreCase(MessageConstants.WITHOUTAC)) {
			acCharges = DisplayFacility.getAcOption().get(acChoice);
		} else {
			throw new IllegalArgumentException(MessageConstants.INVALIDCHOICE);
		}
		return acCharges;
	}

	/**
	 * to check pool selection is valid or not
	 * 
	 * @param poolChoice
	 * @return poolCharges
	 * @throws InvalidException
	 */
	public static double poolAccess(String poolChoice) {
		double poolCharges = 0;
		if (poolChoice.equalsIgnoreCase(MessageConstants.WITHPOOL)
				|| poolChoice.equalsIgnoreCase(MessageConstants.WITHOUTPOOL)) {
			poolCharges = DisplayFacility.getPoolAccessOption().get(poolChoice);
		} else {
			throw new IllegalArgumentException(MessageConstants.INVALIDCHOICE);
		}
		return poolCharges;
	}

	/**
	 * to check Pick-Up and Drop selection is valid or not
	 * 
	 * @param pickUpDropChoice
	 * @return pickUpDropCharges
	 * @throws InvalidException
	 */
	public static double transportSelection(String pickUpDropChoice) {
		double pickUpDropCharges = 0;
		if (pickUpDropChoice.equalsIgnoreCase(MessageConstants.TRANSPORT)
				|| pickUpDropChoice.equalsIgnoreCase(MessageConstants.NOTRANSPORT)) {
			pickUpDropCharges = DisplayFacility.getTransportOption().get(pickUpDropChoice);
		} else {
			throw new IllegalArgumentException(MessageConstants.INVALIDCHOICE);
		}
		return pickUpDropCharges;
	}

}
