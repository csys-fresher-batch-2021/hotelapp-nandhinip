package in.nandhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.nandhini.exception.DBException;
import in.nandhini.exception.InvalidEntry;
import in.nandhini.util.DBClose;
import in.nandhini.util.DBConnection;

public class UserDAOSearchUserDetail {

	/**
	 * constructor
	 * 
	 * @throws InvalidEntry
	 */
	private UserDAOSearchUserDetail() throws InvalidEntry {
		throw new InvalidEntry("Invalid Entry");
	}

	/**
	 * Get user name with their mobile number
	 * 
	 * @param mobNo
	 * @return
	 * @throws Exception
	 */
	public static String getName(long mobNo) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String name = null;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "select user_name from registered_user where mobile_No=" + mobNo;
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();
			if (rs.next()) {
				name = rs.getString("user_name");
			}

		} catch (SQLException e) {
			throw new DBException("Unable to fetch user Name");
		} finally {
			DBClose.close(rs, pst, con);
		}
		return name;
	}

	/**
	 * get password of the user from mobile number
	 * 
	 * @param mobNo
	 * @return
	 * @throws Exception
	 */
	public static String getPwd(long mobNo) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String pwd = null;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "select pass_word from registered_user where mobile_No=" + mobNo;
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();
			if (rs.next()) {
				pwd = rs.getString("pass_word");
			}

		} catch (SQLException e) {
			throw new DBException("Unable to fetch user Password");
		} finally {
			DBClose.close(rs, pst, con);
		}
		return pwd;
	}

	/**
	 * To check whether the user exists or not
	 * 
	 * @param mobNo
	 * @return
	 * @throws Exception
	 */
	public static boolean exists(long mobNo) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean exists = false;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "select mobile_No from registered_user where mobile_No=" + mobNo;
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();
			if (rs.next()) {
				exists = true;
			}

		} catch (SQLException e) {
			throw new DBException("user does'nt exists");
		} finally {
			DBClose.close(rs, pst, con);
		}
		return exists;
	}

}
