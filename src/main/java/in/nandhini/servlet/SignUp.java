package in.nandhini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.nandhini.validation.UserValidation;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserValidation.checkAndAddUser(serialVersionUID, getServletInfo(), getServletName());

		// getting user name, mobile number and password
		String name = null;
		long mobileNo = 0;
		String pwd = null;
		try {
			name = request.getParameter("name");
			mobileNo = Long.parseLong(request.getParameter("MobileNumber"));
			pwd = request.getParameter("password");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// checking the details are valid or not
		try {
			if (UserValidation.checkAndAddUser(mobileNo, pwd, name).equals(true)) {
				response.sendRedirect("login.jsp");// if valid redirect to login page
			} else {
				response.sendRedirect("SignUp.jsp");// if not remain in same page
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
