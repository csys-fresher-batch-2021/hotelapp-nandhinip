package in.nandhini.service;

import java.util.ArrayList;
import java.util.List;

import in.nandhini.dao.UserDAOInsert;
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
		for (UserInfo user_Info : userDetails) {
			Long mobileNo = user_Info.getMobileNo();
			if (mobileNo.equals(mobNo)) {
				pwd = user_Info.getPassword();
				break;
			}
		}
		return pwd;
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
}
