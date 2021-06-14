package in.nandhini.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nandhini.service.OnlinePayment;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cardNo = request.getParameter("cardNum");
		String validYr = request.getParameter("mon");
		String cvvNo = request.getParameter("cvv");

		boolean valid = false;
		try {
			valid = OnlinePayment.allCardOrientedValidityCheck(cardNo, validYr, cvvNo);
			if (valid) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
				dispatcher.forward(request, response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
