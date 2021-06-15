package in.nandhini.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nandhini.exception.InvalidException;
import in.nandhini.service.FindUserAndAdmin;
import in.nandhini.service.UserManager;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * get data from web page
		 */
		try {
			HttpSession session = request.getSession();
			// Step 1: Get form values
			String userPh = request.getParameter("userPh");
			Long userMobNo = Long.parseLong(userPh);
			String password = request.getParameter("pwd");

			/**
			 * check whether user exists or not before login
			 */
			boolean exists = UserManager.userExists(userMobNo);

			/**
			 * check whether it is admin or not and take assigned action
			 */

			boolean adminValid = FindUserAndAdmin.getAdmin(userMobNo, password);
			boolean userValid = FindUserAndAdmin.validLogin(userMobNo, password);

			if (adminValid) {
				session.setAttribute("LOGGED_IN_USER", "admin");
				response.sendRedirect("AdminView.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminView.jsp");
				dispatcher.forward(request, response);
			} else if (userValid) {
				String username = UserManager.getName(userMobNo);
				session.setAttribute("LOGGED_IN_USER", username);
				session.setAttribute("MOB_NO", userMobNo);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else if (exists) {
				request.setAttribute("errorMessage", "Invalid password!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "User does not Exists!! Kindly register");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (InvalidException | IOException | ServletException e) {
			e.printStackTrace();
		}

	}

}
