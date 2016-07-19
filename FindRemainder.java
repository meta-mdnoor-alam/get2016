package Session3;

/** Program to find the remainder of x divided by y.
 *  Assumption : integer x should be greater than or equal to 0 and
 *               integer y should be greater than 0. 
 *  @author Noor
 */
public class FindRemainder {

	/**
	 * Function to get the remainder when integer x is divided by integer y
	 * @param x dividend
	 * @param y divisor
	 * @return remainder by calling function getRemainder recursively.
	 */
	public int getRemainder(int x, int y) {
		//if the user inputs invalid input.
		if (x<0 || y<=0) {
			throw new IllegalArgumentException("Invalid input");
		}
		if (x<y) { //termination condition for recursive function.
			return x;
		}
		return getRemainder(x-y, y);
	}
}
