package in.nandhini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String mobileNo = request.getParameter("mobNo");
			Long userMobNo = Long.parseLong(mobileNo);
			session.setAttribute("MOBILE_NO", userMobNo);
			String pwd = UserManager.getPwd(userMobNo);
			session.setAttribute("PASSWORD", pwd);
			System.out.println(pwd);
			response.sendRedirect("forgotPwd.jsp");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
