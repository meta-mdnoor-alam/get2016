package Session6.EmployeeDetailsApplication;

import java.util.Comparator;

/**
 * Class to compare the names of employee.
 * @author Noor
 */
public class SortByEmployeeName implements Comparator<Employee>{

	/**
	 * Method to perform the sorting based on the Employees' name
	 */
	@Override
	public int compare(Employee firstEmployee, Employee secondEmployee) {
		return firstEmployee.getEmployeeName().compareTo(secondEmployee.getEmployeeName());
	}

}
