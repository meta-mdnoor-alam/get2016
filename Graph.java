package Session4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to implement graph with nodes and connecting edges.
 * @author Noor
 */
public class Graph {

	String nodeFileName;
	String connectionFileName;
	static List<Node> allNodeList;
	
	public Graph(String nodeFileName, String connectionFileName) {
		this.nodeFileName=nodeFileName;
		this.connectionFileName=connectionFileName;
		allNodeList=new ArrayList<Node>();
	}
	
	public void setAllNodeList() throws IOException {
		allNodeList=new FileReadHandler(nodeFileName).readNodeFile();
	}
	
	public void addNode(String type, Profile profile) throws IOException {
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

	public void addConnection(UserNode firstUserNode, UserNode secondUserNode) throws IOException {
		FileWriteHandler fileObject=new FileWriteHandler(connectionFileName);
		fileObject.writeConnection(firstUserNode, secondUserNode);
	}
	
	public Node searchByName(String name) throws IOException {
		for (int i = 0; i < allNodeList.size(); i++) {
			if (allNodeList.get(i).getProfile().getName().equalsIgnoreCase(name)) {
				return allNodeList.get(i);
			}
		}
		return null;
	}
	
	public List<Node> allFriends(Node node) {
		int size=AdjacencyMatrix.adjacencyMatrix.length;
		List<Node> friendList=new ArrayList<Node>();
		
		for (int i = 0; i < size; i++) {
			if (AdjacencyMatrix.adjacencyMatrix[node.getNodeId()][i]==1) {
				friendList.add(allNodeList.get(i));
			}
		}
		return friendList;
	}
	
	public boolean isFriend(String firstName, String secondName) throws IOException {
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
	
}
