package Session1;

/**
 * To implement List interface using array.
 * @author Noor
 */
public interface MyList<N> {
	/**
	 * Method to return the size of the list with real data.
	 */
	public int size();
	
	/**
	 * Method to add element at the last of the list.
	 * @param element Element to be added.
	 * @return success or not
	 */
	public boolean add(N element);
	
	/**
	 * Method to add element at an specified index.
	 * @param index
	 * @param element
	 * @return success or not
	 */
	public boolean add(int index, N element);
	
	/**
	 * Method to add all the elements of the list at the last of the original list.
	 * @param list
	 */
	public void addAll(MyList<N> list);
	
	/**
	 * Method to check whether the list is empty or not.
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Method to check whether the list contains the specified object or not.
	 * @param object
	 * @return success or not.
	 */
	public boolean contains(Object object);
	
	/**
	 * Method to remove the element at a specified index and return the old value.
	 * @param index
	 * @return old removed value.
	 */
	public N remove(int index);
	
	/**
	 * Method to remove the object from the array and return the old value.
	 * @param object
	 * @return old removed value.
	 */
	public N remove(Object object);
	
	/**
	 * Method to clear whole list and set the list to default size and all elements with null.
	 * @return success or not.
	 */
	public boolean clear();
	
	/**
	 * Method to return the element at the specified index.
	 * @param index
	 * @return element at the specified index.
	 */
	public N get(int index);
	
	/**
	 * Method to set the element at specified index and return the old value.
	 * @param index
	 * @param element
	 * @return old value.
	 */
	public N set(int index, N element);
	
	/**
	 * Method to find the index of the object specified.
	 * @param object
	 * @return index of the object specified.
	 */
	public int indexOf(Object object);
	
	/**
	 * Method to fetch and return the sub-list starting from start index till the end index.
	 * @param start
	 * @param end
	 * @return
	 */
	public MyList<N> subList(int start, int end);
	
	/**
	 * Method to reverse the list and return the resultant list.
	 * @return reversed resultant list.
	 */
	public MyList<N> reverse();
	
	/**
	 * Method to sort the list based the data value of the list.
	 */
	public void sort();
}
