package Session8.Sort;

/** Class to perform count sort over array elements.
 * @author Noor
 */
public class CountSort {

	/**
	 * Method to perform sorting over the array using count sort.
	 * @param inputArray
	 * @return
	 */
	public int[] performCountSort(int[] inputArray) {
		int inputArrayLength = inputArray.length;
		int outputArray[] = new int[inputArrayLength];

		int maximumElement = inputArray[0];
		for (int value : inputArray) {
			if (value > maximumElement) {
				maximumElement = value;
			}
		}
		
		int countArray[] = new int[maximumElement + 1];
		for (int value : inputArray) {
			countArray[value]++;
		}

		int countArrayLength = countArray.length;
		for (int index = 1; index <= countArrayLength; index++) {
			countArray[index] += countArray[index-1];
		}

		for (int index = 0; index < inputArrayLength; ++index) {
			outputArray[countArray[inputArray[index]]-1] = inputArray[index];
			countArray[inputArray[index]]--;
		}
		return outputArray;
	}

}
