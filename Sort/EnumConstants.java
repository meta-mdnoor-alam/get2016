package Session8.Sort;

/**
 * Class to define enum constants for Sorting.
 * @author Noor
 */
public class EnumConstants {
	/**
	 * Enum for choosing sorting type.
	 * @author Noor
	 */
	public enum SortingType {
		COMPARISON_SORT(1), LINEAR_SORT(2);
		
		private int sortingType;
		
		private SortingType(int sortingType) {
			this.sortingType = sortingType;
		}
		
		public int getSortingType() {
			return sortingType;
		}
	}
	
	/**
	 * Enum for sorting methodology.
	 */
	public enum SortingMethodology {
		QUICK_SORT(1), BUBBLE_SORT(2), RADIX_SORT(3), COUNTING_SORT(4);

		private int sortingMethodology;

		private SortingMethodology(int sortingMethodology) {
			this.sortingMethodology = sortingMethodology;
		}

		public int getSortingMethodology() {
			return sortingMethodology;
		}
	}
}
