package Session3;

import java.util.Scanner;

/**
 * Program to create a tree.
 * @author Noor
 */
public class Test {
	
	private static Scanner scanner=new Scanner(System.in);

	private Node root;
	
	/**
	 * Generic Inner class to make a tree node list with left pointing
	 * to left sub-tree and right pointing to right sub-tree of Node.
	 * @author Noor
	 * @param <Integer>
	 */
	private static class Node {
		Node left;
		int data;
		Node right;

		public Node(Node left, int data, Node right) {
			this.left = left;
			this.data = data;
			this.right = right;
		}
	}
	
	public Test() {
		root=new Node(null, 0, null);
	}
	
	public Test(int data) {
		root=new Node(null, data, null);
	}
	
	public boolean isEmpty() {
		return (root==null ? true : false);
	}
	
	public Node createNode() 
	{

		int value = getData();


		Node temp = new Node(null,value,null);
		if(root==null)
		{
			root = temp;
		}
		System.out.println("Do you want to add left branch on node("+value+")? Enter y/n");
		char ch=scanner.next().charAt(0);
		if(ch=='y')
		{
			temp.left=createNode();
		} else{
			temp.left=null;
		}
		System.out.println("Do you want to add right branch on node("+value+")? Enter y/n");
		char cr=scanner.next().charAt(0);
		if(cr=='y')
		{
			temp.right=createNode();
		}   else{
			temp.right=null;
		}  

		return temp;
	}
	
	
	public int getData()
    {	
        System.out.println("Enter the value to insert:");
        return scanner.nextInt();
    }

    public void print()
    {
        inorder(root);
    }
    public void inorder(Node node)
    {
        if(node!=null)
        {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
        else
            return;
    }
    
    public void displaymenu()
    {
        int choice;
        do{
            System.out.print("\n Basic operations on a tree:");
            System.out.print("\n 1. Create tree  \n 2. Insert \n 3. Search value \n 4. print list\n Else. Exit \n Choice:");
            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                	createBTree();
                    break;
                case 2:
                    createNode();
                    break;
                case 3:
                    //searchnode();
                    break;
                case 4:
                   print();
                    break;
                default:
                    return;
            }       
        }while(true);
    }
    public Test createBTree()
    {
        return new Test();
    }
    
    public static void main(String[] args)
    { 
        new Test().displaymenu();
    }
}