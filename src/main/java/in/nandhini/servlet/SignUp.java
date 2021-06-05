package in.nandhini.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nandhini.validation.UserValidation;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// getting user name, mobile number and password
		String name = request.getParameter("name");
		long mobileNo = Long.parseLong(request.getParameter("userMobile"));
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		System.out.println(mobileNo);

		// checking the details are valid or not
		Boolean valid = UserValidation.checkAndAddUser(mobileNo, pwd, name, gender);
		if (valid) {
			response.sendRedirect("login.jsp");// if valid redirect to login page
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Already Exists!');");
			out.println("location='SignUp.jsp';");
			out.println("</script>");
		}
	}

}
