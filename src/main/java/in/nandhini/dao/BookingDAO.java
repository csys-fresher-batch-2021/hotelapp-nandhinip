package in.nandhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.nandhini.exception.DBException;
import in.nandhini.exception.InvalidException;
import in.nandhini.model.BookingInfo;
import in.nandhini.model.MessageConstants;
import in.nandhini.util.DBClose;
import in.nandhini.util.DBConnection;

public class BookingDAO {

	private BookingDAO() throws InvalidException {
		throw new InvalidException("Constructor");
	}

	/**
	 * insert user booking details in DAO
	 * 
	 * @param choice
	 * @param bookDate
	 * @throws Exception
	 * @throws SQLException
	 */
	public static void save(List<Object> choice, LocalDateTime bookDate) throws DBException {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBConnection.getConnection();

			// Step 2: Prepare data
			String sql = "insert into bookRoom(mobile_No,booked_date,check_in,"
					+ "suite_Type,ac_choice,pool_choice,transport_choice,bill_amount_estimation,"
					+ "status) values ( ?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setLong(1, (long) choice.get(0));
			Timestamp bookingDate = Timestamp.valueOf(bookDate);
			pst.setTimestamp(2, bookingDate);
			LocalDateTime cin = LocalDateTime.parse((CharSequence) choice.get(1));
			Timestamp checkIn = Timestamp.valueOf(cin);
			pst.setTimestamp(3, checkIn);
			pst.setString(4, (String) choice.get(2));
			pst.setString(5, (String) choice.get(3));
			pst.setString(6, (String) choice.get(4));
			pst.setString(7, (String) choice.get(5));
			pst.setDouble(8, (Double) choice.get(6));
			pst.setBoolean(9, true);

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
	 * retrieve booking details of user from DAO
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<BookingInfo> getAllBookingDetails() throws DBException {
		List<BookingInfo> bookingDetails = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "select ru.mobile_No, ru.user_name,rb.booked_date,rb.check_in,"
					+ "rb.suite_Type,rb.ac_choice,rb.pool_choice,rb.transport_choice,"
					+ "rb.bill_amount_estimation,rb.status,rb.modified_date from registered_user ru,"
					+ "bookRoom rb where ru.mobile_No=rb.mobile_no ORDER BY check_in";
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();
			while (rs.next()) {
				long mobNo = rs.getLong("mobile_No");
				String name = rs.getString("user_name");
				Timestamp bookDate = rs.getTimestamp("booked_date");
				Timestamp checkin = rs.getTimestamp("check_in");
				String suiteType = rs.getString("suite_Type");
				String acChoice = rs.getString("ac_choice");
				String poolChoice = rs.getString("pool_choice");
				String tansport = rs.getString("transport_choice");
				double amount = rs.getDouble("bill_amount_estimation");
				boolean status = rs.getBoolean("status");
				Timestamp modDate = rs.getTimestamp("modified_date");

				BookingInfo bookDetail = new BookingInfo();
				bookDetail.setMobNo(mobNo);
				bookDetail.setName(name);
				bookDetail.setBookDate(bookDate);
				bookDetail.setCheckIn(checkin);
				bookDetail.setSuite(suiteType);
				bookDetail.setAcChoice(acChoice);
				bookDetail.setPoolChoice(poolChoice);
				bookDetail.setTransport(tansport);
				bookDetail.setAmount(amount);
				bookDetail.setStatus(status);
				bookDetail.setModDate(modDate);

				bookingDetails.add(bookDetail);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch Booking Details");
		} finally {
			DBClose.close(rs, pst, con);
		}
		return bookingDetails;
	}

	/**
	 * Check "Mountain View Room" availability
	 * 
	 * @return
	 * @throws Exception
	 */
	public static int getRoomAvailability(String room) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int availability = 0;
		try {

			// Step 1: Get the connection
			con = DBConnection.getConnection();

			// Step 2: Query
			String sql = "SELECT COUNT(*) as availability from bookRoom WHERE check_in >= now()"
					+ "and status=true AND suite_Type=" + "'" + room + "'";
			pst = con.prepareStatement(sql);

			// Step 3: execute query
			rs = pst.executeQuery();

			if (rs.next()) {

				availability = rs.getInt("availability");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(MessageConstants.AVAILABILITY);
		} finally {
			DBClose.close(pst, con);
		}
		return availability;
	}

}
