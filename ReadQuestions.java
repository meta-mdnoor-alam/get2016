package Session2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**To read the questions from question.txt and display it on the screen
 * @author Noor
 */
public class ReadQuestions {

	List<String> lines;
	String questionLine;
	String fileName;
	BufferedReader fileObject;
	
	/**
	 * Parameterized Constructor of class ReadQuestions
	 * @param fileName
	 */
	public ReadQuestions(String fileName) {
		this.fileName=fileName;
	}
	
	/**
	 * whether file read is successful or not.
	 * @return success or failure
	 */
	private boolean fileRead() {
		try {
			fileObject=new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Reading line by line
	 * @return List of all the lines of questions.
	 * @throws IOException
	 */
	public List<String> readLine() throws IOException {
		if (fileRead()==true) {
			lines=new ArrayList<String>();
			while ((questionLine=fileObject.readLine())!=null) {
				lines.add(questionLine);
			}
		}
		return lines;
	}
}
