package Session1;

import java.util.Scanner;

public class ArraySortedCheck {
	
	//function to check whether the array is in ascending order.
	public boolean checkArrayAscending(int[] input) {
		int flag=1;
		for (int i = 0; i < (input.length)-1; i++) {
			if (input[i]>input[i+1]) { //if previous is greater than next element.
				flag=0;
				break;
			}
		}
		if (flag==1) {
			return true;
		}
		return false;
	}
	
	
	//function to check whether the array is in descending order.
	public boolean checkArrayDescending(int[] input) {
		int flag=1;
		for (int i = 0; i < (input.length)-1; i++) { //if previous is less than next element.
			if (input[i]<input[i+1]) {
				flag=0;
				break;
			}
		}
		if (flag==1) {
			return true;
		}
		return false;
	}
	
	//function to check the nature of the array.
	public int checkArray(int[] input) {
		if (checkArrayAscending(input)) {
			return 1;
		}else if (checkArrayDescending(input)) {
			return 2;
		}else { //if array is not ascending and not descending then it is surely unsorted.
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int size;
		System.out.print("Enter the size of the input array  :\t");
		size=scanner.nextInt();
		int[] input=new int[size];
		System.out.println("Enter the elements  :");
		//taking array input.
		for (int i = 0; i < size; i++) {
			input[i]=scanner.nextInt();
		}
		
		//based on the return value of checkArray() deciding the nature of the array.
		if (new ArraySortedCheck().checkArray(input)==1) {
			System.out.println("Array is sorted in Ascending Order...");
		}else if (new ArraySortedCheck().checkArray(input)==2) {
			System.out.println("Array is sorted in Descending Order...");
		}else if (new ArraySortedCheck().checkArray(input)==0) {
			System.out.println("Array is Unsorted...");
		}
		
		scanner.close();

	}

}
