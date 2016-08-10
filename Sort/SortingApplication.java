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
	private int[] inputArray;
	private int[] outputSortedArray;

	public static void main(String[] args) {
		new SortingApplication().mainMenuDisplay();
	}
	
	private void mainMenuDisplay() {
		scanner = new Scanner(System.in);
		try {
			while (true) {
				takeArrayInput();
				int totalArraySize = inputArray.length;
				System.out.println("\n\n1. Comparison sorting");
				System.out.println("2. Linear Sorting");
				System.out.print("Please enter your choice(1-2)  :\t");
				SortingType mainChoice = SortingType.values()[scanner.nextInt()];
				
				switch (mainChoice) {
				case COMPARISON_SORT:
					if (totalArraySize >= 10) {
						sortBy(SortingMethodology.QUICK_SORT);
					} else {
						sortBy(SortingMethodology.BUBBLE_SORT);
					}
					break;
				case LINEAR_SORT:
					if (isRadixToBeUsed(inputArray) == true) {
						sortBy(SortingMethodology.RADIX_SORT);
					} else {
						sortBy(SortingMethodology.COUNTING_SORT);
					}
					break;
				case EXIT:
					System.exit(-1);
					break;
				default:
					System.out.println("\n\nPlease choose valid option...");
					break;
				}
				
				System.out.println("\n\nOutput sorted array  :");
				displayArray(outputSortedArray);
			}
		} catch (Exception exception) {
			System.out.println("Something went wrong " + exception.getLocalizedMessage());
			mainMenuDisplay();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	/**
	 * Method to get array input.
	 */
	private void takeArrayInput() {
		System.out.println("\n\nPlease enter the total number of elements in the array  :\t");
		int totalElements = scanner.nextInt();
		inputArray = new int[totalElements];
		outputSortedArray = new int[totalElements];
		System.out.println("\nPlease enter the elements of array :");
		for (int index = 0; index < totalElements; index++) {
			inputArray[index] = scanner.nextInt();
		}
	}
	
	/**
	 * Method to choose which sorting methodology to choose based on array behaviour.
	 * @param choice
	 */
	private void sortBy(SortingMethodology choice) {
		switch(choice) {
		case QUICK_SORT:
			QuickSort quickSort = new QuickSort();
			outputSortedArray = quickSort.performQuickSort(inputArray);
			break;
		case BUBBLE_SORT:
			BubbleSort bubbleSort = new BubbleSort();
			outputSortedArray = bubbleSort.performBubbleSort(inputArray);
			break;
		case RADIX_SORT:
			RadixSort radixSort = new RadixSort();
			outputSortedArray = radixSort.performRadixSort(inputArray);
			break;
		case COUNTING_SORT:
			CountingSort countingSort = new CountingSort();
			outputSortedArray = countingSort.performCountSort(inputArray);
			break;
		default:
			System.out.println("\n\nPlease choose valid option...");
			break;
		}
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
