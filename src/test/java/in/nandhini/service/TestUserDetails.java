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
		long mobileNo = 9876543129L;
		String pwd = "esmee123";
		String name="esmee";
		Boolean output = UserValidation.checkAndAddUser(mobileNo, pwd,name,"Male");
		assertEquals(true,output);
	}

	@Test
	public void addingUserAndValidatingInvalidInput() {
		long mobileNo = 98765431L;
		String pwd = "123478";
		String name="peart";
		Boolean output = UserValidation.checkAndAddUser(mobileNo, pwd,name,null);
		assertEquals(false,output);
	}
	
	@Test
	public void getPwdByMobNo() {
		long mobNo=9999888889L;
		String pwd=UserManager.getPwd(mobNo);
		assertEquals("qwer1234", pwd);
	}

}
