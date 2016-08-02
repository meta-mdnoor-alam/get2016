package Session2;

/**
 * Class to maintain queue for all colleges.
 * @author Noor
 */
public class AllCollegesQueue {
		// stores details of all colleges in order of their ranks
		private static MyQueue<College> allColleges;

		/**
		 * Default constructor
		 */
		public AllCollegesQueue() {
			allColleges = new MyQueue<College>();
		}

		/**
		 * Method to get all the colleges queue.
		 * @return All colleges queue.
		 */
		public static MyQueue<College> getAllColleges() {
			return allColleges;
		}

		/**
		 * Method to get the college of specified rank.
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
