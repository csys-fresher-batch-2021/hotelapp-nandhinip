package in.nandhini.service;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
	
	/**
	 * as constructor concept require at least one non-public constructor 
	 */
	private UserManager() {
	    throw new IllegalStateException();
	  }
	/**
	 * User's List
	 */
	private static List<UserInfo> userDetails = new ArrayList<>();

	/**
	 * Adding User ID as Mobile Number and password as 8-character String
	 * 
	 * @param mobNo
	 * @param pwd
	 */
	public static void addUser(long mobNo, String pwd, String name) {
		userDetails.add(new UserInfo(mobNo, pwd, name));
	}
}
