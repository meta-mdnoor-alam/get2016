package Session2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**To handle and store the user response in a list.
 * @author Noor
 */
public class ResponseHandler {

	private List<String> responseList;
	
	/**
	 * Constructor
	 */
	public ResponseHandler() {
		responseList=new ArrayList<String>();
	}
	
	/**
	 * @param participant
	 * @param responseString
	 */
	public void addResponseToList(int participant, String responseString) {
		responseList.add(participant, "Participant"+(participant+1)+", "+responseString);
	}
	
	/**
	 * @return response of the participant.
	 */
	public List<String> takeResponse() {
		return responseList;
	}
	
	/**
	 * Passing list of responses to write it into a file.
	 * @throws IOException
	 */
	public void writeResponses() throws IOException {
		WriteResponse w=new WriteResponse(responseList);
		w.writeToFile();
	}
}
