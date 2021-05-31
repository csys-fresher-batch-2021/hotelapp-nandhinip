package in.nandhini.service;

import java.util.Map;
import in.nandhini.exception.IllegalArgumentExp;
import in.nandhini.exception.NullPointerExp;
import in.nandhini.model.AdminInfo;

public class FindUserAndAdmin {

	private FindUserAndAdmin() {
		IllegalArgumentExp.illegalArgumentConstructor();
	}

	public static boolean getAdmin(Long admin, String password) {
		boolean valid = false;
		Map<String, Long> administrator = AdminInfo.getAdmin();
		try{
			for (String pwd : administrator.keySet()) {
			long adminPh = administrator.get(pwd);
			if (adminPh==(admin) && pwd.equals(password)) {
				valid = true;
				break;
			}
		}
	}catch(NullPointerException e)
	{
		NullPointerExp.nullInput();
	}return valid;
	}

	public static boolean validLogin(long mobNo, String givenPwd) {
		boolean userValid = false;
		boolean exists=UserManager.userExists(mobNo);
		if(exists) {
			String storedPwd=UserManager.getPwd(mobNo);
			if(storedPwd.equals(givenPwd)) {
				userValid=true;
			}
		}
		return userValid;
	}

}
