package in.nandhini.validation;

import in.nandhini.exception.IllegalArgumentExp;
import in.nandhini.service.DisplayFacility;
import in.nandhini.model.MessageConstants;

public class FacilityValidation {
	
	private FacilityValidation() {
		IllegalArgumentExp.illegalArgumentChoice();
	}
	/**
	 * to check AC selection is valid or not
	 * 
	 * @param acChoice
	 * @return acCharges
	 */
	public static double acNonAcSelection(String acChoice) {
		double acCharges = 0;
		if (acChoice.equalsIgnoreCase(MessageConstants.WITHAC)
				|| acChoice.equalsIgnoreCase(MessageConstants.WITHOUTAC)) {
			acCharges = DisplayFacility.getAcOption().get(acChoice);
		} else {
			IllegalArgumentExp.illegalArgumentChoice();
		}
		return acCharges;
	}

	/**
	 * to check pool selection is valid or not
	 * 
	 * @param poolChoice
	 * @return poolCharges
	 */
	public static double poolAccess(String poolChoice) {
		double poolCharges = 0;
		if (poolChoice.equalsIgnoreCase(MessageConstants.WITHPOOL)
				|| poolChoice.equalsIgnoreCase(MessageConstants.WITHOUTPOOL)) {
			poolCharges = DisplayFacility.getPoolAccessOption().get(poolChoice);
		} else {
			IllegalArgumentExp.illegalArgumentChoice();
		}
		return poolCharges;
	}

	/**
	 * to check Pick-Up and Drop selection is valid or not
	 * 
	 * @param pickUpDropChoice
	 * @return pickUpDropCharges
	 */
	public static double transportSelection(String pickUpDropChoice) {
		double pickUpDropCharges = 0;
		if (pickUpDropChoice.equalsIgnoreCase(MessageConstants.TRANSPORT)
				|| pickUpDropChoice.equalsIgnoreCase(MessageConstants.NOTRANSPORT)) {
			pickUpDropCharges = DisplayFacility.getTransportOption().get(pickUpDropChoice);
		} else {
			IllegalArgumentExp.illegalArgumentChoice();
		}
		return pickUpDropCharges;
	}

}
