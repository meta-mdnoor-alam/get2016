package Session4;

/**
 * Class to implement node of social-network.
 * @author Noor
 */
public class Node {

	private int nodeId;
	private String type;
	Profile profile;
	
	public Node(int nodeId, String type, Profile profile) {
		this.nodeId=nodeId;
		this.type=type;
		this.profile=profile;
	}
	
	public int getNodeId() {
		return nodeId;
	}
	
	public void setNodeId(int nodeId) {
		this.nodeId=nodeId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	public void setProfile(Profile profile) {
		this.profile=profile;
	}
}
