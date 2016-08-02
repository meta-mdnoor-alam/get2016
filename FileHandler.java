/**
 * 
 */
package Session2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author admin
 *
 */
public class FileHandler {

	private String candidateListFileName;
	private String collegeListFileName;
	
	/**
	 * Parameterized constructor
	 */
	public FileHandler(String candidateListFileName, String collegeListFileName) {
		this.candidateListFileName=candidateListFileName;
		this.collegeListFileName=collegeListFileName;
	}
	
	/**
	 * Method to read the candidates' details from file
	 * @return all candidates queue.
	 * @throws IOException
	 */
	public AllCandidatesQueue readCandidateDetails() throws IOException {
		AllCandidatesQueue allCandidatesQueue = new AllCandidatesQueue();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(candidateListFileName));
			String currentLine = "";
			String[] commaSeparatedValues;
			while ((currentLine = bufferedReader.readLine()) != null) {
				commaSeparatedValues = currentLine.split(",");
				String candidateName = commaSeparatedValues[0];
				int candidateRank = Integer.parseInt(commaSeparatedValues[1]);
				Candidate candidate = new Candidate();
				candidate.setCandidateName(candidateName);
				candidate.setCandidateRank(candidateRank);
				AllCandidatesQueue.getAllCandidates().enqueue(candidate);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("The file could not be found "+ fileNotFoundException.getMessage());
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return allCandidatesQueue;
	}
	
	/**
	 * Method to read the college's details from file.
	 * @return all college queue
	 * @throws IOException
	 */
	public AllCollegesQueue readCollegeDetails() throws IOException {

		BufferedReader bufferedReader = null;
		AllCollegesQueue allCollegesQueue = new AllCollegesQueue();
		try {
			bufferedReader = new BufferedReader(new FileReader(collegeListFileName));
			String currentLine = "";
			String[] commaSeparatedValues;

			while ((currentLine = bufferedReader.readLine()) != null) {
				commaSeparatedValues = currentLine.split(",");
				String collegeName = commaSeparatedValues[0];
				int collegeRank = Integer.parseInt(commaSeparatedValues[1]);
				int seatsAvailable = Integer.parseInt(commaSeparatedValues[2]);
				College college = new College();
				college.setCollegeName(collegeName);
				college.setCollegeRank(collegeRank);
				college.setSeatsAvailable(seatsAvailable);
				AllCollegesQueue.getAllColleges().enqueue(college);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("The file could not be found "+ fileNotFoundException.getMessage());
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return allCollegesQueue;
	}
}
