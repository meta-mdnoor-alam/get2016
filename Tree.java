package Session3;

import java.util.Scanner;

/**
 * Program to create a tree.
 * @author Noor
 */
public class Tree {

	private Node root;
	Scanner scanner = new Scanner(System.in);
	static int size=0;
	
	/**
	 * Generic Inner class to make a tree node list with left pointing
	 * to left sub-tree and right pointing to right sub-tree of Node.
	 * @author Noor
	 * @param 
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
	
	public Tree() {
		root=new Node(null, -1, null);
		size=0;
	}
	
	public Tree(int data) {
		root=new Node(null, data, null);
		size=0;
	}
	
	/*public Tree(int data) {
		root=new Node(null, data, null);
	}*/
	
	public boolean isEmpty() {
		return (root.data==-1 ? true : false);
	}
	
	/*public Node createNode() 
	{

		int value = getData();


		Node temp = new Node(null,value,null);
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
		
		if(root.data==0)
		{
			root = temp;
		}

		return temp;
	}*/
	
	/*public Node createNode(Node temp, int value) 
	{	value = getData();
	    Node newnode = new Node(null, value, null);
	    
	    temp = newnode;
	    if(root == null)
	    {
	        root = temp;
	    }
	    System.out.println("If left child exits for ("+value+") enter y else n");
	    char ch=scanner.next().charAt(0);
		if(ch=='y')
	    {
	        newnode.left = createNode(newnode.left, value);
	    }
	    System.out.println("If right child exits for ("+value+") enter y else n");
	    char cr=scanner.next().charAt(0);
		if(cr=='y')
	    {
	        newnode.right = createNode(newnode.right, value);
	    } 
	    return newnode;
	}*/
	
	public void createNode(int prevData, char pos, int content) {
		if (pos=='n') {
			root= new Node(null, content, null);
			System.out.println("yaha andar");
			return;
		}
		Node result=search(root, prevData);
		if (result==null) {
			System.out.println(root.data+"  aa gya null");
		}
		System.out.println("Previousdata "+result.data);
		System.out.println(root.data);
		Node node=new Node(null, content, null);
		if (result!=null && result.data==prevData) {
			if (pos=='l' && result.left==null) {
				result.left=node;
			} else if (pos=='r' && result.right==null) {
				result.right=node;
			}
		}
	}
	
	public Node search(Node node, int value) {
		if (node!=null) {
			if (node.data==value) {
				return node;
			}  if(node.left!=null) {
				return (search(node.left, value));
			} if(node.right!=null) {
				return search(node.right, value);
			}
			System.out.println("Galat output");
			return node;
		}
		else{
			System.out.println("node is null:"+value);
			return null;
		}
	}
	
	
	/*public int getData()
    {	
        System.out.println("Enter the value to insert:");
        return scanner.nextInt();
    }*/

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
        else{
        	return;
        }
     
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
                    break;
                case 2:
                	createNode(-1,'n',10);
                    createNode(10,'l',20);
                    createNode(20,'l',6);
                    createNode(10,'r',30);
                    createNode(30,'l',2);
                    createNode(30,'r',7);
                    createNode(7,'l',9);
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
    
    
    public static void main(String[] args)
    { 
        new Tree().displaymenu();
    }
}
