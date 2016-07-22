package Session2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * To Sort the lines of the question and display them over screen.
 * @author Noor
 */
public class SortQuestions {

	static ReadQuestions readQuestionsFromFile;
	static SortQuestions sortQuestions;

	/**
	 * Constructor
	 */
	public SortQuestions() {
		readQuestionsFromFile=new ReadQuestions("Questions.txt");
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		sortQuestions=new SortQuestions();
		List<Questions> questionsList = new ArrayList<Questions>();
		List<String> readListFromFile=readQuestionsFromFile.readLine();
		
		for (String temp : readListFromFile) {
			Questions questionClassObject=new Questions(temp.split("[,]")[0]);
			questionsList.add(questionClassObject);
		}
		
		Collections.sort(questionsList);
		
		for (Questions question : questionsList) {
			System.out.println(question.getQuestion());
		}
	}
}
