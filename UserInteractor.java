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
		
		System.out.print("\nEnter the no. of menu items for "+menuLabel+"  :\t");
		int totalMenuItems=scanner.nextInt();
		
		for(int index=0; index < totalMenuItems; index++)
		{
			System.out.print("\nEnter the name for menu item "+(index+1)+" for "+menuLabel+"  :\t");
			String menuItemLabel=scanner.next();
			MenuItem menuItem=new MenuItem();
			menuItem.setLabel(menuItemLabel);
			System.out.print("\nDoes "+menuItemLabel+" contains submenu ? [y/n]  :\t");
			String choice=scanner.next();
			if(choice.equalsIgnoreCase("y")) {
				menuItem.setType(Constants.TYPE_IS_MENU);
				UserInteractor.getUserInput(menuItem.menu,menuItemLabel);
			} else {
				menuItem.setType(0);
			}
			menu.getMenuItems().add(menuItem);
		}
		
		MenuItem menuBack=new MenuItem();
		
		menuBack.setLabel("Back");
		menuBack.setType(Constants.TYPE_IS_BACK);
		menu.getMenuItems().add(menuBack);
	}
}