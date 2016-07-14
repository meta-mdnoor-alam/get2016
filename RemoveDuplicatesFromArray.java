package Session1;

import java.util.Scanner;

public class RemoveDuplicatesFromArray {
	
	//function to check whether the element is there in the list or not.
	public boolean listSearch(String list, int element) {
		for (int i = 0; i < list.length(); i++) {
			if (Integer.parseInt(list.charAt(i)+"")==element) {
				return true;
			}
		}
		return false;
	}
	
	//function to remove duplicates value from the input array.
	public int[] removeDuplicate(int input[]) {
		String list="";
		for (int i = 0; i < input.length; i++) {
			//if the element is not in the list then adding the element to the list
			if (!listSearch(list, input[i])) {
				list=list+input[i];
			}
		}
		int[] output=new int[list.length()];
		for(int i=0;i<list.length();i++) {
			output[i]=Integer.parseInt(list.charAt(i)+"");
		}
		return output;
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
		
		//displaying the output array after removing duplicates from it.
		System.out.print("Output Array : {");
		for (int element : new RemoveDuplicatesFromArray().removeDuplicate(input)) {
			System.out.print(element+",");
		}
		System.out.println("}");
		
		scanner.close();

	}

}
