package Session1;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Main class to Issue a book to the member if available
 * @author Noor
 */
public class BookIssueByMember {
	private Scanner scanner;

	/**
	 * Method to get the input from user for book name
	 * @return book name
	 */
	private String getBookName() {
		scanner = new Scanner(System.in);
		String bookName = "";
		System.out.print("Enter book name  :\t");

		try {
			bookName = scanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookName;
	}

	/**
	 * Method to get the input from user for the member id
	 * @return member id
	 */
	private String getMemberId() {
		scanner = new Scanner(System.in);
		String memberId = "";
		System.out.print("Enter Member Id  :\t");

		try {
			memberId = scanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberId;
	}

	/**
	 * Method to check if the book can be issued or not
	 * if can be issued then add a record for the same
	 * @param bookName - The book name
	 * @param memberId - The member id
	 */
	private void issueBook(String bookName, String memberId) {
		String queryToGetAccessionNoByName = "SELECT * FROM books b "
				+ "INNER JOIN titles t ON b.title_id = t.title_id "
				+ "WHERE t.title_name = '" + bookName + "'";

		int accessionNumber = HelperClassBookIssueByMember.getAccessionId(queryToGetAccessionNoByName).getAccessionNumber();
		
		String queryForBookDetails = "SELECT bi.issue_date, bi.accession_number, bi.member_id, br.return_date FROM book_issue bi "
				+ "LEFT JOIN book_return br ON bi.accession_number = br.accession_number AND "
				+ "bi.member_id = br.member_id AND bi.issue_date = br.issue_date "
				+ "WHERE bi.accession_number = " + accessionNumber;
		
		boolean isBookAvailableForIssue = HelperClassBookIssueByMember.canBookBeIssued(queryForBookDetails);

		if(isBookAvailableForIssue) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Calendar calender = Calendar.getInstance();
			
			String issueDate = dateFormat.format(calender.getTime());
			calender.add(Calendar.DATE, 15);
			String dueDate = dateFormat.format(calender.getTime());

			String queryToInsertInBookIssue = "INSERT INTO book_issue VALUES "
					+ "('"+issueDate+"', "+accessionNumber+", '"+memberId+"', '"+dueDate+"')";
			
			HelperClassBookIssueByMember.executeIssueBookQuery(queryToInsertInBookIssue);
			System.out.println("Book has been issued.");
		} else {
			System.out.println("Sorry. The book is already issued.");
		}
	}

	public static void main(String[] args) {
		try {
			DatabaseConnection.getConnection();
			BookIssueByMember issueByMember = new BookIssueByMember();
			
			String bookName = issueByMember.getBookName();
			String memberId = issueByMember.getMemberId();

			issueByMember.issueBook(bookName, memberId);

			DatabaseConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
