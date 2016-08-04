package Session5.ConcordanceOfCharacters;

import java.util.Scanner;

/**
 * Program to give the index of occurence of each character in a string
 * @author Noor
 *
 */
public class ConcordanceApplication {

	/**
	 * Main method of the program
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the string  :\t");
		StringBuffer inputString = new StringBuffer(scanner.nextLine());
		inputString=inputString.
		//new DisplayConcordance(inputString).displayConcordance();
		scanner.close();
	}

}
