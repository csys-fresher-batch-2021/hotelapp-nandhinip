package in.nandhini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import in.nandhini.exception.InvalidException;

public class DBConnection {

	private DBConnection() throws InvalidException {
		throw new InvalidException("Invalid Entry");
	}

	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");

	public static Connection getConnection() {

		Connection connection = null;
		try {
			// Step 1: Load the database driver into memory ( ClassNotFoundException )
			Class.forName(driverClass);

			// Step 2: Get the Database Connection (SQLException)
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
