package in.nandhini.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.nandhini.model.MessageConstants;
import in.nandhini.validation.FacilityValidation;

public class TestFacilityChoice {

	/**
	 * test case for AC and NON-AC
	 */
	@Test
	public void withoutAc() {
		String acChoice = MessageConstants.WITHOUTAC;
		double output = FacilityValidation.acNonAcSelection(acChoice);
		assertEquals(10.0,output,0.0001);
	}

	@Test
	public void withAc() {
		String acChoice =MessageConstants.WITHAC;
		double output = FacilityValidation.acNonAcSelection(acChoice);
		assertEquals(30.0,output,0.0001);
	}

	/**
	 * test case for food and without food
	 */
	@Test
	public void withoutPool() {
		String poolChoice = MessageConstants.WITHOUTPOOL;
		double output = FacilityValidation.poolAccess(poolChoice);
		assertEquals(0.0,output,0.0001);
	}

	@Test
	public void withPool() {
		String poolChoice = MessageConstants.WITHPOOL;
		double output = FacilityValidation.poolAccess(poolChoice);
		assertEquals(2500.0,output,0.0001);
	}

	/**
	 * test case for Pick-Up and Drop
	 */
	@Test
	public void withoutPickUpDrop() {
		String pickUpDropChoice = MessageConstants.NOTRANSPORT;
		double output = FacilityValidation.transportSelection(pickUpDropChoice);
		assertEquals(0.0,output,0.0001);
	}

	@Test
	public void withPickUpDrop() {
		String pickUpDropChoice =MessageConstants.TRANSPORT;
		double output = FacilityValidation.transportSelection(pickUpDropChoice);
		assertEquals(1000.0,output,0.0001);
	}

	/**
	 * test cases for invalid AC option
	 */
	@Test
	public void invalidAcOption() {
		try {
			FacilityValidation.acNonAcSelection(" ");
			fail();
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALIDCHOICE, e.getMessage());
		}
	}

	/**
	 * Test case for invalid Food Option
	 */
	@Test
	public void invalidPoolOption() {
		try {
			FacilityValidation.poolAccess("");
			fail();
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALIDCHOICE, e.getMessage());
		}
	}

	/**
	 * test case for invalid PickUpDrop Option
	 */
	@Test
	public void invalidPickUpDropOption() {
		try {
			FacilityValidation.transportSelection("");
			fail();
		} catch (Exception e) {
			assertEquals(MessageConstants.INVALIDCHOICE, e.getMessage());
		}
	}

}
