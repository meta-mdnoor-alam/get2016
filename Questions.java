package Session2;

/**To sort questions based on question string.
 * @author Noor
 */
public class Questions implements Comparable<Questions> {
	
	private String questionString;
	
	/**
	 * Constructor
	 * @param questionString
	 */
	public Questions(String questionString){
		this.questionString = questionString;
	}
	
	/**
	 * @return question string
	 */
	public String getQuestion() {
		return questionString;
	}
	
	/**
	 * compareTo should return < 0 if this is supposed to be
	 * less than other, > 0 if this is supposed to be greater than
	 * other and 0 if they are supposed to be equal
	 */
	@Override
	public int compareTo(Questions other){
        int last = this.questionString.compareTo(other.questionString);
        return last;
    }
}
