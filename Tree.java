package Session3;

/**
 * Program to create a tree.
 * @author Noor
 */
public class Tree<N> {

	private Node<N> root;
	
	/**
	 * Generic Inner class to make a tree node list with left pointing
	 * to left sub-tree and right pointing to right sub-tree of Node.
	 * @author Noor
	 * @param <N>
	 */
	private static class Node<N> {
		Node<N> left;
		N data;
		Node<N> right;

		public Node(Node<N> left, N data, Node<N> right) {
			this.left = left;
			this.data = data;
			this.right = right;
		}
	}
	
	public Tree() {
		root=new Node<N>(null, null, null);
	}
	
	public Tree(N data) {
		root=new Node<N>(null, data, null);
	}
	
	public boolean isEmpty() {
		return (root==null ? true : false);
	}
	
}
