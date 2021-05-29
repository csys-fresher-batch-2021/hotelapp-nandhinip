package in.nandhini.model;

import java.util.HashMap;
import java.util.Map;

import in.nandhini.exception.IllegalArgumentExp;

public class AdminInfo {

	private AdminInfo() {
	    IllegalArgumentExp.illegalArgumentConstructor();
	  }
	/**
	 * Administrator
	 */
	private static Map<String,String>admin=new HashMap<>();
	
	public static Map<String, String> getAdmin() {
		return admin;
	}
	public static void setAdmin(Map<String, String> admin) {
		AdminInfo.admin = admin;
	}
	static {
	admin.put("admin123", "admin");
	}
	
	public static String adminName() {
		String name=null;
		for (String user_Info : admin.keySet()) {
			name=user_Info;
		}return name;
	}
}
