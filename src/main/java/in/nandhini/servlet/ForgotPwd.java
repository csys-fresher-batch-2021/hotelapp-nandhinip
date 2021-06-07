package in.nandhini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.nandhini.service.UserManager;

/**
 * Servlet implementation class ForgotPwd
 */
@WebServlet("/ForgotPwd")
public class ForgotPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * getting the user mobile number from session and get password from service
		 * layer.
		 */
		try {
			String mobileNo = request.getParameter("mobNo");
			Long userMobNo = Long.parseLong(mobileNo);
			String pwd = UserManager.getPwd(userMobNo);

			/**
			 * Send the pwd as json object and displayed as alert.
			 */
			Gson gson = new Gson();
			String password = gson.toJson(pwd);
			PrintWriter out = response.getWriter();
			out.println(password);
			out.flush();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
