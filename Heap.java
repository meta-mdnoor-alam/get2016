package Session4;

/**
 * Program to implement max-heap.
 * @author Noor
 */
public class Heap {

	private final int INITIAL_SIZE = 10;
	private int[] heap;
	private int heapSize;
	private int nextIndex;

	/**
	 * Default constructor
	 */
	public Heap() {
		heapSize = INITIAL_SIZE;
		heap = new int[heapSize];
		nextIndex = 0;
	}

	/**
	 * Method to get the heap size
	 * @return heapSize
	 */
	public int getHeapSize() {
		return heapSize;
	}

	/**
	 * Method to set the heap heap size.
	 * @param heapSize
	 */
	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	/**
	 * Method to grow the size of the heap if it is going to exhaust.
	 */
	private void growSize() {
		int oldHeapSize = getHeapSize();
		setHeapSize((3 * getHeapSize()) / 2);
		int temp[] = new int[getHeapSize()];
		for (int index = 0; index < oldHeapSize; index++) {
			temp[index] = heap[index];
		}
		heap = temp;
	}
	
	/**
	 * Method to add an element at the end of the array.
	 * @param element
	 */
	public boolean insert(int element) {
		heap[nextIndex] = element;
		nextIndex++;
		if (nextIndex >= getHeapSize()) {
			growSize();
		}
		for (int index = nextIndex / 2; index >= 0; index--) {
			heapify(index);
		}
		System.out.println("Size  "+nextIndex);
		return true;
	}

	/**
	 * Method to return the index of largest element among parent, left-child and right-child.
	 * @return
	 */
	private int calcuateLargestOfThree(int indexOfNonLeafNode, int leftChild, int rightChild) {
		int largest=indexOfNonLeafNode;
		if (heap[indexOfNonLeafNode] < heap[leftChild]) {
			if (heap[leftChild] > heap[rightChild]) {
				largest = leftChild;
			} else {
				largest = rightChild;
			}
		} else if (heap[indexOfNonLeafNode] > heap[rightChild]) {
			largest = indexOfNonLeafNode;
		} else {
			largest = rightChild;
		}
		return largest;
	}
	
	/**
	 * Swap the heap elements of the 2 indexes.
	 * @param firstIndex
	 * @param secondIndex
	 */
	public void swap(int firstIndex, int secondIndex) {
		int temp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = temp;
	}
	
	/**
	 * Method to build a max heap, swaps the parent with left or right child (whichever is greater)
	 * @param indexOfNonLeafNode
	 */
	public void heapify(int indexOfNonLeafNode) {
		int leftChild = (indexOfNonLeafNode * 2) + 1;
		int rightChild = (indexOfNonLeafNode * 2) + 2;
		int largest = calcuateLargestOfThree(indexOfNonLeafNode, leftChild, rightChild);
		if (largest != indexOfNonLeafNode) {
			swap(indexOfNonLeafNode, largest);
		}
	}

	/**
	 * Method to display the heap.
	 */
	public void display() {
		for (int index = 0; index < nextIndex; index++) {
			System.out.print(heap[index] + "  ");
		}
	}

	/**
	 * Method to delete the root element for maximum.
	 * @return Max from heap
	 */
	public int delete() {
		int deleted = -111111;
		if (nextIndex > 0) {
			deleted = heap[0];
			heap[0] = heap[nextIndex - 1];
			nextIndex--;
			for (int index = nextIndex / 2; index >= 0; index--) {
				heapify(index);
			}
		}
		return deleted;
	}

}
