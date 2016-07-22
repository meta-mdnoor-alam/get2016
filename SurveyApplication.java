package Session2;

import java.io.IOException;
import java.util.Scanner;

/**Read around 5-7 Questions of type Single Select, Multiple Select, Text and Number & available options from input text file.
 * @author Noor
 */
public class SurveyApplication {

	private boolean proceed;
	private String response;
	private String wholeResponse;
	static Scanner scanner;
	static private boolean haveSingleSelectQuestion;
	
	SplitQuestion split;
	ValidateInput validate;
	static OverallRatingDisplay displayOverall;
	
	/**
	 * Constructor
	 * @param fileName
	 * @throws IOException
	 */
	public SurveyApplication(String fileName) throws IOException {
		split=new SplitQuestion(fileName);
		validate=new ValidateInput();
		proceed=split.initializeLabelTypeOptions();
		wholeResponse="";
		haveSingleSelectQuestion=false;
		scanner=new Scanner(System.in);
	}
	
	/**
	 * @return Whole string of response of a participant.
	 */
	private String askQuestionsAndGetAnswers() {
		if (proceed) {
			wholeResponse="";
			
			for (int i = 0; i < split.getQuestionLabel().size(); i++) {
				System.out.print(split.getQuestionLabel().get(i)+"  "+split.getQuestionType().get(i)+
									"  "+split.getQuestionOptions().get(i)+"  ");
				
				//custom message for Multi Select type questions.
				if (split.getQuestionType().get(i).toString().equalsIgnoreCase("(Multi Select Type)")) {
					System.out.print("\n(multiple responses should be separated by backslash '/')  :");
				}
				
				response=scanner.nextLine();
				if (!validate.isValidResponse(i+1, response)) {
					return null;
				}
				
				wholeResponse+=response+", ";
				
				//if there includes a Single Select type question, then generate report in console.
				if (split.getQuestionType().get(i).equalsIgnoreCase("(Single Select Type)")) {
					haveSingleSelectQuestion=true;
					displayOverall=new OverallRatingDisplay(split.getQuestionLabel().get(i), 
															split.getQuestionOptions().get(i)
																 .substring(1, split.getQuestionOptions()
														         .get(i).length()-1),
													        haveSingleSelectQuestion);
				}
			}
		}
		
		return wholeResponse.substring(0,wholeResponse.length()-2);
	}
	
	
	public static void main(String[] args) throws IOException {

		SurveyApplication survey=new SurveyApplication("C:\\Users\\Noor\\Desktop\\Metacube\\workspace\\OOPs\\src\\Session2\\Questions.txt");
		ResponseHandler responseObject=new ResponseHandler();
		char choice;
		int participant=0;
		String temp;
		
		//Number of participant taking survey are dynamic.
		do {
			temp=survey.askQuestionsAndGetAnswers();
			if (temp==null) {
				System.out.println("Enter valid response...");
				choice='y';
				System.out.println("\n\n");
				continue;
			}
			responseObject.addResponseToList(participant++, temp);
			
			System.out.print("\n\nDo you want to take more surveys(y/n)  :");
			choice=scanner.nextLine().charAt(0);
			System.out.println("\n\n");
		} while (choice!='n' && choice=='y');
		
		responseObject.writeResponses();
		
		if (haveSingleSelectQuestion) {
			displayOverall.overallResponse(responseObject.takeResponse());
			double[] rating=displayOverall.setRating();
			
			System.out.print("\n\n"+displayOverall.getQuestion()+",(Single Select Type), ("+displayOverall.getOptions()+")\n");
			String[] options=displayOverall.getOptions().substring(0, displayOverall.getOptions().length()).split("[/]");
			for (int i = 0; i < rating.length; i++) {
				System.out.print(options[i]+" - "+rating[i]+"%\n");
			}
		}
		
		scanner.close();
	
	}
}
