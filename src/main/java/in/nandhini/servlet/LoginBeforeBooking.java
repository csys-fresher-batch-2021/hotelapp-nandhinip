package in.nandhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookRoom
 */
@WebServlet("/BookRoomBeforeLogin")
public class LoginBeforeBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginBeforeBooking() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * this servlet invokes when you press book room button checks whether user is
		 * logged in or not
		 */
		HttpSession session = request.getSession();
		try {
			String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
			if (loggedInUsername != null) {
				response.sendRedirect("RoomBooking.jsp");
			} else {
				response.sendRedirect("login.jsp?errorMessage=Kindly Login Before Booking");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
