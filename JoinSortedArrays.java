package Session1;

import java.util.Scanner;

public class JoinSortedArrays {
	
	//function to join two sorted arrays a[] & b[] into array c[].
	public int[] join(int a[], int asize, int b[], int bsize, int c[]) {
		int i=0, j=0, k=0;
		
		//loop will run till any array's pointer reaches its end. 
		while (i<asize && j<bsize) {
			if (a[i]<b[j]) { //if element of a[] is smaller
				c[k++]=a[i++];
			}else {
				c[k++]=b[j++];
			}
		}
		
		//case when b[] reaches its end and a[] is left with some elements.
		while (i<asize) {
			c[k++]=a[i++];
		}
		
		//case when a[] reaches its end and b[] is left with some elements.
		while (j<bsize) {
			c[k++]=b[j++];
		}
		
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int asize, bsize, csize, i;
		System.out.print("Enter the size of the array A :\t");
		asize=scanner.nextInt();
		int[] a=new int[asize];
		System.out.println("Enter the elements of array A :");
		//taking A array input.
		for (i = 0; i < asize; i++) {
			a[i]=scanner.nextInt();
		}
		
		System.out.print("Enter the size of the array B :\t");
		bsize=scanner.nextInt();
		int[] b=new int[bsize];
		System.out.println("Enter the elements of array B :");
		//taking B array input.
		for (i = 0; i < bsize; i++) {
			b[i]=scanner.nextInt();
		}
		
		//calculating the size of joined array.
		csize=asize+bsize;
		int[] c=new int[csize];
		//calling fuction to join sorted array a[] and sorted array b[] into array c[].
		c=new JoinSortedArrays().join(a, asize, b, bsize, c);
		
		//displaying the joined array c[].
		System.out.print("\nElements of joined array C  : {");
		for (i = 0; i < csize; i++) {
			System.out.print(c[i]+",");
		}
		System.out.print("}");
		
		scanner.close();
	}

}
