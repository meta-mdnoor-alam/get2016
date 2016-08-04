package Session5.QueueImplementor;

import java.util.Scanner;

/**
 * Program to implement queue.
 * 
 * @author Noor
 */
public class QueueImplementerApplication {

	private Scanner scanner;
	private MyQueue queue;
	
	public QueueImplementerApplication() {
		queue = new MyQueue();
	}
	
	/**
	 * Program main method
	 * @param args
	 */
	public static void main(String[] args) {
		new QueueImplementerApplication().showMenu();
	}
	
	private void showMenu() {
		scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("\n\n\n<----Please choose---->");
				System.out.println("1. Enqueue");
				System.out.println("2. Dequeue");
				System.out.println("3. Display");
				System.out.println("4. Exit\n");
				int choice = scanner.nextInt();
				MenuChoice option = MenuChoice.values()[choice];
				switch (option) {
				case ENQUEUE:
					System.out.print("\n\nEnter the element to be inserted  :\t");
					int data = scanner.nextInt();
					queue.enqueue(data);
					break;
				case DEQUEUE:
					int deletedValue = queue.dequeue();
					if (deletedValue == -111111) {
						System.out.println("Queue is Empty. Can't perform deletion.");
					} else {
						System.out.println(deletedValue + " removed ");
					}
					break;
				case DISPLAY:
					queue.displayQueue();
					break;
				case EXIT:
					System.exit(-1);
				default:
					System.out.println("Please enter a valid response...");
					break;
				}
			}
		} catch (Exception exception) {
			System.out.println("Something went wrong : " + exception.getMessage());
			showMenu();
		} finally {
			scanner.close();
		}
	}
}