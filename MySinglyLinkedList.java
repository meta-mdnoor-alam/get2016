package Session1;

/**
 * Class to implement the concept of generic singly-linkedlist by implementing the MyList interface.
 * @author Noor
 */
public class MySinglyLinkedList<N> implements MyList<N> {

	private Node<N> start;
	
	int size;
 
	/**
	 * Default constructor.
	 */
	public MySinglyLinkedList() {
		start=null;
		size=0;
	}
	
	/**
	 * Generic Inner class to make a node of the singly-linked list with
	 * next pointing references of the Node type.
	 * @author Noor
	 * @param <N> Generic type of the node data.
	 */
	private static class Node<N> {
		N data;
		Node<N> next;
		
		public Node(N data, Node<N> next) {
			this.data=data;
			this.next=next;
		}
	}
	
	@Override
	public int size() {
		size=0;
		if (start==null) {
			size=0;
		} else if (start.next==null) {
			size++;
		} else {
			Node<N> tempNode=start;
			while (tempNode.next!=null) {
				tempNode=tempNode.next;
				size++;
			}
		}
		return size;
	}

	@Override
	public boolean add(N element) {
		Node<N> node=new Node<N>(element, null);
		if (start==null) {
			start=node;
			size++;
			return true;
		}
		Node<N> temp=start;
		while (temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
		size++;
		return true;
	}
	
	/**
	 * Method to add element at the first location of the list.
	 * @param element
	 * @return success or not.
	 */
	public boolean addFirst(N element) {
		Node<N> node=new Node<N>(element, null);
		if (start==null) {
			start=node;
		} else {
			node.next=start;
			start=node;
		}
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
			Node<N> node=new Node<N>(element, null);
			int i=0;
			Node<N> tempCurentNode=start;
			while (i<index) {
				tempCurentNode=tempCurentNode.next;
				i++;
			}
			Node<N> tempNextNode=tempCurentNode.next;
			tempCurentNode.next=node;
			node.next=tempNextNode;
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
		size();
		if (index<0 || index>size) {
			throw new IllegalArgumentException();
		} else {
			Node<N> tempPrevious=start;
			while (i<index-1) {
				tempPrevious=tempPrevious.next;
				i++;
			}
			Node<N> nodeToDelete=tempPrevious.next;
			if (index==size-1) {
				tempPrevious.next=null;
			} else {
				tempPrevious.next=nodeToDelete.next;
				nodeToDelete.next=null;
			}
			size--;
			return nodeToDelete.data;
		}
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
			tempCurrentNode.data = null;
			tempCurrentNode.next = null;
			tempCurrentNode = tempNextNode;
		}
		start = null;
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
		for (int i = 0; i < index; i++) {
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
		MySinglyLinkedList<N> subList = new MySinglyLinkedList<N>();
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
		MySinglyLinkedList<N> reverse = new MySinglyLinkedList<N>();
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
