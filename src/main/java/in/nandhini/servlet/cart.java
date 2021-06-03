package in.nandhini.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nandhini.model.CartInfo;
import in.nandhini.service.Cart;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public cart() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Long mobNo=(Long) session.getAttribute("MOB_NO");
		List<CartInfo>yourCart=Cart.cartDetails(mobNo);
		session.setAttribute("CART",yourCart);
		response.sendRedirect("Cart.jsp");
		
	}
}
