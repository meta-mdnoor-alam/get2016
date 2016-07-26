package Session5;

import java.util.Scanner;

/**
 * Class to take the menu details by the user and interact with the user.
 * @author Noor
 */
public class UserInteractor {
	
	static Scanner scanner=new Scanner(System.in);
	
	/**
	 * Method for getting user input.
	 * @param menu
	 * @param menuLabel
	 */
	public static void getUserInput(Menu menu,String menuLabel) {
		boolean toContinue=false;
		int totalMenuItems=0;
		String input="";

		while(!toContinue) {  //take user input for total menu items in the menu until a correct choice is not entered
			System.out.print("\nEnter the no of menu items for "+menuLabel+"  :\t");
			input=new Scanner(System.in).next();
			toContinue=UserInteractor.isInputValid(input);
			if(!toContinue) {
				System.out.println("Please enter a valid choice");
			}
		}
		
		totalMenuItems=Integer.parseInt(input);

		for(int index=0 ; index < totalMenuItems ; index++) {   //user inputs names of total menu items
			System.out.print("\n\nEnter the name for menu-item "+(index+1)+" for "+menuLabel+"  :\t");
			String menuItemLabel=scanner.next();
			MenuItem menuItem=new MenuItem();
			
			menuItem.setLabel(menuItemLabel);

			System.out.print("\nDoes "+menuItemLabel+" contains submenu ? [y/n]  :\t");
			String response=scanner.next();
			
			if(response.equalsIgnoreCase("y")) {
				menuItem.setType(Constants.TYPE_IS_MENU);
				UserInteractor.getUserInput(menuItem.menu,menuItemLabel);
			} else {
				menuItem.setType(Constants.TYPE_IS_NON_MENU);
			}
			menu.getMenuItems().add(menuItem);
		}

		//enter a menu-item Back after each menu item list
		MenuItem menuBack=new MenuItem("Back",Constants.TYPE_IS_BACK);
		menu.getMenuItems().add(menuBack);
	}
	
	/**
	 * Method to check whether input is valid or not.
	 * @param input
	 * @return is input valid or not.
	 */
	public static boolean isInputValid(String input) {
		boolean status=true;
		if(input.length()>1 || input.codePointAt(0)<"0".codePointAt(0) || input.codePointAt(0)>"9".codePointAt(0)) {
			status=false;
		}
		return status;
	}
}