package Session1;

import java.util.Scanner;

public class LongestIncreasingSequence {
	
	//function to calculate longest increasing sequence.
	public int[] getLongestSequence(int[] input) {
		int count=1, lastIndex=0, startIndex=0, longestSequenceLength=0, j=0;
		//loop to compare adjacent elements.
		for(int i=0; i<input.length-1; i++) {
			if(input[i]<input[i+1]) { //if in increasing format, counter increasing.
				count++;
			}else {
				if(longestSequenceLength<count) {
					longestSequenceLength=count;
					lastIndex=i;
					startIndex=i-count+1;
				}
				count=1;
			}
		}
		
		if (longestSequenceLength<count) { //case if the IF condition is true at the last iteration 
			longestSequenceLength=count;
			lastIndex=input.length-1;
			startIndex=lastIndex-count+1;
		}
		
		int[] output=new int[lastIndex-startIndex+1]; //storing the longest sequence in an output array.
		for (int i = startIndex; i <= lastIndex; i++) {
			output[j++]=input[i];
		}
		
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		int size;
		System.out.print("Enter the size of the array  :\t");
		size=scanner.nextInt();
		int[] input=new int[size];
		System.out.println("Enter the elements of the array  :");
		//taking array input.
		for (int i = 0; i < size; i++) {
			input[i]=scanner.nextInt();
		}
		
		int[] output=new LongestIncreasingSequence().getLongestSequence(input);
		//printing longest subsequence.
		System.out.print("\nElements of longest subsequence array  : {");
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]+",");
		}
		System.out.print("}");
		
		scanner.close();
		
	}

}
