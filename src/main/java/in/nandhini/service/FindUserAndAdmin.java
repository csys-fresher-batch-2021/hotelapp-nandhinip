package in.nandhini.service;

import java.util.List;
import java.util.Map;

import in.nandhini.exception.IllegalArgumentExp;
import in.nandhini.exception.NullPointerExp;
import in.nandhini.model.AdminInfo;
import in.nandhini.model.UserInfo;

public class FindUserAndAdmin {

	private FindUserAndAdmin() {
		IllegalArgumentExp.illegalArgumentConstructor();
	}

	public static boolean getAdmin(String admin, String password) {
		boolean valid = false;
		Map<String, String> administrator = AdminInfo.getAdmin();
		try{
			for (String pwd : administrator.keySet()) {
			String adminName = administrator.get(pwd);
			if (adminName.equals(admin.toLowerCase()) && pwd.equals(password)) {
				valid = true;
				break;
			}
		}
	}catch(NullPointerException e)
	{
		NullPointerExp.nullInput();
	}return valid;
	}

	public static boolean getUser(String user, String pwd) {
		boolean userValid = false;
		List<UserInfo> users = UserManager.getUserDetails();
		try {
			for (UserInfo userInfo : users) {
				String userName = userInfo.getName();
				String userPwd = userInfo.getPassword();
				userValid = userName.equals(user.toLowerCase()) && userPwd.equals(pwd);
				if (userValid) {
					break;
				}
			}
		} catch (NullPointerException e) {
			NullPointerExp.nullInput();
		}
		return userValid;
	}

}
