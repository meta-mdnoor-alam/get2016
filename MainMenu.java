package Session5;

/**
 * Main menu class where the main() function is called.
 * @author Noor
 */
public class MainMenu {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Menu menu=new Menu();
		UserInteractor.getUserInput(menu,"Main Menu");
		
		Stack.initializeStack();
		Stack.pointer=0;
		Stack.menu[Stack.pointer]=menu;
		
		new Display().display(menu,1);
	}

}