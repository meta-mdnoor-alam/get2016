package Session3;

import java.util.Scanner;

/**
 * To implement console based Tic-Tac-Toe game with object-oriented approach.
 * @author Noor
 */
public class TicTacToe {

	private Board board;
	private Rules rules;
	private GameState currentState;
	private BoardContent currentPlayer;
	private HumanPlayer[] humanPlayer;
	private ComputerPlayer autoPlayer;
	private int noOfhumanPlayer;
	private int isComputerPlaying=0;
	
	private static Scanner scanner=new Scanner(System.in);
	
	/**
	 * Constructor for class TicTacToe.
	 */
	public TicTacToe() {
		humanPlayer=null;
		autoPlayer=null;
	}
	
	/**
	 * Method to start playing the game on console.
	 */
	public void playGame() {

		board=new Board();
		rules=new Rules(board);

		initGame();  //initialize the game.
		
		int playerTurn=0;
		int computerTurn=0;
		
		do {
			board.show();
			if (isComputerPlaying==1 && computerTurn==1) {  //computer playing and its computer's turn
				autoPlayer.autoMove(currentPlayer);
			} else {
				humanPlayer[playerTurn].playerMove(currentPlayer);
			}
			updateGame(currentPlayer);
			if (currentState == GameState.CROSS_WON) {
				board.show();
				System.out.println("\n\nPlayer 'X' is the winner...");
			} else if (currentState == GameState.ZERO_WON) {
				board.show();
				System.out.println("\n\nPlayer 'O' is the winner...");
			} else if (currentState == GameState.DRAW) {
				board.show();
				System.out.println("\n\nGame is draw...");
			}
			currentPlayer = (currentPlayer == BoardContent.CROSS) ? BoardContent.ZERO : BoardContent.CROSS;
			if (isComputerPlaying==1) {  //computer is playing
				computerTurn=(computerTurn==0 ? 1 : 0);
			} else {
				playerTurn=(playerTurn==0 ? 1 : 0);
			}
		} while (currentState == GameState.PLAYING);
	}
	
	/**
	 * Method to initialize the game.
	 */
	public void initGame() {
		board.initBoard();
		noOfhumanPlayer=getGamePlayerChoice();
		
		if (noOfhumanPlayer==2) {
			humanPlayer=new HumanPlayer[2];
			humanPlayer[0]=new HumanPlayer(board, rules);
			humanPlayer[1]=new HumanPlayer(board, rules);
		} else {
			humanPlayer=new HumanPlayer[1];
			humanPlayer[0]=new HumanPlayer(board, rules);
			autoPlayer=new ComputerPlayer(board, rules);
			isComputerPlaying=1;
		}
		
		currentPlayer=humanPlayer[0].getSymbol(humanPlayer[0].initSymbol());
		currentState = GameState.PLAYING;
	}
	
	/**
	 * Method to get the player choice to play with.
	 * @return
	 */
	public int getGamePlayerChoice() {
		int choice;
		System.out.print("\n\n1. Player vs Computer\n");
		System.out.print("2. Player vs Player\n");
		System.out.print("Enter your choice [1-2]  :\t");
		choice=scanner.nextInt();
		if (choice<1 || choice>2) {
			return getGamePlayerChoice();
		}
		return choice;
	}

	/**
	 * Method to update the game based on the current player.
	 * @param currentPlayer
	 */
	public void updateGame(BoardContent currentPlayer) {
		if (rules.hasWon(currentPlayer)) {
			currentState = (currentPlayer == BoardContent.CROSS) ? GameState.CROSS_WON : GameState.ZERO_WON;
		} else if (rules.isDraw()) {
			currentState = GameState.DRAW;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char choice;
		
		do {
			new TicTacToe().playGame();
			System.out.print("\n\n\nDo you want to play once again [y/n]  :\t");
			choice=scanner.next().charAt(0);
		} while ((choice=='y' || choice=='Y') && (choice!='n' || choice!='N'));
	}
}
