package Session4;

/**To find the solution of N-Queen problem such that no two queens should attack each other.
 * @author Noor
 *
 */
public class NQueensProblem {

	int[][] matrixBoard;
	
	/**
	 * Function to tell whether the queen can be placed at a certain position or not.
	 * @param rowNumber Checking queen position on row rowNumber
	 * @param colNumber Checking queen position on column colNumber
	 * @return whether we can place the queen on the desired rowNumber and colNumber or not
	 */
	public boolean canPlaceQueen(int[][] matrixBoard, int rowNumber, int colNumber) {
		int i, j;
		
		this.matrixBoard=matrixBoard;
		
		//to handle same row from left side
		for (i = 0; i < colNumber; i++) {
			if (matrixBoard[rowNumber][i]==1) {
				return false;
			}
		}
		
		//to handle upper left diagonal
		for (i=rowNumber-1, j=colNumber-1; i>=0 && j>=0; i--, j--) {
			if (matrixBoard[i][j]==1) {
				return false;
			}
		}
		
		//to handle same column from above
		for (i=rowNumber-1; i>=0; i--) {
			if (matrixBoard[i][colNumber]==1) {
				return false;
			}
		}
		
		//to handle upper right diagonal
		for (i=rowNumber-1, j=colNumber+1; i>=0 && j<matrixBoard.length; i--, j++) {
			if (matrixBoard[i][j]==1) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * To solve N-Queen problem by calling this function recursively
	 * @param startRow starting row to start placing the queen 
	 * @param dimensionOfMatrix dimension of the matrix to be solved for N-Queen
	 * @return whether is is possible to find solution for the given N-Queen or not
	 */
	public boolean nQueen(int[][] matrixBoard, int startRow, int dimensionOfMatrix) {
		this.matrixBoard=matrixBoard;
		
		//if all the queens are placed in matrixBoard
		if (startRow>=matrixBoard.length) {
			return true;
		}
		
		for (int i = 0; i < matrixBoard.length; i++) {
			if (canPlaceQueen(this.matrixBoard, startRow, i)) {
				this.matrixBoard[startRow][i]=1;
				
				if (nQueen(this.matrixBoard, startRow+1, dimensionOfMatrix)) {
					return true;
				}
				
				this.matrixBoard[startRow][i]=0; //backtracking, if result the queen can not be placed the desired position which was assumed
			}
		}
		
		return false;
	}
	
	/**
	 * To display the matrix board of N-Queen
	 * @param matrixBoard Matrix Board array
	 * @return matrix board
	 */
	public int[][] showSolutionNQueen(int[][] matrixBoard, int startRow, int dimensionOfMatrix) {
		this.matrixBoard=matrixBoard;
		nQueen(this.matrixBoard, startRow, dimensionOfMatrix);
		
		return this.matrixBoard;
	}
}