package Session8.Sort;

/**To sort an array in ascending order by Quick Sort.
 * Assumption : last element is considered as Pivot element in the array.
 * @author Noor
 */
public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] inputArray) {
		return quickSort(inputArray, 0, inputArray.length-1);
	}
	
	/**
	 * Function to perform quick sort from array index lowerIndex upto higherIndex.
	 * @param inputArray
	 * @param lowerIndex
	 * @param higherIndex
	 * @return 
	 */
	private int[] quickSort(int[] inputArray, int lowerIndex, int higherIndex) {
		if (inputArray.length == 0) {
			System.out.println("Please enter the array first.");
		}
		
		if (lowerIndex < higherIndex) {
			int partitionIndex = partition(inputArray, lowerIndex, higherIndex);
			inputArray = quickSort(inputArray, lowerIndex, partitionIndex-1);
			inputArray = quickSort(inputArray, partitionIndex+1, higherIndex);
		}
		return inputArray;
	}
	
	/**
	 * Function to partition the array in such the way that on its left,
	 * all the small elements are there & on its right all greater elements
	 * are placed.
	 * @param inputArray
	 * @param lowerIndex
	 * @param higherIndex
	 * @return
	 */
	private int partition(int[] inputArray, int lowerIndex, int higherIndex) {
		int pivotElement = inputArray[higherIndex];
		int i = lowerIndex - 1;
		for (int j = lowerIndex; j < higherIndex; j++) {
			if (inputArray[j]<=pivotElement) {
				i++;
				swapArrayElements(inputArray, i, j);
			}
		}
		swapArrayElements(inputArray, i+1, higherIndex);
		
		return (i+1);
	}
	
	/**
	 * Method to swap 2 values of array.
	 * @param inputArray
	 * @param firstIndex
	 * @param secondIndex
	 */
	private int[] swapArrayElements(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
		return inputArray;
	}
}
