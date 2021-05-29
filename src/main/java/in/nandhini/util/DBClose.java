package in.nandhini.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose {

	public static void close(PreparedStatement pst, Connection con) {
		try {
			// Null Check - to avoid Null Pointer Exception
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

		}
	}

	public static void close(ResultSet rs, PreparedStatement pst, Connection con) {

		// Null Check - to avoid Null Pointer Exception
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
