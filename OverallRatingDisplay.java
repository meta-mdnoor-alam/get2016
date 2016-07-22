package Session2;

import java.util.List;

/**To display overall rating of single select questions on console.
 * @author Noor
 */
public class OverallRatingDisplay {

	private List<String> responseList;
	private String[] optionArray;
	private String question;
	private String optionsString;
	private int[] countOfOptions;
	private double[] rating;
	private boolean haveSingleSelectQuestion;
	
	/**
	 * Parameterized constructor
	 * @param question
	 * @param options
	 * @param haveSingleSelectQuestion
	 */
	public OverallRatingDisplay(String question, String options, boolean haveSingleSelectQuestion) {
		this.question=question;
		this.optionsString=options;
		this.haveSingleSelectQuestion=haveSingleSelectQuestion;
		
		optionArray=optionsString.split("[/]");
		countOfOptions=new int[optionArray.length];
		rating=new double[optionArray.length];
		
		//initializing all countOfOptions[] array elements to 0.
		for (int i = 0; i < countOfOptions.length; i++) {
			countOfOptions[i]=0;
		}
	}
	
	/**
	 * @param responseList
	 * @return Whether able to overall response list or not.
	 */
	public boolean overallResponse(List<String> responseList) {
		this.responseList=responseList;
		return haveSingleSelectQuestion;
	}
	
	/**
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * @retur0n options in String form.
	 */
	public String getOptions() {
		return optionsString;
	}
	
	/**
	 * Initialising count for each options input by the user in Single Select question.
	 */
	private void countInitializer() {
		String[] temp;
		for (int i = 0; i < responseList.size(); i++) {
			temp=responseList.get(i).toString().split("[,]");
			countOfOptions[Integer.parseInt(temp[3].charAt(1)+"")-1]++;
		}
	}
	
	/**
	 * To set the rating percentage for each options.
	 * @return
	 */
	public double[] setRating() {
		countInitializer();
		for (int i = 0; i < countOfOptions.length; i++) {
			rating[i]=(double)(countOfOptions[i]*100)/responseList.size();
		}
		return rating;
	}
}
