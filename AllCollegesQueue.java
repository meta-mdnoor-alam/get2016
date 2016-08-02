package Session2;

/**
 * Class to maintain queue for all colleges.
 * @author Noor
 */
public class AllCollegesQueue {
		// stores details of all colleges in order of their ranks
		private static MyQueue<College> allColleges;

		public AllCollegesQueue() {
			allColleges = new MyQueue<College>();
		}

		public static MyQueue<College> getAllColleges() {
			return allColleges;
		}

		/**
		 * Method to get all colleges by rank.
		 * @param rank
		 * @return
		 */
		public static College getCollegeByRank(int rank) {
			int totalColleges=allColleges.size();
			for(int index=0;index<totalColleges;index++) {
				if(allColleges.getValueByIndex(index).getCollegeRank()==rank) {
					return allColleges.getValueByIndex(index);
				}
			}
			return null;
		}
}
