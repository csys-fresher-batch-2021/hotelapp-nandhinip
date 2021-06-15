package in.nandhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nandhini.service.UserManager;
import in.nandhini.validation.UserValidation;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// getting user name, mobile number and password
		String name = request.getParameter("name");
		long mobileNo = 0;
		try {
			mobileNo = Long.parseLong(request.getParameter("userMobile"));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");

		/**
		 * check whether user exists or not before login
		 */
		boolean exists = UserManager.userExists(mobileNo);

		// checking the details are valid or not
		try {
			Boolean valid = UserValidation.checkAndAddUser(mobileNo, pwd, name, gender);
			if (Boolean.TRUE.equals(valid)) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else if (exists) {
				request.setAttribute("errorMessage", "User Already Exists!");
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Use Valid Credentials as per given instructions!");
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
