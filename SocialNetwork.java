package Session4;

import java.io.IOException;
import java.util.Scanner;

/**
 * To implement a console based social-network. 
 * @author Noor
 */
public class SocialNetwork {
	
	private final static String connectionFileName="src\\Session4\\connections.txt";
	private final static String nodeFileName="src\\Session4\\node.txt";
	
	/**
	 * Program main function
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner=new Scanner(System.in);
		Display display=new Display(nodeFileName, connectionFileName);
		display.operateUponChoice(display.displayFirstMenu(scanner), scanner);
		scanner.close();
	}

}
