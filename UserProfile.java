package Session4;

/**
 * @author admin
 *
 */
public class UserProfile extends Profile {

	private int age;
	private String gender;
	private int friendCount;
	
	public UserProfile(String name, String city, String type, int age, String gender, int friendCount) {
		super(name, city, type);
		this.age=age;
		this.gender=gender;
		this.friendCount=friendCount;
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
	
	public int getFriendCount() {
		return friendCount;
	}
	
	public void setFriendCount(int friendCount) {
		this.friendCount=friendCount;
	}
}
