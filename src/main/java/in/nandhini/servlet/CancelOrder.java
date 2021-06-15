package in.nandhini.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nandhini.service.Cart;

/**
 * Servlet implementation class CancelOrder
 */
@WebServlet("/CancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * getting the id number from service layer and updating the particular booking
		 * details as false
		 */
		try {
			String idStr = request.getParameter("id");
			Integer id = Integer.parseInt(idStr);
			boolean cancelled=Cart.cancelOrder(id);
			if(cancelled) {
			request.setAttribute("message", "Booking Cancelled!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
			dispatcher.forward(request, response);
		} catch (NumberFormatException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
