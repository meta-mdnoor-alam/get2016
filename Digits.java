package Session1;

import javax.swing.JButton;

public class Digits extends JButton {
	String text;
	int[] id;
	
	public Digits(String text) {
		super();
		this.text = text;
	}
	
	/**
	 * returning all ids of digits
	 * @return
	 */
	public int[] getId() {
		return id;
	}
	
	/**
	 * Setting id for the digits
	 * @param id
	 */
	public void setId(int[] id) {
		this.id = id;
	}
	
	/**
	 * getting text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setting Text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}