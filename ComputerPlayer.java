package Session3;

import java.util.Random;

/**
 * To implement computer playing by automating its move over the board.
 * @author Noor
 */
public class ComputerPlayer {

	BoardContent currentPlayer;
	Rules rules;
	Board board;
	char symbol;
	
	/**
	 * Constructor for class {@link ComputerPlayer#}
	 * @param board
	 * @param rules
	 */
	public ComputerPlayer(Board board, Rules rules) {
		this.board=board;
		this.rules=rules;
	}
	
	/**
	 * Method to make current player move by generating random row and column.
	 * @param currentPlayer
	 */
	public void autoMove(BoardContent currentPlayer) {
		this.currentPlayer=currentPlayer;
		boolean validInput = false;
		do {
			int row = new Random().nextInt(3);
			int column = new Random().nextInt(3);
			if (board.cells[row][column].content == BoardContent.EMPTY) {
				board.cells[row][column].content = currentPlayer;
				rules.currentRow = row;
				rules.currentColumn = column;
				validInput = true;
			}
		} while (!validInput);
	}
}
