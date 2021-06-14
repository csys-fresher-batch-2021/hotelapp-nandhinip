package in.nandhini.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nandhini.service.Booking;

/**
 * Servlet implementation class BillDisplay
 */
@WebServlet("/BillDisplay")
public class BillDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * This servlet gets data from .jsp and add it to a list and send that to
		 * service layer for further process
		 * 
		 * taking the details to database after pressing book button
		 */
		HttpSession session = request.getSession();
		LinkedHashMap<String, Double> bill = (LinkedHashMap<String, Double>) session.getAttribute("BILL");
		double price = bill.get("Total with GST");
		List<Object> choice = new ArrayList<>();
		String checkInDate = (String) session.getAttribute("CHECK_IN");
		String acOption = (String) session.getAttribute("AC");
		String poolOption = (String) session.getAttribute("POOL");
		String transport = (String) session.getAttribute("TRANSPORT");
		String suiteType = (String) session.getAttribute("SUITE");
		Long mobNo = (Long) session.getAttribute("MOB_NO");

		choice.add(mobNo);
		choice.add(checkInDate);
		choice.add(suiteType);
		choice.add(acOption);
		choice.add(poolOption);
		choice.add(transport);
		choice.add(price);
		try {
			Booking.bookRoomData(choice);
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
