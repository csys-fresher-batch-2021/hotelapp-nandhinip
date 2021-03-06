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

import in.nandhini.model.BookingInfo;
import in.nandhini.service.Booking;

/**
 * Servlet implementation class BookingDetails
 */
@WebServlet("/BookingDetails")
public class BookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * sending json object to admin view JSP page
		 */
		try {
			List<BookingInfo> detail = Booking.getBookingDetails();
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String object = gson.toJson(detail);
			out.println(object);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
