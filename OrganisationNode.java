package Session4;

/**
 * Class to hold attributes of organisation type node.
 * @author Noor
 */
public class OrganisationNode extends Node {

	OrganisationProfile orgProfile;
	
	public OrganisationNode(int nodeId, String type, OrganisationProfile orgProfile) {
		super(nodeId, type, orgProfile);
		this.orgProfile=orgProfile;
	}
	
	public OrganisationProfile getOrganisationProfile() {
		return orgProfile;
	}
	
	public void setOrganisationProfile(OrganisationProfile orgProfile) {
		this.orgProfile=orgProfile;
	}
}
