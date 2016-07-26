package Session5;

/**
 * Class for getting the items of the menu list.
 * @author Noor
 */
public class MenuItem {

	private String label;
	private int type;
	Menu menu;
	
	/**
	 * Parameterized constructor of class MenuItem.
	 * @param label
	 * @param type
	 */
	public MenuItem(String label, int type) {
		this.label = label;
		this.type = type;
		this.menu=new Menu();
	}
	
	/**
	 * Default constructor of class MenuItem.
	 */
	public MenuItem() {
		this.menu=new Menu();
	}
	
	/**
	 * Method for getting label of the menu.
	 * @return label.
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Method to set the label name with the user given name.
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Method to get the type of the menu.
	 * @return type
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Method to set the type of the menu.
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}
}