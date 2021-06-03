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
    
    public CancelOrder() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("id");
		Integer id=Integer.parseInt(idStr);
		boolean cancelled=Cart.cancelOrder(id);
		request.setAttribute("CANCELLED", cancelled);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
		dispatcher.forward(request, response);
	}

	

}