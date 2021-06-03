package in.nandhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.nandhini.util.DBClose;
import in.nandhini.util.DBConnection;

public class UserDAOSearchUserDetail{

	public static String getName(long mobNo) throws Exception {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String name = null;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "select user_name from registered_user where mobile_No="+mobNo;
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();
			if (rs.next()) {
				name = rs.getString("user_name");
			}

		} catch (SQLException e) {
			throw new Exception("Unable to fetch user Name");
		} finally {
			DBClose.close(rs, pst, con);
		}
		return name;
	}
	
	
	public static String getPwd(long mobNo) throws Exception {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String pwd = null;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "select pass_word from registered_user where mobile_No="+mobNo;
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();
			if (rs.next()) {
				pwd = rs.getString("pass_word");
			}

		} catch (SQLException e) {
			throw new Exception("Unable to fetch user Password");
		} finally {
			DBClose.close(rs, pst, con);
		}
		return pwd;
	}
	
	public static boolean exists(long mobNo) throws Exception {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean exists=false;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "select mobile_No from registered_user where mobile_No="+mobNo;
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();
			if (rs.next()) {
				exists=true;
			}

		} catch (SQLException e) {
			throw new Exception("user does'nt exists");
		} finally {
			DBClose.close(rs, pst, con);
		}
		return exists;
	}

}
