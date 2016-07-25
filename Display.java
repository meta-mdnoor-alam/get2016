package Session5;

import java.util.List;
import java.util.Scanner;

/**
 * Class to display the menu content of the menu list.
 * @author Noor
 */
public class Display {
	
	Scanner scanner=new Scanner(System.in);
	
	/**
	 * Method to display a menu item list given by the user.
	 * @param menuItemList
	 */
	public void diplayMenu(List<MenuItem> menuItemList) {
		if(menuItemList==null || menuItemList.size()==0) {
			System.out.println("The list is empty");
			return ;
		} else {
			System.out.println("Choose :");
			for(MenuItem menuItem : menuItemList) {
				System.out.println("\t"+menuItem.getLabel());
			}
		}
	}
	
	/**
	 * Method to display menu based on the level of the label.
	 * @param menu
	 * @param level
	 */
	public void display(Menu menu,int level) {

		List<MenuItem> menuItemList=menu.getMenuItems();
		int totalMenuItems=menuItemList.size();

		for(int index=0; index < totalMenuItems ;index++) {
			System.out.println((index+1+" ")+menuItemList.get(index).getLabel());
		}

		int userInput=scanner.nextInt();

		if(menuItemList.get(userInput-1).getType()==Constants.TYPE_IS_MENU) {
			Stack.pointer+=1;
			Stack.menu[Stack.pointer]=menu;
			display(menuItemList.get(userInput-1).menu,level+1);
		} else if(menuItemList.get(userInput-1).getType()==Constants.TYPE_IS_BACK && level==1) {
			System.exit(-1);
		} else if(menuItemList.get(userInput-1).getType()==Constants.TYPE_IS_BACK && level!=1) {
			Stack.pointer-=1;
			display(Stack.menu[Stack.pointer+1], level-1);
		}
	}
}