package Session2;

import java.io.IOException;

/**
 * @author admin
 *
 */
public class CollegeCounsellingProcess {
	
	private static final String COLLEGE_LIST_FILENAME="src//Session2//CollegeList.txt";
	private static final String CANDIDATE_LIST_FILENAME="src//Session2//CandidateList.txt";

	/**
	 * Method to allocate seats to various candidates based upon their ranks and preferences
	 */
	public void allocateSeats() {
		int totalCandidates = AllCandidatesQueue.getAllCandidates().size();
		
		for (int index = 0; index < totalCandidates; index++) {
			Candidate candidate = AllCandidatesQueue.getAllCandidates().getValueByIndex(index);
			int totalPreferences = candidate.getCandidateQueueForCollege().size();
			for (int index2 = 0; index2 < totalPreferences; index2++) {
				int collegeRank = candidate.getCandidateQueueForCollege().getValueByIndex(index2).getCollegeRank();
				College college = AllCollegesQueue.getCollegeByRank(collegeRank);
				if (college.getSeatsAvailable() > 0) {
					college.setSeatsAvailable(college.getSeatsAvailable() - 1);
					candidate.setCollegeAlloted(college);
					break;
				}
			}
		}
	}

	/**
	 * Program main function.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileHandler fileHandler = new FileHandler(CANDIDATE_LIST_FILENAME, COLLEGE_LIST_FILENAME);
		fileHandler.readCandidateDetails();
		AllCollegesQueue allCollegesQueue = fileHandler.readCollegeDetails();
		Counseling counselling = new Counseling();
		int totalCandidates = AllCandidatesQueue.getAllCandidates().size();
		
		for (int index = 0; index < totalCandidates; index++) {
			Candidate candidate = AllCandidatesQueue.getAllCandidates().getValueByIndex(index);
			counselling.getCandidatePreferences(candidate, allCollegesQueue);
		}
		
		CollegeCounsellingProcess counsellor = new CollegeCounsellingProcess();
		counsellor.allocateSeats();
		counselling.showCounsellingResults();
	}

}
