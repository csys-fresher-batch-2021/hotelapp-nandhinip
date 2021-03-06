package in.nandhini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.nandhini.service.Booking;

/**
 * Servlet implementation class RoomAvailability
 */
@WebServlet("/RoomAvailability")
public class RoomAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * get availability of room from service layer to jsp as json object
		 */
		try {
			List<Integer> avail = Booking.getAvailability();
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String object = gson.toJson(avail);
			out.println(object);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
