package Session1;

/**
 * To implement array-list using array.
 * @author Noor
 *
 */
public class MyArrayList<N> implements MyList<N>{

	private static final int INITIAL_SIZE=10;
	private Object[] array; 
	private int length=0;
	
	public MyArrayList() {
		super();
		array=new Object[INITIAL_SIZE];
		length=INITIAL_SIZE;
	}
	
	public MyArrayList(int userDefinedCapacity) {
		super();
		array=new Object[userDefinedCapacity];
		length=userDefinedCapacity;
	}
	
	public int size() {
		int size=0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]==null) {
				break;
			}
			size++;
		}
		return size;
	}
	
	private boolean isSpaceAvailable() {
		if (array[length-1]==null) {
			return true;
		}
		return false;
	}
	
	private int increaseSizeBy() {
		int incrementedSize=((3*size())/2)+1;
		return incrementedSize;
	}
	
	public boolean add(N element) {
		if (isSpaceAvailable()) {
			 array[size()]=element;
		} else {
			Object[] tempArray=new Object[increaseSizeBy()];
			for (int i = 0; i < array.length; i++) {
				tempArray[i]=array[i];
			}
			array=new Object[increaseSizeBy()];
			array=tempArray;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean add(int index, N element) {
		indexOutOfBoundCheck(index);
		if (isSpaceAvailable()) {
			N temp;
			for (int i = index; i < size(); i++) {
				temp = (N)array[i];
				array[i] = element;
				element = temp;
			}
			return true;
		}
		return false;
	}
	
	private void indexOutOfBoundCheck(int index) {
		if (index>=size()) {
			throw new ArrayIndexOutOfBoundsException("Array out of bound\nSize : "+size()+"\nIndex : "+index);
		}
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Object obj) {
		for (int i = 0; i < size(); i++) {
			if (array[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public N remove(int index) {
		indexOutOfBoundCheck(index);
		N deletedElement=(N) array[index];
		for (int i = index; i < size(); i++) {
			array[i]=array[i+1];
		}
		return deletedElement;
	}
}



























