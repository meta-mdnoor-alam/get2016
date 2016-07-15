package Session2;

import java.util.Scanner;

/*
 * Program to print the following Pyramid pattern :
 *   12345
 *    1234
 *     123
 *      12
 *       1
 */

public class PyramidPattern {

	//function to get the spaces for a row.
	public String getSpaces(int row) {
		String spaces="";
		for (int i = 1; i < row; i++) {
			spaces+=" ";
		}
		return spaces;
	}
	
	//function to get the number for a row
	public String getNumber(int row, int size) {
		String number="";
		int count=1;
		for (int i = 1; i <= (size-row+1); i++) {
			number+=count++ + "";
		}
		return number;
	}
	
	//function to get the required pyramid pattern.
	public String[] getPyramidPattern(int size) {
		String[] pattern=new String[size];
		for (int row = 0; row < size; row++) {
			pattern[row]=getSpaces(row+1)+getNumber(row+1, size);
		}
		return pattern;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int size;
		System.out.print("Enter the size of the Pyramid pattern  :\t");
		size=scanner.nextInt(); //taking the pattern size limit.
		String[] pattern=new PyramidPattern().getPyramidPattern(size);
		
		System.out.println("Pattern for size "+size+" is  :\n");
		
		//loop to print the required pattern.
		for (int row = 0; row < size; row++) {
			System.out.println(pattern[row]);
		}
		
		scanner.close();
	
	}

}
