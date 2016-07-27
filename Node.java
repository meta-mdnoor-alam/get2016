package Session4;

/**
 * Class to implement node of social-network.
 * @author Noor
 */
public class Node {

	private int nodeId;
	private String name;
	private String gender;
	private String city;
	private String type;
	
	public Node() {
		nodeId=0;
		name=null;
		gender=null;
		city=null;
		type=null;
	}
	
	public Node(int nodeId, String name, String gender, String city, String type) {
		this.nodeId=nodeId;
		this.name=name;
		this.gender=gender;
		this.city=city;
		this.type=type;
	}
	
	public int getNodeId() {
		return nodeId;
	}
	
	public void setNodeId(int nodeId) {
		this.nodeId=nodeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
}
