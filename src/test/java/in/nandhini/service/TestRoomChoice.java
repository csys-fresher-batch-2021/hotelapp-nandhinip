package in.nandhini.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.nandhini.model.MessageConstants;
import in.nandhini.validation.RoomChoiceValidation;

public class TestRoomChoice {


	/**
	 * Testing room choice with appropriate choice
	 */
	@Test
	public void roomChoice1() {
		String roomChoice = "Mountain View";
		double output =  RoomChoiceValidation.roomsPrice(roomChoice);
		assertTrue(output==25000.0);
	}

	@Test
	public void roomChoice2() {
		String roomChoice = "Night Ocean View";
		double output = RoomChoiceValidation.roomsPrice(roomChoice);
		assertTrue(output==20000.0);
	}

	@Test
	public void roomChoice3() {
		String roomChoice = "Night City View";
		double output =  RoomChoiceValidation.roomsPrice(roomChoice);
		assertTrue(output==15000);
	}

	/**
	 * In case of Invalid User room choice selection
	 */
	@Test
	public void InvalidroomChoice() {
		try {
			String roomChoice = " ";
			 RoomChoiceValidation.roomsPrice(roomChoice);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(MessageConstants.INVALIDCHOICE, e.getMessage());
		}
	}
}
