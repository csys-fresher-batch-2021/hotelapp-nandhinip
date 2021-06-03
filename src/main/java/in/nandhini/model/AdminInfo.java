package in.nandhini.model;

import java.util.HashMap;
import java.util.Map;

import in.nandhini.exception.InvalidEntry;

public class AdminInfo {

	private AdminInfo() throws InvalidEntry {
	    throw new InvalidEntry("Invalid Entry into constructor");
	  }
	/**
	 * Administrator
	 */
	private static Map<String,Long>admin=new HashMap<>();
	
	public static Map<String, Long> getAdmin() {
		return admin;
	}
	public static void setAdmin(Map<String, Long> admin) {
		AdminInfo.admin = admin;
	}
	static {
	admin.put("admin123", 9900990090L);
	}
	
}
