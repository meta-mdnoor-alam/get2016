package Session2;

/**
 * Class to store the college details.
 * @author Noor
 */
public class College {
	
	private int collegeRank;
	private String collegeName;
	private int seatsAvailable;

	/**
	 * Default constructor
	 */
	public College() {
		this.collegeRank = 0;
		this.collegeName=null;
		this.seatsAvailable = 0;
	}

	public int getCollegeRank() {
		return collegeRank;
	}

	public boolean setCollegeRank(int collegeRank) {
		this.collegeRank = collegeRank;
		return true;
	}
	
	public String getCollegeName() {
		return collegeName;
	}

	public boolean setCollegeName(String collegeName) {
		this.collegeName = collegeName;
		return true;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public boolean setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
		return true;
	}
}
