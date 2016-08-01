package Session1;

import java.util.Scanner;

/**
 * Program to search an element in an array by binary search.
 * 
 * @author Noor
 */
public class BinarySearch {
	
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
		} while (limit<3);
		
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
			System.out.print("Please enter " +(i + 1)+"th element of array  :\t");
			array[i]=scanner.nextInt();
		}
		return array;
	}

	/**
	 * Method to take input element to be searched in the array.
	 * @return Element to be searched.
	 */
	private int getElementToBeSearched() {
		System.out.print("\n\nPlease enter the number to be searched the array  :\t");
		int elementToFind=scanner.nextInt();
		return elementToFind;
	}

	/**
	 * Method to search the element in the array by using binary search.
	 * @param array
	 * @param start Starting index
	 * @param end Ending Index
	 * @param elementToFind
	 * @return index of the first occurrence of the element to be searched.
	 */
	public int searchElement(int[] array, int start, int end, int elementToFind) {
		int midIndex = (start + end) / 2;

		if (start > end) {
			return -1;
		} else if (array[midIndex] == elementToFind) {
			return midIndex;
		} else if (array[midIndex] > elementToFind) {
			return searchElement(array, start, midIndex - 1, elementToFind);
		} else {
			return searchElement(array, midIndex + 1, end, elementToFind);
		}
	}
	
	/**
	 * Main method of the program.
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		
		int limit=binarySearch.getArrayLimit();
		int[] array = binarySearch.getArray(limit);
		int elementToFind=binarySearch.getElementToBeSearched();
		int result = binarySearch.searchElement(array, 0, limit - 1, elementToFind);

		if (result>=0) {
			System.out.print("\n\nNumber Found at index  :\t"+result);
		} else if (result == -1) {
			System.out.print("\n\nNumber not present in the array.");
		}
	}
}
