package Session2;

/**
 * Class to maintain queue for all candidates.
 * @author Noor
 */
public class AllCandidatesQueue {

	// stores the candidates in the order of their rank
	private static MyQueue<Candidate> allCandidates;

	public AllCandidatesQueue() {
		allCandidates=new MyQueue<Candidate>();
	}

	public static MyQueue<Candidate> getAllCandidates() {
		return allCandidates;
	}
}
