package Session1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Helper class to fire the queries to the database
 * and returning the result as a list to the program
 * @author Noor
 */
public class HelperClassAuthorTitleName {

	/**
	 * Method to execute the select query
	 * @param query select query to be executed
	 * @return list of Titles object containing the result set of the query
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Titles> executeSelectQuery(String query) {
		List<Titles> titleList = new LinkedList();
		
		try {
			Statement statement = DatabaseConnection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				Titles title = new Titles();
				title.setTitleId(resultSet.getString(1));
				title.setTitleName(resultSet.getString(2));
				title.setSubjectId(resultSet.getString(3));
				title.setPublisherId(resultSet.getString(4));
				
				titleList.add(title);
			}
		} catch (SQLException exception) {
			System.out.println("Somthing went wrong...");
			exception.printStackTrace();
		}
		
		return titleList;
	}
}
