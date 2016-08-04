package Session5.ConcordanceOfCharacters;

import java.util.Scanner;

/**
 * Program to give the index of occurrence of each character in a string
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
		
		int inputStringLength = inputString.length();
		int indexWithoutSpace = 0;
		for (int index = 0; index < inputStringLength; index++) {    //to remove white spaces from the StringBuffer
			if (!Character.isWhitespace(inputString.charAt(index))) {
				inputString.setCharAt(indexWithoutSpace++, inputString.charAt(index));
			}
		}
		inputString.delete(indexWithoutSpace, inputStringLength);
		
		new DisplayConcordance(inputString).displayConcordance();
		
		scanner.close();
	}

}
