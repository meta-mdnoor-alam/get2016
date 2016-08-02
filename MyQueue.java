package Session2;

import java.util.Arrays;

/**
 * Class to implement queue using arrays.
 * @author Noor
 */
public class MyQueue<N> {
	private final int INITIAL_CAPACITY=10;
	Object[] array;
	int front, rear;
	
	/**
	 * Parameterized constructor.
	 * @param capacity
	 */
	public MyQueue(int capacity){
		array = new Object[capacity];
		front = -1;
		rear = -1;
	}

	/**
	 * Default constructor.
	 */
	public MyQueue(){
		array = new Object[INITIAL_CAPACITY];
		front = -1;
		rear = -1;
	}

	/**
	 * Method to add element at rear
	 * @param element to be added.
	 * @return success or not.
	 */
	public boolean enqueue(N element){
		size();
		if (front==-1) {
			front++;
		}
		ensureCapacity(rear+1);
		array[++rear] = (N)element;
		return true;
	}
	
	/**
	 * Method to delete element from front
	 * @return element which is deleted.
	 */
	@SuppressWarnings("unchecked")
	public N dequeue(){
		int size=size();
		if(size==0 || front>rear){
			front=-1;
			rear=-1;
			return null;
		} else if (size==1) {
			N oldValue=(N)array[front+1];
			front=-1;
			rear=-1;
			return oldValue;
		}
		return (N) array[front++];
	}
	
	/**
	 * Method to make the queue empty.
	 * @return success or not.
	 */
	public boolean makeEmpty(){
		front = -1;
		rear = -1;
		return true;
	}
	
	/**
	 * Method to get element from front.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public N getFront(){
		return (N)array[front];
	}

	/**
	 * Method to increases the capacity of array by making a new array with increased capacity
	 * and transferring the old array into new one
	 * @param minCapacity 
	 */
	public void growCapacity(int minCapacity){
		try{
			int oldCapacity = array.length;
			int newCapacity = ((3*oldCapacity)/2)+1;
			array = Arrays.copyOf(array, newCapacity);
		}catch(Exception ex){
			System.out.println("Something went wrong: "+ex.getMessage());
		}
	}

	/**
	 * Method to check if the capacity is less or grows the capacity of array
	 * @param minCapacity
	 */
	public void ensureCapacity(int minCapacity){
		try{
			// if capacity is less then grow the capacity 
			if(minCapacity==rear+1){
				growCapacity(minCapacity);
			}
		}catch(Exception e){
			System.out.println("Something went wrong: "+e.getMessage());
		}
	}
	
	/**
	 * Method to check the queue is empty or not.
	 * @return success or not.
	 */
	public boolean isEmpty(){
		if(rear==-1){
			return true;
		}
		return false;
	}
	
	/**
	 * Method to get the size of queue.
	 * @return Size.
	 */
	public int size(){
		int size = rear - front + 1;
		return size;
	}
	
	/**
	 * Method to get the value of the queue element by its index.
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public N getValueByIndex(int index) {
		N value = null;
		if (front > -1 && front <= rear) {
			value = (N) array[index];
		}
		return value;
	}
	
	/**
	 * Method to print the whole queue.
	 */
	public void print(){
		if (front!=-1) {
			for(int i = front ; i <= rear ; ++i ){
				System.out.println(array[i]);
			}
		}
	}	
}