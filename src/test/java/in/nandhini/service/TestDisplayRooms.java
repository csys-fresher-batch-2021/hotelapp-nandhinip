package in.nandhini.service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class TestDisplayRooms {
	/**
	 * to Display the rooms and check with no of rooms types
	 */
	@Test
	public void test() {
		DisplayRooms.displayRoomTypes();
		Map<String, Double> output = DisplayRooms.getAvailableRooms();
		assertEquals(3, output.size());
	}

}
