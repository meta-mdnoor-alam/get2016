package Session4;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class to encapsulate all the things to display over screen.
 * @author Noor
 */
public class Display {

	String nodeFileName;
	String connectionFileName;
	
	public Display(String nodeFileName, String connectionFileName) {
		this.nodeFileName=nodeFileName;
		this.connectionFileName=connectionFileName;
	}
	
	public int firstMenu(Scanner scanner) {
		int choice;
		System.out.print("\n\n1. Add your profile.");
		System.out.print("\n2. View whole graph network.");
		System.out.print("\n3. View friendlist of someone.");
		System.out.print("\n4. Check if two users are friend.");
		System.out.print("\n5. Trace friend path between two nodes.");
		System.out.print("\n\nEnter your choice  :\t");
		choice=scanner.nextInt();
		return choice;
	}

	public void operateUponChoice(int choice, Scanner scanner) throws IOException {
		switch (choice) {
		case 1:
			addProfile(scanner);
			break;
		case 2:
			viewWholeNetwork();
			break;
		default:
			System.out.println("\n\nEnter valid choice...");
			firstMenu(scanner);
		}
	}
	
	public void addProfile(Scanner scanner) throws IOException {
		Graph graph=new Graph(nodeFileName, connectionFileName);
		Validations validate=new Validations();
		System.out.print("\n\nEnter the type of profile [organisation/user]  :\t");
		String type=scanner.next();
		if (!new Validations().validateType(type)) {
			addProfile(scanner);
		}
		System.out.println("\n\nEnter profile details  :");
		if (type.equalsIgnoreCase("user")) {
			System.out.print("\n\nUser's Name  :\t");
			String name=scanner.next();
			System.out.print("Age  :\t");
			int age=scanner.nextInt();
			System.out.print("Gender  :\t");
			String gender=scanner.next();
			System.out.print("City  :\t");
			String city=scanner.next();
			if (!validate.validateNameCity(name) || !validate.validateAge(age) || !validate.validateGender(gender) || !validate.validateNameCity(city)) {
				addProfile(scanner);
			}
			graph.addNode("user", new UserProfile(name, city, age, gender));
		} else {
			System.out.print("\n\nOrganisation's Name  :\t");
			String orgName=scanner.next();
			System.out.print("Sector [public/private]  :\t");
			String sector=scanner.next();
			System.out.print("City  :\t");
			String city=scanner.next();
			if (!validate.validateNameCity(orgName) || !validate.validateSector(sector) || !validate.validateNameCity(city)) {
				addProfile(scanner);
			}
			graph.addNode("organisation", new OrganisationProfile(orgName, city, sector));
		}
	}
	
	public void viewWholeNetwork() {
		
	}
}
