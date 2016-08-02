package Session2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to perform the counseling task for the candidates.
 * @author Noor
 */
public class Counseling {

	/**
	 * Displays the list of available colleges
	 * @param allCollegesQueue
	 */
	public void displayAllColleges(AllCollegesQueue allCollegesQueue) {
		int size=AllCollegesQueue.getAllColleges().size();
		System.out.println("\nS.No.\tName\tRank\tSeats");
		for(int index=0;index<size;index++) {
			College college=(College)AllCollegesQueue.getAllColleges().getValueByIndex(index);
			System.out.println((index+1)+".\t"+college.getCollegeName()+"\t"+college.getCollegeRank()+"\t"+college.getSeatsAvailable());
		}
	}
	
	/**
	 * Method to get colleges based upon rank.
	 * @param rank Rank whose college is to be searched.
	 * @param allCollegesQueue
	 * @return
	 */
	public College getCollegeByRank(int rank, AllCollegesQueue allCollegesQueue) {
		College college=null;
		int totalColleges=AllCollegesQueue.getAllColleges().size();
		for(int index=0;index<totalColleges;index++) {
			if(AllCollegesQueue.getAllColleges().getValueByIndex(index).getCollegeRank()==rank) {
				college=AllCollegesQueue.getAllColleges().getValueByIndex(index);
				break;
			}
		}
		return college;
	}
	
	/**
	 * Method to take the candidates preferences.
	 * @param candidate Candidate for whom the preferences are to be filled
	 * @param allCollegesQueue Queue that stores the details of all the colleges
	 */
	public void getCandidatePreferences(Candidate candidate,AllCollegesQueue allCollegesQueue)
	{
		int totalColleges=AllCollegesQueue.getAllColleges().size();
		Scanner scanner=new Scanner(System.in);
		try{
			displayAllColleges(allCollegesQueue);
			System.out.println("\n\n------PLEASE CHOOSE YOUR PREFERENCES------");
			System.out.println("Name  :\t"+candidate.getCandidateName());
			List<Integer> tempPreferencesList=new ArrayList<Integer>();
			tempPreferencesList.clear();
			for(int index=0;index<totalColleges;index++) {
				boolean toContinue=true;
				int preference=0;
				while(toContinue) {
					System.out.print("Enter your "+(index+1)+" choice  :\t");
					preference=scanner.nextInt();
					if(tempPreferencesList.contains(preference)) {
						System.out.println("You have already opted for this college");
					}
					else {
						tempPreferencesList.add(preference);
						toContinue=false;
					}
				}
				candidate.getCandidateQueueForCollege().enqueue(getCollegeByRank(preference, allCollegesQueue));
			}
		} catch(Exception exception) {
			System.out.println("Something went wrong : "+exception.getMessage());
		} finally {
			if(scanner!=null) {
				scanner.close();
			}
		}
	}

	/**
	 * Displays the counseling result.
	 */
	public void showCounsellingResults() {
		int totalCandidates=AllCandidatesQueue.getAllCandidates().size();
		System.out.println("S.No.\t\tName\t\tAlloted College");
		for(int index=0;index<totalCandidates;index++) {
			Candidate candidate=AllCandidatesQueue.getAllCandidates().getValueByIndex(index);
			College college=candidate.getCollegeAlloted();
			String collegeName="No College Alloted";
			if(college!=null) {
				collegeName=college.getCollegeName();
			}
			System.out.println((index+1)+".\t\t"+candidate.getCandidateName()+"\t\t"+collegeName);
		}
	}

}
