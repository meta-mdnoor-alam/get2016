package Session1;

/**
 * To implement array-list using array.
 * @author Noor
 *
 */
public class MyArrayList<N> implements MyList<N>{

	private static final int INITIAL_SIZE=10;
	private Object[] array; 
	private int size=0;
	
	public MyArrayList() {
		super();
		array=new Object[INITIAL_SIZE];
		size=0;
	}
	
	public MyArrayList(int userDefinedCapacity) {
		super();
		array=new Object[userDefinedCapacity];
		size=0;
	}
	
	@Override
	public int size() {
		size=0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]==null) {
				break;
			}
			size++;
		}
		return size;
	}
	
	private boolean isSpaceAvailable() {
		if (array[array.length-1]==null) {
			return true;
		}
		return false;
	}
	
	private int increaseSize() {
		size();
		int newSize=((3*size)/2)+1;
		return newSize;
	}
	
	@Override
	public boolean add(N element) {
		if (isSpaceAvailable()) {
			 array[size()]=element;
			 size++;
		} else {
			Object[] tempArray=new Object[increaseSize()];
			int index;
			for (index = 0; index < array.length; index++) {
				tempArray[index]=array[index];
			}
			array=new Object[tempArray.length];
			array=tempArray;
			array[index]=element;
		}
		return true;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean add(int index, N element) {
		checkIndexOutOfBoundCheck(index);
		if (isSpaceAvailable()) {
			N temp;
			for (int i = index; i < size(); i++) {
				temp = (N)array[i];
				array[i] = element;
				element = temp;
			}
		} else {
			Object[] tempArray=new Object[increaseSize()];
			for (int i = 0; i < array.length; i++) {
				tempArray[i]=array[i];
			}
			array=new Object[tempArray.length];
			array=tempArray;
			N temp;
			for (int i = index; i < size(); i++) {
				temp = (N)array[i];
				array[i] = element;
				element = temp;
			}
		}
		return true;
	}
	
	@Override
	public void addAll(MyList<N> list) {
		int arraySize=size();
		int listSize=list.size();
		Object[] temp=new Object[arraySize+listSize];
		for (int i = 0; i < arraySize; i++) {
			temp[i]=array[i];
		}
		array=new Object[arraySize+listSize];
		array=temp;
		for (int i = 0; i < listSize; i++) {
			add(list.get(i));
		}
	}

	private void checkIndexOutOfBoundCheck(int index) {
		if (index>=size()) {
			throw new ArrayIndexOutOfBoundsException("Array out of bound\nSize : "+size()+"\nIndex : "+index);
		}
	}
	
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean contains(Object obj) {
		for (int i = 0; i < size(); i++) {
			if (array[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public N remove(int index) {
		checkIndexOutOfBoundCheck(index);
		N deletedElement=(N) array[index];
		for (int i = index; i < size(); i++) {
			array[i]=array[i+1];
		}
		size--;
		return deletedElement;
	}
	
	@Override
	public N remove(Object object) {
		size();
		for (int i = 0; i < size; i++) {
			if (array[i].equals(object)) {
				return remove(i);
			}
		}
		return null;
	}
	
	@Override
	public boolean clear() {
		size();
		for (int i = 0; i < size; i++) {
			array[i]=null;
		}
		size=0;
		array=new Object[INITIAL_SIZE];
		return true;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public N get(int index) {
		checkIndexOutOfBoundCheck(index);
		return (N) array[index];
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public N set(int index, N element) {
		checkIndexOutOfBoundCheck(index);
		N oldValue=(N) array[index];
		array[index]=element;
		return oldValue;
	}
	
	@Override
	public int indexOf(Object obj) {
		int size=size();
		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public MyArrayList<N> subList(int start, int end) {
		checkIndexOutOfBoundCheck(start);
		checkIndexOutOfBoundCheck(end);
		MyArrayList<N> mySubList = new MyArrayList<N>(end - start + 1);
		for (int i = start; i <= end; i++) {
			mySubList.add((N) array[i]);
		}
		return mySubList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public MyArrayList<N> reverse() {
		int size=size();
		MyArrayList<N> reverseList = new MyArrayList<N>(size);
		for (int i = size-1; i >= 0; i--) {
			reverseList.add((N) array[i]);
		}
		return reverseList;
	}
	
	@Override
	public void sort() {
		int size=size();
		mergeSort(0, size - 1);
	}

	private void mergeSort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void merge(int low, int middle, int high) {
		int size=size();
		Object[] helpingArray = new Object[size];
		for (int i = low; i <= high; i++) {
			helpingArray[i] = array[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high) {
			if (((Comparable) helpingArray[i]).compareTo(helpingArray[j]) < 0) {
				array[k++] = helpingArray[i++];
			} else {
				array[k++] = helpingArray[j++];
			}
		}
		while (i <= middle) {
			array[k++] = helpingArray[i++];
		}
		while (j<=high) {
			array[k++] = helpingArray[j++];
		}
	}
}