package Session3;

/**
 * To define the rules for game draw and winning.
 * @author Noor
 */
public class Rules {

	Board board;
	int currentRow, currentColumn;
	
	/**
	 * Constructor of class Rules.
	 * @param board
	 */
	public Rules(Board board) {
		this.board=board;
	}
	
	/**
	 * Method to check whether the game is draw or not.
	 * @return game draw or not.
	 */
	public boolean isDraw() {
		for (int row = 0; row < Board.ROWS; row++) {
			for (int column = 0; column < Board.COLUMNS; column++) {
				if (board.getCell(row, column).content == BoardContent.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Method to check whether the current player won the game or not.
	 * @param currentPlayer
	 * @return whether the current player has won or not.
	 */
	public boolean hasWon(BoardContent currentPlayer) {
		boolean rowWinningCondition= (board.getCell(currentRow, 0).content==currentPlayer && board.getCell(currentRow, 1).content==currentPlayer 
																							  && board.getCell(currentRow, 2).content==currentPlayer);
		boolean columnWinningCondition= (board.getCell(0, currentColumn).content==currentPlayer && board.getCell(1, currentColumn).content==currentPlayer 
																							  && board.getCell(2, currentColumn).content==currentPlayer);
		boolean leftDiagonalWinningCondition= (board.getCell(0, 0).content==currentPlayer && board.getCell(1, 1).content==currentPlayer 
			                                                                            	  && board.getCell(2, 2).content==currentPlayer);
		boolean rightDiagonalWinningCondition= (board.getCell(0, 2).content==currentPlayer && board.getCell(1, 1).content==currentPlayer 
				  && board.getCell(2, 0).content==currentPlayer);
		
		if (rowWinningCondition || columnWinningCondition || leftDiagonalWinningCondition || rightDiagonalWinningCondition) {
			return true;
		} else {
			return false;
		}
	}
}
