package in.nandhini.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nandhini.service.BillManager;

/**
 * Servlet implementation class BookRoom
 */
@WebServlet("/BookRoom")
public class BookRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * read data from JSP and send it to service layer bill Manger and calculate
	 * estimationF
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String checkInDate = request.getParameter("cid");
		String checkOutDate = request.getParameter("cod");
		String acOption = request.getParameter("AcOption");
		String poolOption = request.getParameter("poolOption");
		String transport = request.getParameter("transportOption");
		String suiteType = request.getParameter("suiteType");

		// setting choices in session, to get that in BillDisplay Servlet
		session.setAttribute("CHECK_IN", checkInDate);
		session.setAttribute("SUITE", suiteType);
		session.setAttribute("AC", acOption);
		session.setAttribute("POOL", poolOption);
		session.setAttribute("TRANSPORT", transport);

		// sending choice list to bill manager
		List<String> list = new ArrayList<>(
				Arrays.asList(checkInDate, checkOutDate, suiteType, acOption, poolOption, transport));

		// bill manager returns choices along with its price
		LinkedHashMap<String, Double> priceList = (LinkedHashMap<String, Double>) BillManager.totalBill(list);
		try {
			session.setAttribute("BILL", priceList);
			request.getRequestDispatcher("/BillDisplay.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

	}

}
