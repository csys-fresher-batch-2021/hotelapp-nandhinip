package in.nandhini.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.nandhini.validation.UserValidation;

public class TestUserDetails {

	/**
	 * add the User name, mobile number and password check their User Id(mobile Number) and
	 * password
	 */
	@Test
	public void addingUserAndValidatingValidInput() {
		long mobileNo = 9876543299L;
		String pwd = "12345678";
		String name="Pert";
		Boolean output = UserValidation.checkAndAddUser(mobileNo, pwd,name);
		assertEquals(true,output);
	}

	@Test
	public void addingUserAndValidatingInvalidInput() {
		long mobileNo = 98765431L;
		String pwd = "123478";
		String name="Peart";
		Boolean output = UserValidation.checkAndAddUser(mobileNo, pwd,name);
		assertEquals(false,output);
	}

}