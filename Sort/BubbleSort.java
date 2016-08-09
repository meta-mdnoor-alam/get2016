package Session8.Sort;

/**
 * Class to implement Bubble-Sorting.
 * @author Noor
 */
public class BubbleSort {

	/**
	 * Method for bubble-sorting
	 * @param inputArray
	 * @return
	 */
	public int[] performBubbleSort(int[] inputArray) {
		int indexOfLastUnsortedElement = inputArray.length - 1;
		for (int index1 = 0; index1 < indexOfLastUnsortedElement - 1; index1++) {
			for (int index2 = 0; index2 < indexOfLastUnsortedElement - index1; index2++) {
				if (inputArray[index2] > inputArray[index2 + 1]) {
					swapArrayElements(inputArray, index2, index2 + 1);
				}
			}
		}
		return inputArray;
	}
	
	/**
	 * Method to swap 2 values of array.
	 * @param inputArray
	 * @param firstIndex
	 * @param secondIndex
	 */
	private void swapArrayElements(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
	}
}