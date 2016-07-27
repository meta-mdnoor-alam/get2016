package Session4;

/**
 * @author admin
 *
 */
public class OrganisationProfile extends Profile {

	private String sector;
	
	public OrganisationProfile(String name, String city, String type, String sector) {
		super(name, city, type);
		this.sector=sector;
	}
	
	public String getSector() {
		return sector;
	}
	
	public void setSector(String sector) {
		this.sector=sector;
	}

}
