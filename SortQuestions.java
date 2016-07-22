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
		readQuestionsFromFile=new ReadQuestions("C:\\Users\\Noor\\Desktop\\Metacube\\workspace\\OOPs\\src\\Session2\\Questions.txt");
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		List<String> questionsList = new ArrayList<String>();
		sortQuestions=new SortQuestions();
		
		questionsList=readQuestionsFromFile.readLine();
		
		Collections.sort(questionsList);
		
		for (String string : questionsList) {
			System.out.println(string);
		}
	}
}
