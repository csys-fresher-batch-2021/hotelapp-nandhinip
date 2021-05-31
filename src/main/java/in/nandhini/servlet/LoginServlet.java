package in.nandhini.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nandhini.service.FindUserAndAdmin;
import in.nandhini.service.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("######## Login Servlet ###########");
		HttpSession session = request.getSession();
		// Step 1: Get form values
		String userPh = request.getParameter("userPh");
		String password = request.getParameter("password");
		Long userMobNo = Long.parseLong(userPh);
		
		
		boolean adminValid=FindUserAndAdmin.getAdmin(userMobNo, password);
		boolean userValid=FindUserAndAdmin.validLogin(userMobNo, password);
		if (adminValid) {
			session.setAttribute("LOGGED_IN_USER", "admin");
			session.setAttribute("ROLE", "role");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/EditRoom.jsp");
			dispatcher.forward(request, response);
		} else if (userValid) {
			String username=UserManager.getName(userMobNo);
			session.setAttribute("LOGGED_IN_USER", username);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp?errorMessage=Invalid login credentials");
		}
		
	}

}
