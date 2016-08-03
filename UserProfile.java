package Session4;

/**
 * @author admin
 *
 */
public class UserProfile extends Profile {

	private int age;
	private String gender;
	
	public UserProfile(String name, String city, int age, String gender) {
		super(name, city, "user");
		this.age=age;
		this.gender=gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	/*public int getFriendCount() {
		return friendCount;
	}
	
	public void setFriendCount() {
		this.friendCount=;
	}*/
}
