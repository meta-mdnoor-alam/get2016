package Session4;

/**
 * Class to hold attributes of user type nodes.
 * @author Noor
 */
public class UserNode extends Node {

	UserProfile userProfile;
	
	public UserNode(int nodeId, String type, UserProfile userProfile) {
		super(nodeId, type, userProfile);
		this.userProfile=userProfile;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile=userProfile;
	}
	
	
	
	
	
}
