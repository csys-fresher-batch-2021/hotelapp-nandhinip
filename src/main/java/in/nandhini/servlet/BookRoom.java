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

import in.nandhini.service.BillManager;

/**
 * Servlet implementation class BookRoom
 */
@WebServlet("/BookRoom")
public class BookRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookRoom() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkInDate = request.getParameter("cid");
		String checkOutDate = request.getParameter("cod");
		String acOption = request.getParameter("AcOption");
		String poolOption = request.getParameter("poolOption");
		String transport = request.getParameter("transportOption");
		String suiteType = request.getParameter("suiteType");
		List<String> list = new ArrayList<>(
				Arrays.asList(checkInDate, checkOutDate, suiteType, acOption, poolOption, transport));

		LinkedHashMap<String, Double> priceList = BillManager.totalBill(list);
		try {
			request.setAttribute("BILL", priceList);
			request.getRequestDispatcher("/BillDisplay.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

	}

}
