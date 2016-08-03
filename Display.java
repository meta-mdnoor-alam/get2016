package Session4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Class to encapsulate all the things to display over screen.
 * @author Noor
 */
public class Display {

	String nodeFileName;
	String connectionFileName;
	
	Scanner scanner=new Scanner(System.in);
	
	/**
	 * Parameterized constructor.
	 * @param nodeFileName
	 * @param connectionFileName
	 */
	public Display(String nodeFileName, String connectionFileName) {
		this.nodeFileName=nodeFileName;
		this.connectionFileName=connectionFileName;
	}
	
	/**
	 * Method to display file menu to user.
	 * @param scanner
	 * @return
	 */
	public int displayFirstMenu(Scanner scanner) {
		int choice;
		System.out.print("\n\n1. Add your profile.");
		System.out.print("\n2. View whole graph network.");
		System.out.print("\n3. Search a friend by name.");
		System.out.print("\n4. Check if two users are friend.");
		System.out.print("\n5. Edit Profile.");
		System.out.print("\n6. Mutual Friend.");
		System.out.print("\n\nEnter your choice  :\t");
		choice=scanner.nextInt();
		return choice;
	}

	/**
	 * Method to check choice of the user and call required function.
	 * @param choice
	 * @param scanner
	 * @throws IOException
	 */
	public void operateUponChoice(int choice, Scanner scanner) throws IOException {
		switch (choice) {
		case 1:
			Graph.addProfile(scanner);
			break;
		case 2:
			displaySocialNetwork();
			break;
		case 3:
			displaySearchName();
			break;
		case 4:
			displayIsFriendMenu();
			break;
		case 5:
			displayEditProfile();
			break;
		case 6:
			displayMutualFriend();
			break;
		default:
			System.out.println("\n\nEnter valid choice...");
			displayFirstMenu(scanner);
		}
	}

	
	
	/**
	 * displays the social network
	 * Shows the name of each user and the all other users who are connected to that user
	 */
	public void displaySocialNetwork() {
		int[][] adjacencyMatrix=AdjacencyMatrix.adjacencyMatrix;
		List<Node> nodeList=Graph.allNodeList;
		int totalNodes=nodeList.size();
		int columns=adjacencyMatrix[0].length;
		System.out.println("Name \t\tConnected to\n");
		
		for(int index=0;index<totalNodes;index++) {
			System.out.print(nodeList.get(index).getProfile().getName()+"\t\t");
			for(int colIndex=0;colIndex<columns;colIndex++) {
				if(adjacencyMatrix[index][colIndex]==1) {
					System.out.print(nodeList.get(colIndex).getProfile().getName()+",");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param node denotes the node Object whose details are to be displayed on the console
	 */
	public static void displaySingleNode(Node node) {
		System.out.println("NodeId :"+node.getNodeId());
		System.out.println("Name:"+node.getProfile().getName());
		System.out.println("Place:"+node.getProfile().getCity());
		String typeOfNode=node.getType();
		if(typeOfNode.equalsIgnoreCase("User")) {
			UserNode userNode=(UserNode)node;
			System.out.println("Type Of Node: User Node");
			System.out.println("Age  : "+userNode.getUserProfile().getAge()+"\n");
		} else {
			OrganisationNode organisationNode=(OrganisationNode)node;
			System.out.println("Type Of Node : Organisation Node");
			System.out.println("Secror : "+organisationNode.getOrganisationProfile().getSector()+"\n");
		}	
	}
	
	public void displayIsFriendMenu() throws IOException {
		System.out.println("Enter first name");
      	String firstName=scanner.next();
      	System.out.println("Enter the second name");
      	String secondName=scanner.next();
      	if(Graph.isFriend(firstName, secondName)) {
    	  System.out.println(firstName+ " and "+secondName+" are friends");
      	} else {
    	  System.out.println(firstName+ " and "+secondName+" are not friends");
      	}
	}
	
	public void displaySearchName() throws IOException {
		System.out.println("Enter the name to be searched  :");
		Node node=Graph.searchByName(scanner.next());
		if(node==null) {
			System.out.println("No record found");
		} else {
			System.out.println("NodeNumber:"+node.getNodeId());
			System.out.println("Type:"+(node.getType().equalsIgnoreCase("Organisation") ? "Organisation Node" : "User Node"));
			System.out.println("Name:"+node.getProfile().getName());
			System.out.println("Place:"+node.getProfile().getCity());
		}
	}
	
	public void displayEditProfile() throws IOException {
		System.out.println("Enter the profile you want to edit  :");
		String profileToBeEdited=scanner.next();
		Graph.editProfile(profileToBeEdited);
	}
	
	public void displayMutualFriend() {
		System.out.println("Enter the name of first user");
		String friend1=scanner.next();
		System.out.println("Enter the name of second user");
		String friend2=scanner.next();
		String mutuals=Graph.mutualFriends(friend1, friend2);
		if(mutuals.equalsIgnoreCase("")) {
			System.out.println("Sorry No mutuals found");
		} else {
			System.out.println("Mutuals of "+friend1+" and "+friend2+"\n\n"+mutuals);
		}
	}
}
