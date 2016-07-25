package Session3;

import java.util.Scanner;

/**
 * To implement human player to play the game.
 * @author Noor
 */
public class HumanPlayer {

	BoardContent currentPlayer;
	Rules rules;
	Board board;
	char symbol;
	
	Scanner scanner=new Scanner(System.in);
	
	/**
	 * Consturctor for class HumanPlayer.
	 * @param board
	 * @param rules
	 */
	public HumanPlayer(Board board, Rules rules) {
		this.board=board;
		this.rules=rules;
	}
	
	/**
	 * Method to initialize the player's symbol.
	 * @return symbol choosen.
	 */
	public char initSymbol() {
		System.out.print("\n\nPlayer 1 choose your symbol [X/O] :\t");
		symbol=scanner.next().charAt(0);
		return ((symbol=='X' || symbol=='x' || symbol=='O' || symbol=='o') ? Character.toUpperCase(symbol) : initSymbol());
	}
	
	/**
	 * Method to get the symbol of the player.
	 * @param symbol
	 * @return
	 */
	public BoardContent getSymbol(char symbol) {
		return (symbol=='X' ? BoardContent.CROSS : BoardContent.ZERO);
	}
	
	/**
	 * Method to make the current player move by taking row and column as input.
	 * @param currentPlayer
	 */
	public void playerMove(BoardContent currentPlayer) {
		this.currentPlayer=currentPlayer;
		boolean validInput = false;
		do {
			if (currentPlayer == BoardContent.CROSS) {
				System.out.print("\n\nPlayer 'X', enter your move (row[1-3] column[1-3]): ");
			} else {
				System.out.print("\n\nPlayer 'O', enter your move (row[1-3] column[1-3]): ");
			}
			
			int row = scanner.nextInt()-1;
			int column = scanner.nextInt()-1;
			
			if (row >= 0 && row < Board.ROWS && column >= 0 && column < Board.COLUMNS && board.cells[row][column].content == BoardContent.EMPTY) {
				board.cells[row][column].content = currentPlayer;
				rules.currentRow = row;
				rules.currentColumn = column;
				validInput = true;
			} else {
				System.out.println("Move at (" + (row + 1) + "," + (column + 1)+ ") is not valid. Please try again...");
			}
		} while (!validInput);
	}
}
