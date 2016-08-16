package Session8.Sort;

import java.util.Scanner;

import Session8.Sort.EnumConstants.SortingMethodology;
import Session8.Sort.EnumConstants.SortingType;

/**
 * Class to implement various sorting technique based on user input.
 * @author Noor
 */
public class SortingApplication {
	
	Scanner scanner;
	Sort arraySort;

	public static void main(String[] args) {
		new SortingApplication().mainMenuDisplay();
	}
	
	private void mainMenuDisplay() {
		scanner = new Scanner(System.in);
		int[] outputSortedArray = null;
		
		try {
			char sortAgain;
			do {
				int[] inputArray=takeArrayInput();
				int totalArraySize = inputArray.length;
				System.out.println("\n\nPlease choose which sorting methodology to be followed :");
				System.out.println("1. Comparison sorting");
				System.out.println("2. Linear Sorting");
				System.out.print("Enter your choice(1-2)  :\t");
				SortingType sortingType = SortingType.values()[scanner.nextInt()];
				
				switch (sortingType) {
				case COMPARISON_SORT:
					if (totalArraySize >= 10) {
						outputSortedArray = sortBy(inputArray, SortingMethodology.QUICK_SORT);
					} else {
						outputSortedArray = sortBy(inputArray, SortingMethodology.BUBBLE_SORT);
					}
					break;
				case LINEAR_SORT:
					if (isRadixToBeUsed(inputArray) == true) {
						outputSortedArray = sortBy(inputArray, SortingMethodology.RADIX_SORT);
					} else {
						outputSortedArray = sortBy(inputArray, SortingMethodology.COUNTING_SORT);
					}
					break;
				default:
					System.out.println("\n\nPlease choose valid option...");
					break;
				}
				
				System.out.println("\n\nOutput sorted array  :");
				displayArray(outputSortedArray);
				
				System.out.print("\n\nDo you want to sort another array (y/n)  :\t");
				sortAgain = scanner.next().charAt(0);
				if (sortAgain != 'y' && sortAgain != 'Y') {
					System.out.print("\n\n\nThank you very much...");
				}
			} while(sortAgain == 'y' || sortAgain == 'Y');
		} catch (Exception exception) {
			System.out.println("Something went wrong " + exception.getLocalizedMessage());
			mainMenuDisplay();
		}
	}
	
	/**
	 * Method to get array input.
	 */
	private int[] takeArrayInput() {
		int[] inputArray;
		try {
			System.out.println("\n\nPlease enter the size of the array  :\t");
			int totalElements = scanner.nextInt();
			inputArray = new int[totalElements];
			System.out.println("\nPlease enter the elements  :");
			for (int index = 0; index < totalElements; index++) {
				inputArray[index] = scanner.nextInt();
			}
			
			System.out.println("\nArray input successful !");
		} catch (Exception e) {
			System.out.println("Something went wrong " + e.getLocalizedMessage());
			inputArray = takeArrayInput();
		}
		return inputArray;
	}
	
	/**
	 * Method to choose which sorting methodology to choose based on array behaviour.
	 * @param choice
	 */
	private int[] sortBy(int[] inputArray, SortingMethodology choice) {
		int[] outputSortedArray = null;
		
		switch(choice) {
		case QUICK_SORT:
			arraySort = new QuickSort();
			outputSortedArray = arraySort.sort(inputArray);
			break;
		case BUBBLE_SORT:
			arraySort = new BubbleSort();
			outputSortedArray = arraySort.sort(inputArray);
			break;
		case RADIX_SORT:
			arraySort = new RadixSort();
			outputSortedArray = arraySort.sort(inputArray);
			break;
		case COUNTING_SORT:
			arraySort = new CountingSort();
			outputSortedArray = arraySort.sort(inputArray);
			break;
		default:
			System.out.println("\n\nSomthing went wrong. Please try again...");
			break;
		}
		
		return outputSortedArray;
	}

	/**
	 * Method to determine whether radix sort to be used or not.
	 * @param input
	 * @return
	 */
	public boolean isRadixToBeUsed(int[] input) {
		for (int value : input) {
			if ((value + "").length() >= 3) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to display the array.
	 * @param array
	 */
	public void displayArray(int[] array) {
		for (int value : array) {
			System.out.print(value + "  ");
		}
	}
}
