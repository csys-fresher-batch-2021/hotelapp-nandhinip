package in.nandhini.service;

import java.util.ArrayList;
import java.util.List;

import in.nandhini.dao.UserDAOInsert;
import in.nandhini.dao.UserDAOSearchUserDetail;
import in.nandhini.model.UserInfo;

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

	public static List<UserInfo> getUserDetails() {
		return userDetails;
	}

	/**
	 * Get password of particular user
	 * 
	 * @param mobNo
	 * @return
	 */
	public static String getPwd(long mobNo) {
		String pwd = null;
		try {
			pwd = UserDAOSearchUserDetail.getPwd(mobNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}

	public static boolean userExists(long mobNo) {
		boolean exists = false;
		try {
			exists = UserDAOSearchUserDetail.exists(mobNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;

	}

	/**
	 * Adding User ID as Mobile Number and password as 8-character String
	 * 
	 * @param mobNo
	 * @param pwd
	 */
	public static void addUser(long mobNo, String pwd, String name, String gender) {
		userDetails.add(new UserInfo(mobNo, pwd, name, gender));
		try {
			UserDAOInsert.save(userDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get Name of the particular user from database
	 * 
	 * @param mobNo
	 * @return
	 */
	public static String getName(long mobNo) {
		String name = null;
		try {
			name = UserDAOSearchUserDetail.getName(mobNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
}
