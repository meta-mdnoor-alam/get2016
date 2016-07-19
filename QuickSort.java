package Session3;

/**To sort an array in ascending order by Quick Sort using recursion.
 * Assumption : last element is considered as Pivot element in the array.
 * @author Noor
 */
public class QuickSort {

	/**
	 * Function to swap array elements of positionFirst with positionSecond.
	 * @param array Array in which the swapping is performed
	 * @param positionFirst first index of the array to be swapped
	 * @param positionSecond second index of the array to perform swapping
	 * @return swapped array after performing swapping of element in positionFirst with positionSecond
	 */
	public int[] swapArrayElements (int[] array, int positionFirst, int positionSecond) {
		int temp=array[positionFirst];
		array[positionFirst]=array[positionSecond];
		array[positionSecond]=temp;
		
		return array;
	}
	
	/**
	 * Function to partition the array in such the way that on its left all the small elements are there &
	 * on its right all greater elements are placed.
	 * @param array Array on which the partitioning is performed
	 * @param lowerIndex lower index of the array from which partition is to be done
	 * @param higherIndex higher index of the array upto which partition is done
	 * @return index of the pivot element which is fixed at its right position.
	 */
	public int partition(int[] array, int lowerIndex, int higherIndex) {
		int pivot=array[higherIndex];
		int i=lowerIndex-1;
		for (int j = lowerIndex; j < higherIndex; j++) {
			if (array[j]<=pivot) {
				i++;
				swapArrayElements(array, i, j);
			}
		}
		
		swapArrayElements(array, i+1, higherIndex);
		
		return (i+1);
	}
	
	/**
	 * Function to perform quick sort from array index lowerIndex upto higherIndex.
	 * @param array Array on which sorting is to be performed
	 * @param lowerIndex lower index of the array from which sorting is done
	 * @param higherIndex higher index of the array upto which sorting is to be done 
	 * @return the sorted array in ascending order after calling the function recursively. 
	 */
	public int[] quickSort(int[] array, int lowerIndex, int higherIndex) {
		//Handling empty array given by the user.
		if (array.length==0) {
			throw new ArrayIndexOutOfBoundsException("Invalid array");
		}
		
		//termination condition for the recursion.
		if (lowerIndex<higherIndex) {
			int partitionIndex=partition(array, lowerIndex, higherIndex);
			array=quickSort(array, lowerIndex, partitionIndex-1);
			array=quickSort(array, partitionIndex+1, higherIndex);
		}
		
		return array;
	}
}
