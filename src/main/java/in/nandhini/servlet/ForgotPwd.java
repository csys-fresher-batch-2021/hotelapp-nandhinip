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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPwd() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String mobileNo = request.getParameter("mobNo");
			Long userMobNo = Long.parseLong(mobileNo);
			String pwd = UserManager.getPwd(userMobNo);

			Gson gson = new Gson();
			String password = gson.toJson(pwd);
			System.out.println(password);
			PrintWriter out = response.getWriter();
			out.println(password);
			out.flush();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}