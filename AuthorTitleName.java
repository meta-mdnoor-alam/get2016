package Session1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Main class to get the all the titles for a given author
 * @author Noor
 */
public class AuthorTitleName {

	private Scanner scanner;

	/**
	 * Method to get the input from user for the author name
	 * @return author name
	 */
	private String getAuthorName() {
		scanner = new Scanner(System.in);
		String author = "";
		System.out.print("\nEnter author name  :\t");

		try {
			author = scanner.nextLine();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return author;
	} 

	/**
	 * Method to display the the title name written by the author
	 * @param author Author name
	 */
	private void displayResult(String author) {
		List<Titles> titleList = getDetailsFromDatabase(author);
		
		if (titleList.size() == 0) {
			System.out.println("No book name present with author name "+author);
		}

		System.out.println("The book names for the author "+author+" are :");
		for(Titles title : titleList) {
			System.out.println(title.getTitleName());
		}
	}
	
	private List<Titles> getDetailsFromDatabase(String author) {
		String query = "SELECT * FROM titles t INNER JOIN title_author ta ON t.title_id = ta.title_id "
				+ "INNER JOIN authors a ON ta.author_id = a.author_id WHERE a.author_name = '"+author+"'";

		List<Titles> titleList = HelperClassAuthorTitleName.executeSelectQuery(query);
		
		return titleList;
	}

	public static void main(String[] args) {
		try {
			DatabaseConnection.getConnection();
			AuthorTitleName title = new AuthorTitleName();
			
			String author = title.getAuthorName();
			title.displayResult(author);

			DatabaseConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
