package Session3;

/**
 * This class models the game board.
 * @author Noor
 */
public class Board {

	public static final int ROWS=3;
	public static final int COLUMNS=3;
	
	CellContent[][] cells;
	
	/**
	 * Constructor for class Board.
	 */
	public Board() {
		cells=new CellContent[ROWS][COLUMNS];
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				cells[row][column]=new CellContent(row, column);
			}
		}
	}
	
	/**
	 * Method to initialize the Board.
	 */
	public void initBoard() {
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				cells[row][column].clearContent();
			}
		}
	}
	
	/**
	 * @param row
	 * @param column
	 * @return cell content
	 */
	public CellContent getCell(int row, int column) {
		return cells[row][column];
	}
	
	/**
	 * Method to show the cell contents.
	 */
	public void show() {
		System.out.println("\n");
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				cells[row][column].show();  
				if (column<COLUMNS-1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (row<ROWS-1) {
				System.out.println("-----------");
			}
		}
	}
}
