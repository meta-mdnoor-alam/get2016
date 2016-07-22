package Session2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**To split question label, question type and question options of each question.
 * @author Noor
 */
public class SplitQuestion {

	private List<String> questionLabel;
	private List<String> questionType;
	private List<String> questionOptions;
	
	ReadQuestions readFromFile;
	
	/**
	 * Constructor
	 * @param fileName
	 */
	public SplitQuestion(String fileName) {
		readFromFile=new ReadQuestions(fileName);
		
		questionLabel=new ArrayList<String>();
		questionType=new ArrayList<String>();
		questionOptions=new ArrayList<String>();
	}
	
	/**
	 * Initialize the Label, Type and Options of the questions.
	 * @return success or failure
	 * @throws IOException
	 */
	public boolean initializeLabelTypeOptions() throws IOException {
		String[] temp;
		
		for (int i = 0; i < readFromFile.readLine().size(); i++) {
			temp=readFromFile.readLine().get(i).toString().split("[,]");
			questionLabel.add(temp[0]);
			questionType.add(temp[1]);
			questionOptions.add(temp[2]);
		}
		
		return (questionLabel.size()==0 ? false : true); 
	}
	
	/**
	 * @return questionLabel
	 */
	public List<String> getQuestionLabel() {
		return questionLabel;
	}
	
	/**
	 * @return questionsOptions.
	 */
	public List<String> getQuestionType() {
		return questionType;
	}
	
	/**
	 * @return questionOptions.
	 */
	public List<String> getQuestionOptions() {
		return questionOptions;
	}
}
