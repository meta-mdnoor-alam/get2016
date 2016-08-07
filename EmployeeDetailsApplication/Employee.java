package Session6.EmployeeDetailsApplication;

/**
 * Class for storing Employee details.
 * @author Noor
 */
public class Employee implements Comparable<Employee>{
	private String employeeId;
	private String employeeName;
	private String employeeAddress;
	
	/**
	 * Parameterized constructor.
	 * @param employeeId
	 * @param employeeName
	 * @param employeeAddress
	 */
	public Employee(String employeeId, String employeeName, String employeeAddress) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	/**
	 * Method to get Employee-Id
	 * @return employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * Method to get Employee-Name
	 * @return employeeName
	 */
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	@Override
	public String toString() {
		return "Employee-Id: "+employeeId+"  | Name: "+employeeName+"  | Address: "+employeeAddress+"\n";
	}

	/**
	 * Method to perform the natural sorting based on the employee-id
	 */
	@Override
	public int compareTo(Employee employee) {
		return employeeId.compareTo(employee.getEmployeeId());
	}
}