package Session1;

import java.util.Scanner;

/**
 * Program to find the thirt largest element in an array.
 * @author Noor
 */
public class ThirdLargestNumber {
	
	Scanner scanner=new Scanner(System.in);

	/**
	 * Method to take the limit of the array as an input by the user.
	 * @return limit of the array size.
	 */
	private int getArrayLimit() {
		int limit;
		do {
			System.out.print("\n\nEnter the limit for the array size  :\t");
			limit=scanner.nextInt();
		} while (limit>=3);
		
		return limit;
	}
	
	/**
	 * Method to take the array element as input by the user.
	 * @param limit Limit size of the array.
	 * @return an array of elements with more than 3numbers.
	 */
	private int[] getArray(int limit) {
		int[] array = new int[limit];

		for (int i = 0; i < limit; ++i) {
			System.out.print("\n\nPlease enter " +(i + 1)+"th element of array  :\t");
			array[i]=scanner.nextInt();
		}
		return array;
	}
	
	/**
	 * This method returns the third largest element of array.
	 * @param array
	 * @return the third largest element of array
	 */
	public int findThirdLargestElement(int[] array) {

		int thirdLargestElement = 0, secondLargestElement = 0, firstLargestElement = 0, loopIncrementer = 0;

		while (loopIncrementer < array.length) {
			if (array[loopIncrementer] > firstLargestElement) {
				firstLargestElement = array[loopIncrementer];
				loopIncrementer = -1;
			} else if (array[loopIncrementer] < firstLargestElement	&& array[loopIncrementer] > secondLargestElement) {
				secondLargestElement = array[loopIncrementer];
				loopIncrementer= -1;
			} else if (array[loopIncrementer] < secondLargestElement && array[loopIncrementer] > thirdLargestElement) {
				thirdLargestElement = array[loopIncrementer];
			}

			loopIncrementer++;
		}
		return thirdLargestElement;
	}

	/**
	 * Main function of the program.
	 * @param args
	 */
	public static void main(String[] args) {
		ThirdLargestNumber largestElement = new ThirdLargestNumber();
		int limit = largestElement.getArrayLimit();
		int[] array = largestElement.getArray(limit);
		System.out.println("\n\nThird largest element is  :"+largestElement.findThirdLargestElement(array));
	}
}
