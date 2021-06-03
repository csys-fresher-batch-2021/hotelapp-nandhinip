package in.nandhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.nandhini.model.CartInfo;
import in.nandhini.util.DBClose;
import in.nandhini.util.DBConnection;

public class YourCart {
	
	
	public static List<CartInfo> getCart(long mobNo) throws Exception {
	List<CartInfo> cart = new ArrayList<CartInfo>();
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	try {

		// Step 1: Get the connection
		con = DBConnection.getConnection();

		// Step 2: Query
		String sql ="select id,check_in,suite_Type,ac_choice,pool_choice,transport_choice,bill_amount_estimation from "
				+ "bookRoom where status='true' and mobile_no="+mobNo;
		pst = con.prepareStatement(sql);

		// Step 3: execute query
		rs = pst.executeQuery();
		while (rs.next()) {
			int id=rs.getInt("id");
			Timestamp checkin = rs.getTimestamp("check_in");
			LocalDateTime checkIn=checkin.toLocalDateTime();
			String suiteType = rs.getString("suite_Type");
			String acChoice = rs.getString("ac_choice");
			String poolChoice = rs.getString("pool_choice");
			String tansport = rs.getString("transport_choice");
			double amount = rs.getDouble("bill_amount_estimation");
		
			CartInfo cartDetail = new CartInfo( id,checkIn, suiteType, acChoice,
					poolChoice, tansport, amount);
			cart.add(cartDetail);
		}

	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception("Unable to fetch Booking Details");
	} finally {
		DBClose.close(rs, pst, con);
	}
	return cart;
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
			String sql = "select mobile_No from bookRoom where mobile_No="+mobNo;
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

	
	public static boolean cancelOrder(int id,LocalDateTime modDate) throws Exception, SQLException {
		// Step 1: Get connection
		boolean cancelled=false;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBConnection.getConnection();
			Timestamp modifiedDate = Timestamp.valueOf(modDate);
			System.out.println(modifiedDate+"  "+id);
			// Step 2: Prepare data
			String sql = "UPDATE bookRoom SET modified_date='"+modifiedDate+"',status=false WHERE id="+id;
			System.out.println(sql);
			pst = con.prepareStatement(sql);

			// Step 3: Execute Query ( insert/update/delete - call executeUpdate() )
			pst.executeUpdate();
			cancelled=true;
			System.out.println("cancelled");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add user");
		} finally {

			DBClose.close(pst, con);
		}return cancelled;
	}

}
