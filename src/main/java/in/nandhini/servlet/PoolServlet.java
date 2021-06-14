package in.nandhini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.nandhini.service.DisplayFacility;

/**
 * Servlet implementation class PoolServlet
 */
@WebServlet("/PoolServlet")
public class PoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			Map<String, Double> pool = DisplayFacility.getPoolAccessOption();
			String obj = gson.toJson(pool);
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
