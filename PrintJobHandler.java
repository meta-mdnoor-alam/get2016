package Session4;

import java.util.Scanner;

/**
 * Method to handle print-jobs based on the department priority.
 * @author Noor
 */
public class PrintJobHandler {
	
	Scanner scanner;
	Heap heap;
	
	public PrintJobHandler() {
		heap=new Heap();
	}
	
	/**
	 * Method to return user input of integer type.
	 * @param task
	 * @return user input (integer)
	 */
	private int getUserIntegerInput(String task){
		scanner = new Scanner(System.in);
		int userInput = 0;
		try {
			System.out.println("\n"+task+"  :\t");
			userInput = Integer.parseInt(scanner.next());
		} catch(Exception ex) {
			System.out.println("Something went wrong: "+ex.getMessage());
			getUserIntegerInput(task);
		}
		return userInput;
	}
	
	/**
	 * Method to perform operations based upon user choice.
	 * @param choice
	 */
	private void performMenuOperation(int choice) {
		switch (choice) {
			case 1:
				int priority = getUserIntegerInput("\n4. Admin\n3. Professor\n2. Graduate\n1. UnderGraduate\nEnter the priority");
				heap.insert(priority);
				break;
			case 2:
				int served = heap.delete();
				if (served != -111111) {
					System.out.println(served + " is served");
				} else {
					System.out.println("Can't serve");
				}
				break;
			case 3:
				System.out.print("------------Printing queue----------> ");
				heap.display();
				System.out.println();
				break;
			case 4:
				System.exit(-1);
			default:
				System.out.println("Enter a valid choice");
				break;
		}
	}
	
	/**
	 * Program main function.
	 * @param args
	 */
	public static void main(String[] args) {
		PrintJobHandler printJob=new PrintJobHandler();
		int choice;
		try {
			do {
				choice = printJob.getUserIntegerInput("1. Add a job into queue\n2. Serve \n3. Display the queue\n4. Exit\n\nEnter your choice");
				printJob.performMenuOperation(choice);
			} while(choice!=4);
		} catch (Exception exception) {
			System.out.println("Something went wrong : "+ exception.getMessage());
		}
	}
}
