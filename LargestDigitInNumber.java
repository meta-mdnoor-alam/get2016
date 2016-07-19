package Session3;

/**
 * Program to find the largest digit in a number.
 * Assumption : Number should be integer & greater than or equal to 0.
 * @author Noor
 */
public class LargestDigitInNumber {

	/**
	 * Function to find the maximum of 2 numbers.
	 * @param first number first
	 * @param second number second
	 * @return maximum of the two.
	 */
	public int findMaximun(int first, int second) {
		if (first>=second) {
			return first;
		} else {
			return second;
		}
	}
	
	/**
	 * Function to get the largest digit in a number.
	 * @param number input number
	 * @return largest digit in a number by recursively calling getLargestDigit().
	 */
	public int getLargestDigit(int number) {
		//to handle invalid input.
		if (number<0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		
		//termination condition.
		if (number==0) {
			return 0;
		}
		
		return findMaximun(number%10, getLargestDigit(number/10));
	}
}
