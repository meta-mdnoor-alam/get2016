package Session5.SortedLinkedList;

import java.util.Scanner;

/**
 * Program to implement sorted linked-list application.
 * @author Noor
 */
public class SortedLinkedListApplication {

	SortedLinkedList linkedList;
	Scanner scanner;
	
	/**
	 * Default constructor.
	 */
	public SortedLinkedListApplication() {
		linkedList = new SortedLinkedList();
	}
	
	/**
	 * Program main function
	 * @param args
	 */
	public static void main(String[] args) {
		new SortedLinkedListApplication().showMenu();
	}
	
	/**
	 * Method to display and implement menu operations.
	 */
	private void showMenu() {
		scanner =  new Scanner(System.in);
		
		try {
			while (true) {
				System.out.println("\n\n<----Please Choose---->");
				System.out.println("1. Insert ");
				System.out.println("2. Display ");
				System.out.println("3. Exit ");
				int choice = scanner.nextInt();
				
				MenuChoices menuOption = MenuChoices.values()[choice];
				
				switch (menuOption) {
				case INSERT:
					System.out.print("\nEnter the number to be inserted  :\t");
					linkedList.insert(scanner.nextInt());
					break;
				case DISPLAY:
					linkedList.showLinkedList();
					break;
				case EXIT:
					System.exit(-1);
				default:
					System.out.println("\n\nPlease enter a valid choice...");
					break;
				}
			}
		} catch (Exception exception) {
			System.out.println("Something went wrong : "+ exception.getMessage());
			showMenu();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
