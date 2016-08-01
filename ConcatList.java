package Session1;

import java.util.Scanner;

/**
 * @author Noor
 *
 */
public class ConcatList<N> {
	
	private MyArrayList<N> list;
	
	public ConcatList(MyArrayList<N> list) {
		this.list=list;
	}
	
	public void concatList(MyArrayList<N> secondList) {
		list.addAll(secondList);
	}
	
	public void display() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyArrayList<String> firstList= new MyArrayList<String>();
		MyArrayList<String> secondList=new MyArrayList<String>();
		
		int sizeFirst;		//Size of first list
		int sizeSecond;		//Size of second list
		
		System.out.print("Enter size of first list  :\t");
		sizeFirst=scanner.nextInt();
		System.out.println("Enter the elements  :");
		//Input elements for first list
		for(int i=0; i < sizeFirst; i++) {
			firstList.add(scanner.next());
		}
		
		System.out.print("\n\nEnter size of second list  :\n");
		sizeSecond = scanner.nextInt();
		System.out.println("Enter the elements  :");
		//Input elements for second list
		for(int i=0; i < sizeSecond; i++) {
			secondList.add(scanner.next());
		}
		
		ConcatList<String> object=new ConcatList<String>(firstList);
		object.concatList(secondList);
		System.out.println("\n\nConcatinated list  :");
		object.display();
		scanner.close();
	}
}
