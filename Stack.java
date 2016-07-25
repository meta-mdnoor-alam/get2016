package Session5;

/**
 * To implement stack class so that previous menu list can be tracked.
 * @author Noor
 */
public class Stack {
	static Menu[] menu;
	static int pointer;

	/**
	 * Construct for class Stack.
	 */
	public Stack() {
		Stack.menu=new Menu[10];
		Stack.pointer=-1;
		
		for(int index=0;index<10;index++) {
			menu[index]=new Menu();
		}
	}
	
	/**
	 * @return get the menu on calling.
	 */
	public Menu[] getMenu() {
		return menu;
	}

	/**
	 * To set menu with already menu item.
	 * @param menu
	 */
	public void setMenu(Menu[] menu) {
		Stack.menu = menu;
	}
}
