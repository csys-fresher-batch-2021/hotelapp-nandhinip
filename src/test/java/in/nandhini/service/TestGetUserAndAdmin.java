package in.nandhini.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.nandhini.model.MessageConstants;

public class TestGetUserAndAdmin {

	@Test
	public void testAdminWithValid() {
		boolean output = FindUserAndAdmin.getAdmin("admin", "admin123");
		assertTrue(output);
	}

	@Test
	public void testAdminWithEmptyString() {
		try {
			FindUserAndAdmin.getAdmin("", "");
		} catch (Exception e) {
			assertEquals(MessageConstants.NULL_VALUE, e.getMessage());
		}
	}
	
	@Test
	public void testAdminWithNull() {
		try {
			FindUserAndAdmin.getAdmin(null,null);
		} catch (Exception e) {
			assertEquals(MessageConstants.NULL_VALUE, e.getMessage());
		}
	}
	
	@Test
	public void testUserWithValid() {
		boolean output = FindUserAndAdmin.getUser("Pert", "qwer1234");
		assertTrue(output);
	}
	
	@Test
	public void testUserWithInValid() {
		boolean output = FindUserAndAdmin.getUser("Pert", "qwr1234");
		assertFalse(output);
	}
	
	@Test
	public void testUserWithEmptyString() {
		try {
			FindUserAndAdmin.getUser("", "");
		} catch (Exception e) {
			assertEquals(MessageConstants.NULL_VALUE, e.getMessage());
		}
	}
	
	@Test
	public void testUserWithNull() {
		try {
			FindUserAndAdmin.getUser(null, null);
		} catch (Exception e) {
			assertEquals(MessageConstants.NULL_VALUE, e.getMessage());
		}
	}


}
