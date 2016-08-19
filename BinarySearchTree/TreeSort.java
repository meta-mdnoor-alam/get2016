package Session8.BinarySearchTree;

import java.util.Scanner;

/**
 * Class to sort role numbers of students in ascending series using tree sort.
 * @author Noor
 */
public class TreeSort {

	BinarySearchTree bst;
	Scanner scanner;

	/**
	 * Default constructor.
	 */
	public TreeSort() {
		bst = new BinarySearchTree();
	}

	/**
	 * Program main function.
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSort tree = new TreeSort();
		tree.displayMenuChoice();
	}

	/**
	 * Method to display menu option to the user.
	 */
	private void displayMenuChoice() {
		scanner = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("\n\n<----Please choose---->");
				System.out.println("1. Enter student roll number.");
				System.out.println("2. Sort roll numbers");
				System.out.println("3. Exit");
				System.out.println("\nEnter your choice  :\t");
				MenuEnumConstants menuChoice = MenuEnumConstants.values()[scanner.nextInt()];

				switch (menuChoice) {
				case ENTER_ROLL_NUMBERS:
					System.out.print("\n\nEnter the roll number to be inserted  :\t");
					int data = scanner.nextInt();
					if (bst.insert(data) == true) {
						System.out.print(data + " successfully inserted into tree.");
					}
					break;
				case SORT_ROLL_NUMBERS:
					bst.sort();
					break;
				case EXIT:
					System.exit(-1);
				default:
					System.out.println("\n\nPlease enter a valid choice...");
					break;
				}
			}
		} catch (Exception exception) {
			System.out.println("\n\nSomething went wrong :: " + exception.getMessage());
			System.out.println("Sorry for the inconvinience.");
			displayMenuChoice();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}