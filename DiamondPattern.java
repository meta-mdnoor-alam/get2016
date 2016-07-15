package Session2;

import java.util.Scanner;

/*
 * Program to print the following Diamond pattern :
 *       1
 *      121
 *     12321
 *    1234321
 *   123454321
 *    1234321
 *     12321
 *      121
 *       1
 */

public class DiamondPattern {

	//function to get required spaces.
	public String getSpaces(int row, int size) {
		String spaces="";
		for (int i = 1; i<=Math.abs(size-row); i++) {  //iteration termination condition is based on absolute value.
			spaces+=" ";
		}
		return spaces;
	}
	
	//function to get the required numbers.
	public String getNumber(int row, int size) {
		String number="";
		int condition; //variable to decide the condition for the loop.
		
		//termination condition of the loop for left-diamond.
		if (row<=size) { //left-upper diamond
			condition=row;
		}else {          //left-lower diamond.
			condition=(2*size)-row;
		}
		
		//numbers calculated for left-diamond.
		for (int i = 1; i<=condition; i++) {
			number+=i;
		}
		
		//start condition of the loop for right-diamond.
		if (row<=size) {  //right-upper diamond.
			condition=row-1;
		}else {           //right-lower diamond.
			condition=(2*size)-row-1;
		}
		
		////numbers calculated for right-diamond.
		for (int i=condition; i>=1; i--) {
			number+=i;
		}
		
		return number;
	}
	
	//function to get Diamond pattern.
	public String[] getDiamondPattern(int size) {
		String[] pattern=new String[2*size-1]; //pattern is of 2size-1 rows.
		for (int row = 0; row < (2*size)-1; row++) {
			pattern[row]=getSpaces(row+1, size)+getNumber(row+1, size);
		}
		return pattern;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int size;
		System.out.print("Enter the size of the Diamond pattern  :\t");
		size=scanner.nextInt(); //taking the pattern size limit.
		String[] pattern=new DiamondPattern().getDiamondPattern(size);
		
		System.out.println("Pattern for size "+size+" is  :\n");
		
		//loop to print the required pattern.
		for (int row = 0; row < (2*size-1); row++) {
			System.out.println(pattern[row]);
		}
		
		scanner.close();
	
	}

}
