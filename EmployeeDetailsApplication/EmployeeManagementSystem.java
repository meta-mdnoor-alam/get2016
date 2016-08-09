package Session6.EmployeeDetailsApplication;

/**
 * Class to manage employee employee input-output and display sorted result. 
 * @author Noor
 */
public class EmployeeManagementSystem {

	/**
	 * Program main function
	 * @param args
	 */
	public static void main(String[] args) {
		EmployeeIOHandler employee = new EmployeeIOHandler();
		employee.getEmployeeDetails();
		employee.displayEmployeeDetails();
	}
}
