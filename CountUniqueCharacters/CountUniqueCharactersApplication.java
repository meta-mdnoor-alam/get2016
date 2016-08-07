package Session6.CountUniqueCharacters;

import java.util.Scanner;

/**
 * To implement the application which counts the unique characters in string and cache the strings if already passed.
 * @author Noor
 *
 */
public class CountUniqueCharactersApplication {

	private CountUniqueCharacters uniqueCharacter;
	int count;
	private Scanner scanner;
	
	/**
	 * Default constructor
	 */
	public CountUniqueCharactersApplication() {
		uniqueCharacter = new CountUniqueCharacters();
		count = 0;
	}
	
	/**
	 * Program main function.
	 * @param args
	 */
	public static void main(String[] args) {
		new CountUniqueCharactersApplication().takeStringForCountingCharacters();
	}
	
	/**
	 * Method to take string input and display the unique characters in that string.
	 */
	private void takeStringForCountingCharacters() {
		scanner = new Scanner(System.in);
		try {
			char choice;
			do {
				System.out.print("\n\nEnter the string to count unique characters  :\t");
				count = uniqueCharacter.countUniqueCharacters(scanner.nextLine());
				System.out.print("Unique character count  :\t"+count);
				System.out.print("\n\nDo you want to continue (y/n)  :\t");
				choice = scanner.nextLine().charAt(0);
			} while(choice == 'Y' || choice == 'y');
		} catch (Exception e) {
			System.out.println("\n\nSomthing went wrong : " + e.getMessage());
			takeStringForCountingCharacters();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
