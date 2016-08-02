package Session2;

/**
 * Class to maintain queue for all candidates.
 * @author Noor
 */
public class AllCandidatesQueue {

	// stores the candidates in the order of their rank
	private static MyQueue<Candidate> allCandidates;

	/**
	 * Default constructor
	 */
	public AllCandidatesQueue() {
		allCandidates=new MyQueue<Candidate>();
	}

	/**
	 * Method to get all the candidate queue.
	 * @return
	 */
	public static MyQueue<Candidate> getAllCandidates() {
		return allCandidates;
	}
}
