package Session1;

/**Class to implement the concept of generic doubly-linkedlist by implementing the MyList interface.
 * @author Noor
 */
public class MyDoublyLinkedList<N> implements MyList<N> {

	private Node<N> start;
	private Node<N> end;

	int size;
	
	/**
	 * Default constructor.
	 */
	public MyDoublyLinkedList() {
		start=null;
		end=null;
		size=0;
	}
	
	/**
	 * Generic Inner class to make a node of the doubly-linked list with previous and
	 * next pointing references of the Node type.
	 * @author Noor
	 * @param <N> Generic type of the node data.
	 */
	private static class Node<N> {
		Node<N> previous;
		N data;
		Node<N> next;
		
		/**
		 * Node constructor to initialize the data and the pointer references nodes.
		 * @param previous
		 * @param data
		 * @param next
		 */
		public Node(Node<N> previous, N data, Node<N> next) {
			this.previous=previous;
			this.data=data;
			this.next=next;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Method to add element at the first location of the list.
	 * @param element
	 * @return success or not.
	 */
	public boolean addFirst(N element) {
		Node<N> node = new Node<N>(null, element, start);
		size();
		if(start == null) {
			end = node;
		} else {
			start.previous = node;
		}
		start = node;
		size++;
		return true;
	}

	@Override
	public boolean add(N element) {
		size();
		Node<N> node = new Node<N>(end, element, null);
		if(end == null) {
			start = node;
		} else {
			end.next = node;
		}
		end = node;
		size++;
		return true;
	}

	@Override
	public boolean add(int index, N element) {
		size();
		if (index>size) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (index==size) {
			add(element);
		} else {
			Node<N> node=new Node<N>(null, element, null);
			int i=0;
			Node<N> temp=start;
			while (i<index) {
				temp=temp.next;
				i++;
			}
			node.previous=temp;
			node.next=temp.next;
			node.previous=temp;
			node.next.previous=node;
		}
		size++;
		return true;
	}

	@Override
	public void addAll(MyList<N> list) {
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}

	@Override
	public boolean isEmpty() {
		size();
		if (size==0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object obj) {
		Node<N> temp=start;
		size();
		for (int i = 0; i < size; i++) {
			if (temp.data.equals(obj)) {
				return true;
			}
			temp=temp.next;
		}
		return false;
	}

	@Override
	public N remove(int index) {
		int i=0;
		Node<N> temp=start;
		while (i<=index) {
			temp=temp.next;
			i++;
		}
		temp.previous.next=temp.next;
		temp.next.previous=temp.previous;
		temp.previous=null;
		temp.next=null;
		size--;
		return temp.data;
	}

	@Override
	public N remove(Object object) {
		size();
		Node<N> temp=start;
		for (int i = 0; i < size; i++) {
			if (temp.data.equals(object)) {
				return remove(i);
			}
			temp=temp.next;
		}
		return null;
	}

	@Override
	public boolean clear() {
		Node<N> tempCurrentNode = start;
		Node<N> tempNextNode;
		size();
		for(int i=0; i < size; i++) {
			tempNextNode = tempCurrentNode.next;
			tempCurrentNode.previous=null;
			tempCurrentNode.data = null;
			tempCurrentNode.next = null;
			tempCurrentNode = tempNextNode;
		}
		start = null;
		end=null;
		size = 0;
		return true;
	}

	@Override
	public N get(int index) {
		size();
		if (index<0 || index>size) {
			return null;
		}
		Node<N> temp=start;
		for (int i = 0; i <= index; i++) {
			temp=temp.next;
		}
		return temp.data;
	}

	@Override
	public N set(int index, N element) {
		size();
		if (index<0 || index>size) {
			return null;
		}
		Node<N> temp=start;
		for (int i = 0; i <= index; i++) {
			temp=temp.next;
		}
		N oldValue=temp.data;
		temp.data=element;
		return oldValue;
	}

	@Override
	public int indexOf(Object object) {
		size();
		Node<N> temp=start;
		for (int i = 0; i < size; i++) {
			if (temp.data.equals(object)) {
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}

	@Override
	public MyList<N> subList(int start, int end) {
		size();
		if ((start>end) && (start<0 || start>size || end<0 || end>size)) {
			throw new IllegalArgumentException("Wrong index entered");
		}
		MyDoublyLinkedList<N> subList = new MyDoublyLinkedList<N>();
		Node<N> temp=this.start;
		int index=0;
		while (index<=start) {
			temp=temp.next;
			index++;
		}
		for(int i=start; i <= end; i++) {
			subList.add(temp.data);
			temp=temp.next;
		}
		return subList;
	}

	@Override
	public MyList<N> reverse() {
		MyDoublyLinkedList<N> reverse = new MyDoublyLinkedList<N>();
		Node<N> temp = start;
		for(int i=0; i < size; i++) {
			reverse.addFirst(temp.data);
			temp=temp.next;
		}
		return reverse;
	}

	@Override
	public void sort() {
		size();
		MyArrayList<N> tempList = new MyArrayList<N>(size);
		Node<N> tempNode = start;
		for(int i=0; i < size; i++) {
			tempList.add(tempNode.data);
			tempNode=tempNode.next;
		}
		tempList.sort();;
		tempNode=start;
		for(int i=0; i < tempList.size(); i++) {
			tempNode.data = tempList.get(i);
			tempNode=tempNode.next;
		}
	}

}
