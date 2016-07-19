package Session3;

/** Program to find the greatest common divisor of x and y.
 *  Assumptions : integer x and y should be greater than 0 &
 *                x should be greater than y.
 *  @author Noor              
 */
public class GreatestCommonDivisor {

	/**
	 * function to find the GCD of integer x and y where x>y.
	 * @param x first integer
	 * @param y second integer
	 * @return gcd by calling findGCD() recursively.
	 */
	public int findGCD(int x, int y) {
		//to handle invalid input by the user.
		if (x<0 || y<0) {
			throw new IllegalArgumentException("Invalid Input");
		} else if (x<y) {
			return findGCD(y, x);
		}
		
		//termination condition for recursion.
		if (y==0) {
			return x;
		} else {
			return findGCD(y, x%y);
		}
	}
}
