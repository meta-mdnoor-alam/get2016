package Session4;

/**
 * Class to stor the 
 * @author Noor
 *
 */
public class Guest {

	private String guestName;
	private String guestAge;
	
	/**
	 * Parameterized constructor
	 * @param guestName
	 * @param guestAge
	 */
	public Guest(String guestName, String guestAge) {
		this.setGuestName(guestName);
		this.setGuestAge(guestAge);
	}

	/**
	 * Method to get guest name.
	 * @return the guestName
	 */
	public String getGuestName() {
		return guestName;
	}

	/**
	 * Method to set guest name.
	 * @param guestName the guestName to set
	 */
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	/**
	 * Method to get guest age.
	 * @return the guestAge
	 */
	public String getGuestAge() {
		return guestAge;
	}

	/**
	 * Method to set guest age.
	 * @param guestAge the guestAge to set
	 */
	public void setGuestAge(String guestAge) {
		this.guestAge = guestAge;
	}

}
