package Session5;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to implement whole menu.
 * @author Noor
 */
public class Menu {

	private List<MenuItem> menuItems;
	
	/**
	 * Constructor of class Menu.
	 */
	public Menu() {
		this.menuItems=new ArrayList<MenuItem>();
	}

	/**
	 * @return menu item list
	 */
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	/**
	 * Method to set the menu items on the list.
	 * @param menuItems
	 */
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}