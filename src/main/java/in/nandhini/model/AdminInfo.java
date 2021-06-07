package in.nandhini.model;

import java.util.HashMap;
import java.util.Map;

import in.nandhini.exception.InvalidEntry;

public class AdminInfo {

	private AdminInfo() throws InvalidEntry {
		throw new InvalidEntry("Invalid Entry into constructor");
	}

	/**
	 * Static details of Administrator
	 */
	private static Map<String, Long> admin = new HashMap<>();

	public static Map<String, Long> getAdmin() {
		return admin;
	}

	/**
	 * Hard coded password, Number for administrator
	 */
	static {
		admin.put("admin123", 9900990090L);
	}

}
