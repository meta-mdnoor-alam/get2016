package Session2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**To write response of the participant of the survey into a file response.txt
 * @author Noor
 */
public class WriteResponse {

	List<String> response;
	BufferedWriter writeObject;
	
	/**
	 * Constructor
	 * @param response
	 * @throws IOException
	 */
	public WriteResponse(List<String> response) throws IOException {
		this.response=response;
		writeObject=new BufferedWriter(new FileWriter("C:\\Users\\Noor\\Desktop\\Metacube\\workspace\\OOPs\\bin\\Session2\\response.txt"));
	}
	
	/**
	 * @return whether success or failure while writing user response into file.
	 * @throws IOException
	 */
	public boolean writeToFile() throws IOException {
		if (response.size()>0) {
			for (int i = 0; i < response.size(); i++) {
				writeObject.write((response.get(i).toString()));
				writeObject.newLine();
			}
			writeObject.close();
			return true;
		}
		return false;
	}
}