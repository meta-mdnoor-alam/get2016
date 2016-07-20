package Session1;

import java.util.Scanner;

/**To implement Matrix class.
 * @author Noor
 */
public class Matrix {

	public int[][] matrix;
	private int noOfRow;
	private int noOfCol;
	
	/**
	 * Parameterized constructor of Matrix class
	 * @param matrix
	 * @param noOfRow
	 * @param noOfCol
	 */
	public Matrix(int noOfRow, int noOfCol) {
		this.matrix=new int[noOfRow][noOfCol];
		this.noOfRow=noOfRow;
		this.noOfCol=noOfCol;
	}
	
	/**
	 * @param row
	 * @param column
	 * @param value
	 * @return successfully added element or not.
	 */
	public boolean addElement(int row, int column, int value) {
		if ((row>=0 && column>=0) && (row<noOfRow && column<noOfCol)) { //validating range of row and column to add value
			matrix[row][column]=value;
			return true;
		}
		return false;
	}
	
	/**
	 * @return object of transposed matrix
	 */
	public Matrix transposeOfMatrix() {
		Matrix transpose=new Matrix(noOfCol, noOfCol);
		for (int i = 0; i < noOfCol; i++) {
			for (int j = 0; j < noOfRow; j++) {
				transpose.addElement(i, j, matrix[j][i]);
			}
		}
		return transpose;
	}
	
	/**
	 * @param row
	 * @param column
	 * @return matrix element
	 */
	public int showMatrix(int row, int column) {
		if ((row>=0 && column>=0) && (row<noOfRow && column<noOfCol)) {
			return matrix[row][column];
		} else {
			throw new ArrayIndexOutOfBoundsException();  //if row and column not in range then throw exception.
		}		
	}
	
	/**
	 * To multiply two matrix
	 * @param multiplicantMatrix
	 * @return object of the resultant multiplied Matrix class.
	 */
	public Matrix matrixMultiply(Matrix multiplicantMatrix) {
		if (matrix[0].length!=multiplicantMatrix.matrix.length) {
			return null;
		}
		
		Matrix resultantMatrix=new Matrix(noOfRow, multiplicantMatrix.noOfCol);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < multiplicantMatrix.matrix[0].length; j++) {
				resultantMatrix.matrix[i][j]=0;
				for (int k = 0; k < multiplicantMatrix.matrix.length; k++) {
					resultantMatrix.matrix[i][j]+=matrix[i][k]*multiplicantMatrix.matrix[k][j];
				}
			}
		}
		
		return resultantMatrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		int firstMatrixRows;
		int firstMatrixColumns;
		int secondMatrixRows;
		int secondMatrixColumns;
		
		System.out.println("Enter the no. of rows and columns of first matrix  :");
		firstMatrixRows=scanner.nextInt();
		firstMatrixColumns=scanner.nextInt();
		Matrix firstMatrix=new Matrix(firstMatrixRows, firstMatrixColumns);
		
		System.out.println("Enter the elements of first matrix  :");
		for (int i = 0; i < firstMatrixRows; i++) {
			for (int j = 0; j < firstMatrixColumns; j++) {
				firstMatrix.addElement(i, j, scanner.nextInt());
			}
		}
		
		System.out.println("Enter the no. of rows and columns of second matrix  :");
		secondMatrixRows=scanner.nextInt();
		secondMatrixColumns=scanner.nextInt();
		Matrix secondMatrix=new Matrix(secondMatrixRows, secondMatrixColumns);
		
		System.out.println("Enter the elements of first matrix  :");
		for (int i = 0; i < secondMatrixRows; i++) {
			for (int j = 0; j < secondMatrixColumns; j++) {
				secondMatrix.addElement(i, j, scanner.nextInt());
			}
		}
		
		Matrix multipliedMatrix=firstMatrix.matrixMultiply(secondMatrix);
		
		System.out.println("\nFirst Matrix :");
		for (int i = 0; i < firstMatrixRows; i++) {
			for (int j = 0; j < firstMatrixColumns; j++) {
				System.out.print(firstMatrix.showMatrix(i, j)+"  ");
			}
			System.out.println();
		}
		
		System.out.println("\n\nSecond Matrix :");
		for (int i = 0; i < secondMatrixRows; i++) {
			for (int j = 0; j < secondMatrixColumns; j++) {
				System.out.print(secondMatrix.showMatrix(i, j)+"  ");
			}
			System.out.println();
		}
		
		System.out.println("\n\nMultiplied Matrix :");
		for (int i = 0; i < multipliedMatrix.matrix.length; i++) {
			for (int j = 0; j < multipliedMatrix.matrix[0].length; j++) {
				System.out.print(multipliedMatrix.showMatrix(i, j)+"  ");
			}
			System.out.println();
		}
		
		Matrix transpose=multipliedMatrix.transposeOfMatrix();
		System.out.println("\n\nTranspose of Multiplied Matrix :");
		for (int i = 0; i < transpose.matrix.length; i++) {
			for (int j = 0; j < transpose.matrix[0].length; j++) {
				System.out.print(transpose.showMatrix(i, j)+"  ");
			}
			System.out.println();
		}	
		
		scanner.close();
	}
}
