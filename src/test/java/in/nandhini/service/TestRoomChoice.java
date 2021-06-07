package in.nandhini.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.nandhini.validation.RoomChoiceValidation;

public class TestRoomChoice {


	/**
	 * Testing room choice with appropriate choice
	 */
	@Test
	public void mountainView() {
		String roomChoice = "Mountain View";
		double output =  RoomChoiceValidation.roomsPrice(roomChoice);
		assertEquals(25000.0,output,0.01);
	}

	@Test
	public void oceanView() {
		String roomChoice = "Night Ocean View";
		double output = RoomChoiceValidation.roomsPrice(roomChoice);
		assertEquals(20000.0,output,0.01);
	}

	@Test
	public void cityView() {
		String roomChoice = "Night City View";
		double output;
		output = RoomChoiceValidation.roomsPrice(roomChoice);
		assertEquals(15000.0,output,0.01);
	}

	/**
	 * In case of Invalid User room choice selection
	 */
	@Test
	public void InvalidroomChoice() {
			String roomChoice = "";
			double output= RoomChoiceValidation.roomsPrice(roomChoice);
			assertEquals(0.0,output,0.01);
			
	}
}
