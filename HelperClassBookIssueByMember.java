package Session1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Helper class to fire the queries to the database
 * @author Noor
 */
public class HelperClassBookIssueByMember {

	/**
	 * Method to execute the query for checking the book can be issued or not
	 * @param query
	 * @return True if book can be issued else false
	 */
	public static boolean canBookBeIssued(String query) {
		boolean bookAvailable = true;
		try {
			Statement statement = DatabaseConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				if(resultSet.getString("return_date").equalsIgnoreCase("null")) {
					bookAvailable = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookAvailable;
	}

	/**
	 * Method to execute the query for inserting the row for issuing the book
	 * @param query - The select query to be executed
	 * @return True if book is issued else false
	 */
	public static boolean executeIssueBookQuery(String query) {
		boolean result = false;
		try {
			Statement statement = DatabaseConnection.getConnection().createStatement();
			int rowAffected = statement.executeUpdate(query);

			if(rowAffected > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Method to execute the select query for getting the book id
	 * @param query - The select query to be executed
	 * @return The list of Books object containing the result set of the query
	 */
	public static Books getAccessionId(String query) {
		Books book = null;
		
		try {
			Statement statement = DatabaseConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			book = new Books();
			book.setAccessionNumber(resultSet.getInt(1));
			book.setTitleId(resultSet.getString(2));
			book.setPurchaseDate(resultSet.getString(3));
			book.setPrice(resultSet.getFloat(4));
			book.setStatus(resultSet.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
}
