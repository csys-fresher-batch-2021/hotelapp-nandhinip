package in.nandhini.service;

import java.util.Map;
import in.nandhini.exception.InvalidException;
import in.nandhini.exception.InvalidEntry;
import in.nandhini.model.AdminInfo;

public class FindUserAndAdmin {

	private FindUserAndAdmin() throws InvalidEntry {
		throw new InvalidEntry("Invalid Entry into constructor");
	}

	public static boolean getAdmin(Long admin, String password) throws InvalidException {
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
		throw new InvalidException("This is not an Admin");
	}return valid;
	}

	public static boolean validLogin(long mobNo, String givenPwd) {
		boolean userValid = false;
		boolean exist=UserManager.userExists(mobNo);
		if(exist) {
			String storedPwd=UserManager.getPwd(mobNo);
			if(storedPwd.equals(givenPwd)) {
				userValid=true;
				System.out.println(userValid);
			}
		}
		return userValid;
	}

}
