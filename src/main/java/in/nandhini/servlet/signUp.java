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
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserValidation.CheckAndAddUser(serialVersionUID, getServletInfo(), getServletName());
		
	// getting user name, mobile number and password
		String name = request.getParameter("name");
		long mobileNo = Long.parseLong(request.getParameter("MobileNumber"));
		String pwd = request.getParameter("password");
	
	//checking the details are valid or not
		boolean isAdded = UserValidation.CheckAndAddUser(mobileNo, pwd, name);
		if (isAdded == true) {
			response.sendRedirect("login.jsp");// if valid redirect to login page
		} else {
			response.sendRedirect("SignUp.jsp");// if not remain in same page
		}
	}

}
