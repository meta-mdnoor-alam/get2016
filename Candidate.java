package Session2;

/**
 * Class to store the candidate details.
 * @author Noor
 */
public class Candidate {

	private int candidateRank;
	private String candidateName;
	private College collegeAlloted;
	
	private MyQueue<College> candidateQueueForCollege;
	
	/**
	 * Default constructor.
	 */
	public Candidate() {
		this.candidateRank=0;
		this.candidateName=null;
		this.collegeAlloted=null;
		this.candidateQueueForCollege=new MyQueue<College>();
	}

	/**
	 * Method to get the candidate rank.
	 * @return
	 */
	public int getCandidateRank() {
		return candidateRank;
	}

	/**
	 * Method to set candidate rank.
	 * @param candidateRank
	 * @return success factor.
	 */
	public boolean setCandidateRank(int candidateRank) {
		this.candidateRank = candidateRank;
		return true;
	}
	
	/**
	 * Method to get candidate name.
	 * @return
	 */
	public String getCandidateName() {
		return candidateName;
	}

	/**
	 * Method to set candidate name.
	 * @param candidateName
	 * @return
	 */
	public boolean setCandidateName(String candidateName) {
		this.candidateName = candidateName;
		return true;
	}

	/**
	 * Method to get college details to which candidate is alloted.
	 * @return
	 */
	public College getCollegeAlloted() {
		return collegeAlloted;
	}

	/**
	 * Method to set candidates' college alloted details.
	 * @param collegeAlloted
	 * @return
	 */
	public boolean setCollegeAlloted(College collegeAlloted) {
		this.collegeAlloted = collegeAlloted;
		return true;
	}

	/**
	 * Method to get the candidates' queue for the college according to preferences.
	 * @return
	 */
	public MyQueue<College> getCandidateQueueForCollege() {
		return candidateQueueForCollege;
	}

	/**
	 * Method to set the candidates' queue of colleges based upon their preferences filled.
	 * @param candidateQueueForCollege
	 * @return
	 */
	public boolean setCandidateQueueForCollege(MyQueue<College> candidateQueueForCollege) {
		this.candidateQueueForCollege = candidateQueueForCollege;
		return true;
	}
}
