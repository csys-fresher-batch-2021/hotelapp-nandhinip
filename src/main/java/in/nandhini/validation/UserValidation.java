package in.nandhini.validation;

import in.nandhini.service.UserManager;

public class UserValidation {

	/**
	 * Constructor concept require at least one non-public constructor
	 */
	private UserValidation() {
		throw new IllegalStateException();
	}

	/**
	 * getting password and checking whether it is valid or not
	 * 
	 * @param pwd
	 * @return String
	 */
	public static String userPasswordCheck(String pwd) {
		String pwdIsValid = null;
		try {
			if (pwd.length() != 8)// TO CHECK THE LENGTH OF A STRING
			{
				throw new IllegalArgumentException();
			} else {
				pwdIsValid = "Valid Password";
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			pwdIsValid = "Invalid Password";
		}
		return pwdIsValid;
	}

	/**
	 * checking mobile number whether it is valid or not
	 * 
	 * @param mobNo
	 * @return String
	 */
	public static String mobileNumberCheck(long mobNo) {
		String ph = String.valueOf(mobNo);
		String mobIsValid = null;
		try {
			if (ph.length() != 10 || mobNo / 1000000000 == 0) {
				throw new IllegalArgumentException();
			} else {
				mobIsValid = "Valid Mobile Number";
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			mobIsValid = "Invalid Mobile Number";
		}

		return mobIsValid;
	}

	/**
	 * To check whether the user enter the valid name or not
	 * 
	 * @param name
	 * @return
	 */
	public static boolean nameValidation(String name) {
		boolean isValid = false;
		if (name.length() > 3 && name.length() < 30 && name.matches("[a-z]*")) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * To check whether the user enter the valid name or not
	 * 
	 * @param name
	 * @return
	 */
	public static boolean genderValidation(String name) {
		boolean isValid = false;
		if (name.length() > 3 && name.length() < 30 && name.matches("[A-Za-z]*")) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * checking both mobile mobile number and password and then adding user
	 */
	public static Boolean checkAndAddUser(long mobileNo, String pwd, String name, String gender) {
		Boolean added = false;
		String mobOutput = UserValidation.mobileNumberCheck(mobileNo);
		boolean exists = UserManager.userExists(mobileNo);
		String pwdOutput = UserValidation.userPasswordCheck(pwd);
		Boolean nameOutput = UserValidation.nameValidation(name);
		if (!exists) {
			if (mobOutput.equals("Valid Mobile Number") && pwdOutput.equals("Valid Password") && nameOutput) {
				UserManager.addUser(mobileNo, pwd, name, gender);
				added = true;
			}
		}
		return added;
	}
}
