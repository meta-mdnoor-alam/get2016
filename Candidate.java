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
	
	public Candidate() {
		this.candidateRank=0;
		this.candidateName=null;
		this.collegeAlloted=null;
		this.candidateQueueForCollege=new MyQueue<College>();
	}

	public int getCandidateRank() {
		return candidateRank;
	}

	public boolean setCandidateRank(int candidateRank) {
		this.candidateRank = candidateRank;
		return true;
	}
	
	public String getCandidateName() {
		return candidateName;
	}

	public boolean setCandidateName(String candidateName) {
		this.candidateName = candidateName;
		return true;
	}

	public College getCollegeAlloted() {
		return collegeAlloted;
	}

	public boolean setCollegeAlloted(College collegeAlloted) {
		this.collegeAlloted = collegeAlloted;
		return true;
	}

	public MyQueue<College> getCandidateQueueForCollege() {
		return candidateQueueForCollege;
	}

	public boolean setCandidateQueueForCollege(MyQueue<College> candidateQueueForCollege) {
		this.candidateQueueForCollege = candidateQueueForCollege;
		return true;
	}
}
