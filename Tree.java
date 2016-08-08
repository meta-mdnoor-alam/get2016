package Session3;

import java.util.Scanner;

/**
 * Program to create a tree.
 * @author Noor
 */
public class Tree {

	private static Node root;
	Scanner scanner = new Scanner(System.in);
	
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
	
	/*public Tree() {
		root=new Node(null, -1, null);
	}*/
	
	public Tree(int data) {
		root=new Node(null, data, null);
	}
	
	/*public Tree(int data) {
		root=new Node(null, data, null);
	}*/
	
	public boolean isEmpty() {
		return (root==null ? true : false);
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
			return;
		}
		Node result=search(root, prevData);
		if (result == null) {
			System.out.println("Node result null");
		} else {
			System.out.println("Node result  "+result.data);
		}
		Node node=new Node(null, content, null);
		if (result!=null && result.data==prevData) {
			if (pos=='l' && result.left==null) {
				result.left=node;
			} else if (pos=='r' && result.right==null) {
				result.right=node;
			}
		}
	}
	
	public Node search(Node node, int searchTerm) {
		if (node == null) {
			return null;
		} else {
			if (node.data==searchTerm) {
				return node;
			}
			if (node.right!=null) {
				return search(node.right, searchTerm);
			}
			if (node.left!=null) {
				return search(node.left, searchTerm);
			}
			return null;
		}
		
		
		
		
		
		
		/*if (node==null) {
			return null;
		}
		else{
			System.out.println("Inside search searchTerm  "+node.data);
			if (node.data==searchTerm) {
				return node;
			}
			if (node.right!=null) {
				return search(node.right, searchTerm);
			}
			if (node.left!=null) {
				return search(node.left, searchTerm);
			}
			
			
			return node!=null ? node : null;
			if(node.left!=null) {
				return (search(node.left, searchTerm));
			} if(node.right!=null) {
				return search(node.right, searchTerm);
			}
		}*/

		/*if (node.data==searchTerm) {
			System.out.println("Inside search searchTerm  "+node.data);
			return node;
		}
		if (node.left!=null) {
			System.out.println("Inside left search searchTerm  "+node.data);
			 node=node.left;
		}
		if (node.right!=null) {
			System.out.println("Inside ryt search searchTerm  "+node.data);
			 node=node.right;
		}
		return search(node, searchTerm);*/
		
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
                	
                	/*System.out.println("create node -1,'n',10");
                	createNode(-1,'n',10);*/
                	int delay;
                    
                    System.out.println("create node 10,'l',30");
                    createNode(10,'l',30);
                    print();
                    //delay = scanner.nextInt();
                    
                    System.out.println("create node 30,'l',7");
                    createNode(30,'l',7);
                    print();
                    //delay = scanner.nextInt();
                    
                    System.out.println("create node 7,'r',9");
                    createNode(7,'r',9);
                    print();
                   // delay = scanner.nextInt();
                    
                    System.out.println("create node 30,'r',2");
                    createNode(30,'r',2);
                    print();
                   // delay = scanner.nextInt();
                    
                    System.out.println("create node 10,'r',20");
                    createNode(10,'r',20);
                    print();
                    //delay = scanner.nextInt();
                   
                    System.out.println("create node 20,'l',8");
                    createNode(20,'l',8);
                    print();
                   // delay = scanner.nextInt();
                    
                    System.out.println("create node 20,'r',6");
                    createNode(20,'r',6);
                    print();
                    
                    System.out.println("create node 7,'r',12");
                    createNode(7,'r',12);
                    print();
                    //delay = scanner.nextInt();
                    
                    
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
        new Tree(10).displaymenu();
    }
}
