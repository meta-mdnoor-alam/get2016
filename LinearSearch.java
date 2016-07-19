package Session3;

/**To search for an element in an array using linear search. 
 * @author Noor
 */
public class LinearSearch {

	/**
	 * Function to find an element in the array using linear search strategy.
	 * @param array in which the searching is performed.
	 * @param leftIndex left index of the array from which searching starts.
	 * @param rightIndex right index of the array upto which searching is done.
	 * @param element the element which is searched in the array linearly.
	 * @return index of the element if it is found or else return -1 element not present.
	 */
	public int searchElement(int[] array, int leftIndex, int rightIndex, int element) {
		//if the element is not present in the array.
		if (leftIndex>rightIndex) {
			return -1;
		}
		
		if (array[leftIndex]==element) {
			return leftIndex;
		}
		
		return searchElement(array, leftIndex+1, rightIndex, element);
	}
}
