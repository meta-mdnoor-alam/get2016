package Session1;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Helper class to fire the queries to the database
 * and returning the result to the program
 * @author Noor
 */
public class HelperDeleteBooks {

	public static int deleteBooksFromRecord(String query) {
		int rowAffected = 0;
		try {
			Statement statement = DatabaseConnection.getConnection().createStatement();
			rowAffected = statement.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowAffected;
	}
}
