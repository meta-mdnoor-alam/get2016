package Session4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to implement graph with nodes and connecting edges.
 * @author Noor
 */
public class Graph {

	private static String nodeFileName;
	private static String connectionFileName;
	static List<Node> allNodeList;
	
	public Graph() {
		// TODO Auto-generated constructor stub
		allNodeList=new ArrayList<Node>();
	}
	
	@SuppressWarnings("static-access")
	public Graph(String nodeFileName, String connectionFileName) {
		this.nodeFileName=nodeFileName;
		this.connectionFileName=connectionFileName;
		allNodeList=new ArrayList<Node>();
	}
	
	public void setAllNodeList() throws IOException {
		allNodeList=new FileReadHandler(nodeFileName).readNodeFile();
	}
	
	public static void addNode(String type, Profile profile) throws IOException {
		//int nodeId=AdjacencyMatrix.adjacencyMatrix.length;
		int nodeId=9;
		Node node=new Node(nodeId, type, profile);
		FileWriteHandler fileObject=new FileWriteHandler(nodeFileName);
		if (type.equalsIgnoreCase("user")) {
			fileObject.writeUserNode((UserNode)node);
		} else {
			fileObject.writeOrgNode((OrganisationNode)node);
		}
	}

	public static void addConnection(UserNode firstUserNode, UserNode secondUserNode) throws IOException {
		FileWriteHandler fileObject=new FileWriteHandler(connectionFileName);
		fileObject.writeConnection(firstUserNode, secondUserNode);
	}
	
	public static Node searchByName(String name) throws IOException {
		for (int i = 0; i < allNodeList.size(); i++) {
			if (allNodeList.get(i).getProfile().getName().equalsIgnoreCase(name)) {
				return allNodeList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Method to search by name.
	 * @param name-- searches for this name in the graph 
	 * @return returns -1 if the node is not found else returns the index of the node
	 */
	public static  int searchByNameForEditing(String name) {
		int toBeReturned=-1;
		int totalNodes=Graph.allNodeList.size();
		for(int index=0;index<totalNodes;index++) {
			if(Graph.allNodeList.get(index).getProfile().getName().equalsIgnoreCase(name)) {
				toBeReturned=index;
				break;
			}
		}
		return toBeReturned;
	}
	
	public static List<Node> allFriends(Node node) {
		int size=AdjacencyMatrix.adjacencyMatrix.length;
		List<Node> friendList=new ArrayList<Node>();
		
		for (int i = 0; i < size; i++) {
			if (AdjacencyMatrix.adjacencyMatrix[node.getNodeId()][i]==1) {
				friendList.add(allNodeList.get(i));
			}
		}
		return friendList;
	}
	
	public static boolean isFriend(String firstName, String secondName) throws IOException {
		List<Node> firstFriendAllFriendList=allFriends(searchByName(firstName));
		boolean status=false;
	    int size=firstFriendAllFriendList.size();
	    for(int index=0;index<size;index++) {
	    	if(firstFriendAllFriendList.get(index).getProfile().getName().equalsIgnoreCase(secondName)) {
	    		status=true;
	    		break;
	    	}
	    }
	    return status;
	}
	
	public static boolean deleteProfile(String name) throws IOException {
		boolean status=false;
		Node node=Graph.searchByName(name);
		if(node==null) {
			status=false;
		} else {
			System.out.println("size before"+Graph.allNodeList.size());
			Graph.allNodeList.remove(node);
			System.out.println("size after"+Graph.allNodeList.size());
			status=true;
		}
		return status;
	}
	
	/**
	 * Method to edit the profile
	 * @param name edits the profile of the name specified
	 * @return true if the profile is successfully updated else returns false
	 * @throws IOException
	 */
	public static boolean editProfile(String name) throws IOException {
		Node node=Graph.searchByName(name);
		Scanner scanner=null;
		boolean toBeReturned=false;
		try {
			int status=Graph.searchByNameForEditing(name);
			if(status!=-1) {
				toBeReturned=true;
				System.out.println("******Previous details are*************");
				Display.displaySingleNode(node);
				scanner=new Scanner(System.in);
				System.out.println("Enter the name");
				String updatedName=scanner.next();
				System.out.println("Enter the place");
				String updatedPlace=scanner.next();
				node.getProfile().setName(updatedName);
				node.getProfile().setCity(updatedPlace);
				Graph.allNodeList.set(status, node);
				System.out.println("******Updated details are*************");
				Display.displaySingleNode(node);
			}
		} catch(Exception exception) {
			System.out.println("Sorry something went wrong "+exception.getMessage());
		} finally {
			if(scanner!=null) {
				scanner.close();
			}
		}
		return toBeReturned;
	}
	
	public static String mutualFriends(String friend1,String friend2) {
		String output="";
		int status1=Graph.searchByNameForEditing(friend1);
		int status2=Graph.searchByNameForEditing(friend2);
		if(status1==-1 || status2==-1) {
			return "";
		} else {
			int[] temp1=AdjacencyMatrix.adjacencyMatrix[status1];
			int totalColumns1=temp1.length;
			int[] temp2=AdjacencyMatrix.adjacencyMatrix[status2];
			for(int colIndex=0;colIndex<totalColumns1;colIndex++) {
				if(temp1[colIndex]==1 && temp2[colIndex]==1) {
					output+=Graph.allNodeList.get(colIndex).getProfile().getName()+"\n";
				}
			}
			return output;
		}
	}
	
	/**
	 * Method to add profile.
	 * @param scanner
	 * @throws IOException
	 */
	public static void addProfile(Scanner scanner) throws IOException {
		new Graph(nodeFileName, connectionFileName);
		Validations validate=new Validations();
		System.out.print("\n\nEnter the type of profile [organisation/user]  :\t");
		String type=scanner.next();
		if (!new Validations().validateType(type)) {
			addProfile(scanner);
		}
		System.out.println("\n\nEnter profile details  :");
		if (type.equalsIgnoreCase("user")) {
			System.out.print("\n\nUser's Name  :\t");
			String name=scanner.next();
			System.out.print("Age  :\t");
			int age=scanner.nextInt();
			System.out.print("Gender  :\t");
			String gender=scanner.next();
			System.out.print("City  :\t");
			String city=scanner.next();
			if (!validate.validateNameCity(name) || !validate.validateAge(age) || !validate.validateGender(gender) || !validate.validateNameCity(city)) {
				addProfile(scanner);
			}
			Graph.addNode("user", new UserProfile(name, city, age, gender));
		} else {
			System.out.print("\n\nOrganisation's Name  :\t");
			String orgName=scanner.next();
			System.out.print("Sector [public/private]  :\t");
			String sector=scanner.next();
			System.out.print("City  :\t");
			String city=scanner.next();
			if (!validate.validateNameCity(orgName) || !validate.validateSector(sector) || !validate.validateNameCity(city)) {
				addProfile(scanner);
			}
			Graph.addNode("organisation", new OrganisationProfile(orgName, city, sector));
		}
	}
}
