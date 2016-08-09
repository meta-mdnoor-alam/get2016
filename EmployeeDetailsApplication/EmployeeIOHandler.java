package Session6.EmployeeDetailsApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class to take employee details and display the output.
 * @author Noor
 */
public class EmployeeIOHandler {

	private Map<String, Employee> employeeMap;
	private Employee employee;
	private Scanner scanner;
	private List<String> listOfKeys;
	
	/**
	 * Default constructor.
	 */
	public EmployeeIOHandler() {
		employeeMap = new HashMap<String, Employee>();
		listOfKeys = new ArrayList<String>();
	}
	
	/**
	 * Method to get the details of the employee
	 */
	public void getEmployeeDetails() {
		scanner = new Scanner(System.in);
		boolean alreadyAnEmployee = false;
		String employeeId;
		String employeeName;
		String employeeAddress;
		char wantToContinue = '\0';
		
		try {
			do {
				System.out.print("\n\nEnter your Employee Id  :\t");
				employeeId = scanner.nextLine().toLowerCase();
				
				if(employeeMap.containsKey(employeeId)) {
					System.out.println("You are already registered.");
					alreadyAnEmployee = true;
					continue;
				}
				
				System.out.print("Enter your name  :\t");
				employeeName = scanner.nextLine();
				System.out.print("Enter your address   :\t");
				employeeAddress = scanner.nextLine();
				
				employee = new Employee(employeeId, employeeName, employeeAddress);
				employeeMap.put(employeeId, employee);
				listOfKeys.add(employeeId);
				System.out.print("Do you want to enter more employee details(y/n)  :");
				wantToContinue = scanner.nextLine().charAt(0);
			} while (alreadyAnEmployee || wantToContinue=='y' || wantToContinue=='Y');
		} catch (Exception e) {
			System.out.println("\n\nSomthing went wrong :: "+e.getMessage());
			System.out.println("Sorry for the inconvinience. Please provide the input again.");
			getEmployeeDetails();
		} finally {
			if (scanner!=null) {
				scanner.close();
			}
		}
	}
	
	/**
	 * Method to display the employee details
	 */
	public void displayEmployeeDetails() {
		List<Employee> employeeList = new ArrayList<Employee>();
		int noOfEmployee = listOfKeys.size();
		
		for(int index=0; index < noOfEmployee; index++) {
			employeeList.add(employeeMap.get(listOfKeys.get(index)));
		}
		
		//Sorting in natural order
		System.out.println("\nSorting in natural order  :");
		Collections.sort(employeeList);
		System.out.println(employeeList);
		
		//Sorting based on the names of the employee
		System.out.println("\n\nSorting based on Emploee Name  :");
		Collections.sort(employeeList, new SortByEmployeeName());
		System.out.println(employeeList);
	}
}
