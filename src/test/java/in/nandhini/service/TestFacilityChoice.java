package in.nandhini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		double output = 0;
		output = FacilityValidation.acNonAcSelection(acChoice);
		assertEquals(10.0,output,0.001);
	}

	@Test
	public void withAc() {
		String acChoice =MessageConstants.WITHAC;
		double output = 0;
		output = FacilityValidation.acNonAcSelection(acChoice);
		assertEquals(30.0,output,0.0001);
	}

	/**
	 * test case for food and without food
	 */
	@Test
	public void withoutPool() {
		String poolChoice = MessageConstants.WITHOUTPOOL;
		double output = 0;
		output = FacilityValidation.poolAccess(poolChoice);
		assertEquals(0.0,output,0.0001);
	}

	@Test
	public void withPool() {
		String poolChoice = MessageConstants.WITHPOOL;
		double output = 0;
		output = FacilityValidation.poolAccess(poolChoice);
		assertEquals(2500.0,output,0.0001);
	}

	/**
	 * test case for Pick-Up and Drop
	 */
	@Test
	public void withoutPickUpDrop() {
		String pickUpDropChoice = MessageConstants.NOTRANSPORT;
		double output = 0;
		output = FacilityValidation.transportSelection(pickUpDropChoice);
		assertEquals(0.0,output,0.0001);
	}

	@Test
	public void withPickUpDrop() {
		String pickUpDropChoice =MessageConstants.TRANSPORT;
		double output = 0;
		output = FacilityValidation.transportSelection(pickUpDropChoice);
		assertEquals(1000.0,output,0.0001);
	}

	/**
	 * test cases for invalid AC option
	 */
	@Test
	public void invalidAcOption() {
		double output=0;
		try {
		    output=FacilityValidation.acNonAcSelection(" ");
			fail();
		} catch (Exception e) {
			assertEquals(0.0,output,0.01);
		}
	}

	/**
	 * Test case for invalid Food Option
	 */
	@Test
	public void invalidPoolOption() {
		double output=0;
		try {
			output=FacilityValidation.poolAccess("");
			fail();
		} catch (Exception e) {
			assertEquals(0.0,output,0.01);
		}
	}

	/**
	 * test case for invalid PickUpDrop Option
	 */
	@Test
	public void invalidPickUpDropOption() {
		double output=0;
		try {
			output=FacilityValidation.transportSelection("");
			fail();
		} catch (Exception e) {
			assertEquals(0.0,output,0.01);
		}
	}

}
