package Session3;

/**To search for an element in an array using binary search.
 * Assumption : The input array should be already sorted in ascending order.
 * @author Noor
 */
public class BinarySearch {

	/**
	 * Function to find an element in an array using binary search strategy.
	 * @param array array in which the searching is performed.
	 * @param leftIndex left index of the array from which searching starts.
	 * @param rightIndex right index of the array upto which searching is done.
	 * @param element the element which is searched in the array linearly.
	 * @return index of the element if it is found or else return -1 element not present.
	 */
	public int searchElement(int[] array, int leftIndex, int rightIndex, int element) {
		
		int mid;
		
		//if the element is not present in the array.
		if (leftIndex>rightIndex) {
			return -1;
		}
		
		mid=(leftIndex+rightIndex)/2;
		
		if (element==array[mid]) {
			return mid;
		} else if (element<array[mid]) {
			return searchElement(array, leftIndex, mid-1, element);
		} else {
			return searchElement(array, mid+1, rightIndex, element);
		}
	}
}
