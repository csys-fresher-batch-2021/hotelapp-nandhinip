package in.nandhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import in.nandhini.exception.DBException;
import in.nandhini.exception.InvalidEntry;
import in.nandhini.model.UserInfo;
import in.nandhini.util.DBClose;
import in.nandhini.util.DBConnection;

public class UserDAOInsert {

	private UserDAOInsert() throws InvalidEntry {
		throw new InvalidEntry("Invalid Entry");
	}

	/**
	 * saving user details in database
	 * 
	 * @param user
	 * @throws Exception
	 * @throws SQLException
	 */
	public static void save(UserInfo user) throws DBException {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBConnection.getConnection();

			// Step 2: Prepare data
			String sql = "insert into registered_user(mobile_No,user_name,pass_word,gender) values ( ?,?,?,? )";
			pst = con.prepareStatement(sql);
			pst.setLong(1, user.getMobileNo());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getGender());

			// Step 3: Execute Query ( insert/update/delete - call executeUpdate() )
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to add user");
		} finally {

			DBClose.close(pst, con);
		}
	}

	/**
	 * add the user to the list
	 * 
	 * @param users
	 * @throws Exception
	 */
	public static void save(List<UserInfo> users) throws DBException {
		for (UserInfo user : users) {
			save(user);
		}
	}

}
