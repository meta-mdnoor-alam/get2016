package Session2;

/**To implement Question class to compare the lines of the question to sort.
 * @author Noor
 */
public class Questions implements Comparable<Object> {

	private String questionString;

	/**
	 * Constructor
	 * @param questionString
	 */
	public Questions(String questionString){
		this.questionString = questionString;
	}

	/**
	 * compareTo should return < 0 if this is supposed to be
	 * less than other, > 0 if this is supposed to be greater than
	 * other and 0 if they are supposed to be equal.
	 */
	@Override
	public int compareTo(Object secondObject) {

		Questions question = (Questions)secondObject;

		int last=question.questionString.compareTo(questionString);

		return (last==0 ? question.questionString.compareTo(questionString) : last);
	}
}
