package Session1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to establish a database connection.
 * @author Noor
 */
public class DatabaseConnection {

	private static Connection connection;
	private static final String mysqlURL = "jdbc:mysql://localhost:3306/LIS";
	private static final String userId = "root";
	private static final String password = "noorishere";

	/**
	 * Method to create and opening the connection
	 * @return The Connection object for the session
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		registerDriver();

		if(connection == null) {
			//Creating new connection with the specified url
			connection = DriverManager.getConnection(mysqlURL, userId, password);
		}

		return connection;
	}
	
	private static void registerDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException exception) {
			System.out.println("\n\nSorry connection can not be established !");
			exception.printStackTrace();
		}
	}

	public static void closeConnection() throws SQLException {
		connection.close();
	}	

}
