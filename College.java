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

	/**
	 * Method to get the college rank
	 * @return
	 */
	public int getCollegeRank() {
		return collegeRank;
	}

	/**
	 * Method to set college rank.
	 * @param collegeRank
	 * @return
	 */
	public boolean setCollegeRank(int collegeRank) {
		this.collegeRank = collegeRank;
		return true;
	}
	
	/**
	 * Method to get college name.
	 * @return
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * Method to set college name
	 * @param collegeName
	 * @return
	 */
	public boolean setCollegeName(String collegeName) {
		this.collegeName = collegeName;
		return true;
	}

	/**
	 * Method to get the no. of seats available of a college.
	 * @return
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	/**
	 * Method to set the seats available of the college.
	 * @param seatsAvailable
	 * @return
	 */
	public boolean setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
		return true;
	}
}
