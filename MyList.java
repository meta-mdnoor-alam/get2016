package Session1;

/**
 * To implement List interface using array.
 * @author Noor
 */
public interface MyList<N> {
	public int size();
	public boolean add(N element);
	public boolean add(int index, N element);
	public void addAll(MyList<N> list);
	public boolean isEmpty();
	public boolean contains(Object obj);
	public N remove(int index);
	public N remove(Object object);
	public boolean clear();
	public N get(int index);
	public N set(int index, N element);
	public int indexOf(Object obj);
	public MyList<N> subList(int start, int end);
	public MyList<N> reverse();
	public void sort();
}
