package in.nandhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nandhini.exception.InvalidException;
import in.nandhini.service.OnlinePayment;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Payment() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardType=request.getParameter("card");
		String cardNo=request.getParameter("cardNum");
		String validYr=request.getParameter("mon");
		String cvvNo=request.getParameter("cvv");
		
		boolean valid = false;
		try {
			valid = OnlinePayment.allCardOrientedValidityCheck(cardNo, validYr, cvvNo);
		} catch (InvalidException e) {
			e.printStackTrace();
		}
		if (valid) {
			response.sendRedirect("login.jsp");
		}
	}

}
