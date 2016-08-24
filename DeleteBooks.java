package Session1;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Main class to delete the books which were not issued in the past one year
 * @author Noor
 *
 */
public class DeleteBooks {

	/**
	 * Method to delete the books from the database
	 * which were not issued in the last one year
	 */
	private void deleteRecords() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar calender = Calendar.getInstance();
		String currentDate = dateFormat.format(calender.getTime());

		String queryToDelete = "DELETE FROM books "
				+ "WHERE accession_number NOT IN ("
				+ "SELECT DISTINCT bi.accession_number FROM book_issue bi "
				+ "WHERE TIMESTAMPDIFF(YEAR, bi.issue_dt, '"+currentDate+"') = 0)";
		System.out.println("The books deleted "+HelperDeleteBooks.deleteBooksFromRecord(queryToDelete));
	}

	public static void main(String[] args) {
		try {
			DatabaseConnection.getConnection();
			DeleteBooks deleteBook = new DeleteBooks();
			
			deleteBook.deleteRecords();

			DatabaseConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
