package Session3;

/**
 * This class initializes each cell content with empty and displays the content in the board.  
 * @author Noor
 */
public class CellContent {

	BoardContent content;
	int row, column;
	
	/**
	 * Constructor for CellContent class.
	 * @param row
	 * @param column
	 */
	public CellContent(int row, int column) {
		this.row=row;
		this.column=column;
		clearContent();
	}
	
	/**
	 * To clear the content
	 */
	public void clearContent() {
		content=BoardContent.EMPTY;
	}
	
	/**
	 * method to display the value in the board.
	 */
	public void show() {
		switch (content) {
		case CROSS:
			System.out.print(" X ");
			break;
		case ZERO:
			System.out.print(" O ");
			break;
		case EMPTY:
			System.out.print("   ");
			break;
		}
	}
}
