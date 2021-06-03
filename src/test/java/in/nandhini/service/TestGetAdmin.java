package in.nandhini.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.nandhini.exception.InvalidException;
import in.nandhini.model.MessageConstants;

public class TestGetAdmin {

	@Test
	public void testAdminWithValid() {
		boolean output = false;
		try {
			output = FindUserAndAdmin.getAdmin(9900990090L, "admin123");
		} catch (InvalidException e) {
			e.printStackTrace();
		}
		assertTrue(output);
	}

	@Test
	public void testAdminWithEmptyString() {
		try {
			FindUserAndAdmin.getAdmin(56789L, "");
		} catch (Exception e) {
			assertEquals(MessageConstants.NULL_VALUE, e.getMessage());
		}
	}
	
	@Test
	public void testAdminWithNull() {
		try {
			FindUserAndAdmin.getAdmin(null,null);
		} catch (Exception e) {
			assertEquals(null, e.getMessage());
		}
	}


}
