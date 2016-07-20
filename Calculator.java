package Session1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
	private Digits[] digit;
	private Operator[] operator;
	private Layout layout;
	private Display display;

	/**
	 * Default Constructor
	 */
	public Calculator(){
		
	}

	/**
	 * Initialize all the objects
	 * @param digit
	 * @param operator
	 */
	public Calculator(int digit, int operator) {
		
	}
	
	/**
	 * Sending options 
	 * @return
	 */
	public Operator[] getOperator() {
		return operator;
	}
	
	/**
	 * Setting the layout
	 * @param layout
	 */
	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	/**
	 * To set Display unit
	 * @param display
	 */
	public void setDisplay(Display display) {
		this.display = display;
	}
	
	/**
	 * Get Layout
	 * @return
	 */
	public Layout getLayout() {
		return layout;
	}
	
	/**
	 * Get Different Displays
	 * @return
	 */
	public Display getDisplay() {
		return display;
	}

	/**
	 * logic for action when the buttons are clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	/**
	 * sending the reference for digits.
	 * @return
	 */
	public Digits[] getDigits() { 
		return digit;
	}
}
