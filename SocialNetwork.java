package Session4;

import java.io.IOException;
import java.util.Scanner;

/**
 * To implement a console based social-network. 
 * @author Noor
 */
public class SocialNetwork {

	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner=new Scanner(System.in);
		String connectionFileName="src\\Session4\\connections.txt";
		String nodeFileName="src\\Session4\\node.txt";
		Display display=new Display(nodeFileName, connectionFileName);
		display.operateUponChoice(display.firstMenu(scanner), scanner);
		scanner.close();
	}

}
