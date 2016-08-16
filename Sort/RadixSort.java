package Session8.Sort;

import Session5.QueueImplementor.MyQueue;

/**
 * Class to perform radix sorting.
 * @author Noor
 */
public class RadixSort implements Sort {

	private int[] inputArray;
	
	@Override
	public int[] sort(int[] inputArray) {
		this.inputArray = inputArray;
		final int INITIAL_ARRAY_SIZE = 10;
		MyQueue[] arrayOfKey = new MyQueue[INITIAL_ARRAY_SIZE];
		for (int index = 0; index < arrayOfKey.length; index++) {
			arrayOfKey[index] = new MyQueue();
		}

		int numberPlace = 1;
		while (performSortOnNumberPlaceDigit(arrayOfKey, numberPlace) == true) {
			numberPlace++;
		}
		return this.inputArray;
	}

	/**
	 * Method to place numbers on correct place in array of queue.
	 * @param arrayOfQueue
	 * @param numberPlace
	 * @return
	 */
	private boolean performSortOnNumberPlaceDigit(MyQueue[] arrayOfQueue, int numberPlace) {
		int number;
		boolean result = false;
		
		for (int index = 0; index < inputArray.length; index++) {
			number = inputArray[index];
			for (int j = 0; j < numberPlace - 1; j++) {
				number /= 10;
			}
			int digit = number % 10;
			if (digit != 0) {
				result = true;
			}
			arrayOfQueue[digit].enqueue(inputArray[index]);
		}

		for (int index = 0, arrayIndex = 0; index < arrayOfQueue.length; index++) {
			while (arrayOfQueue[index].size() > 0) {
				inputArray[arrayIndex++] = arrayOfQueue[index].dequeue();
			}
		}
		return result;
	}

	/**
	 * Method to get sorted array
	 * @return
	 */
	public int[] getSortedArray() {
		return inputArray;
	}

}
