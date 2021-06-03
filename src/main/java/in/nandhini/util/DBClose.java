package in.nandhini.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.nandhini.exception.InvalidException;

public class DBClose {

	private DBClose() throws InvalidException {
		throw new InvalidException("Invalid Entry");
	}

	/**
	 * constructor overloading with two parameters
	 * 
	 * @param pst
	 * @param con
	 */
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

	/**
	 * Constructor overloading with three parameter
	 * 
	 * @param rs
	 * @param pst
	 * @param con
	 */
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
