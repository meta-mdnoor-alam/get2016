package Session7;

import java.util.Scanner;

/**
 * Class to implement binary search which returns the left most occurrence of an element.
 * @author Noor
 */
public class BinarySearch {

	private int[] array;
	int sizeOfArray;
	int searchedElement;
	Scanner scanner;

	/**
	 * Default constructor.
	 */
	public BinarySearch() {
	}
	
	/**
	 * Parameterized constructor
	 * @param array
	 */
	public BinarySearch(int[] array) {
		this.array = array;
	}

	/**
	 * Method to input array and the element to be searched.
	 * @return Element to be searched.
	 */
	public int getInput() {
		scanner = new Scanner(System.in);
		
		try {
			System.out.print("\n\nEnter the size of the array  :\t");
			sizeOfArray = scanner.nextInt();
			array = new int[sizeOfArray];
			System.out.println("Enter the array elements in sorted order  :");
			for (int index = 0; index < sizeOfArray; index++) {
					array[index] = scanner.nextInt();
			}
			
			if (!isArraySorted()) {
				throw new Exception("Unsorted array entered.");	
			}
			System.out.print("\nEnter the element to be searched  :\t");
			searchedElement = scanner.nextInt();
			
		} catch (Exception e) {
			System.out.println("\n\nSomthing went wrong ::  "+e.getMessage());
			System.out.println("Inconvinience caused is deeply regreted.");
			searchedElement = getInput();
		} finally {
			if (scanner!=null) {
				scanner.close();
			}
		}
		return searchedElement;
	}
	
	/**
	 * Method to check whether the array is in sorted order or not.
	 * @return
	 */
	public boolean isArraySorted() {
		for (int index = 0; index < array.length-1; index++) {
			if (array[index] > array[index+1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to perform the binary search returning the left most occurrence
	 * @param searchedElement The element to be searched in the array
	 * @param lowerIndex The lower index of the array from which searching starts.
	 * @param higherIndex The end index of the array upto which search has to be done.
	 * @return Index of the searched element if found, else -1. 
	 */
	public int performBinarySearch(int searchedElement, int lowerIndex, int higherIndex) {
		int midIndex = (lowerIndex + higherIndex) / 2;
		int tempIndex;

		if (lowerIndex > higherIndex) {
			return -1;
		}
		
		if (searchedElement == array[midIndex]) {
			tempIndex = performBinarySearch(searchedElement, lowerIndex, midIndex - 1);
			if (tempIndex == -1) {
				return midIndex;
			} else {
				return tempIndex;
			}
		} else if (searchedElement < array[midIndex]) {
			return performBinarySearch(searchedElement, lowerIndex, midIndex - 1);
		} else {
				return performBinarySearch(searchedElement, midIndex + 1, higherIndex);
		}
	}
	
	public void diplaySearchResult() {
		int searchedResult = performBinarySearch(searchedElement, 0, array.length-1);
		if (searchedResult == -1) {
			System.out.println("\n\nSearched element could not be found on the array entered.");
		} else {
			System.out.println("\n\nLeftmost occurence of "+searchedElement+" found at "+(searchedResult+1)+" position.");
		}
	}
}