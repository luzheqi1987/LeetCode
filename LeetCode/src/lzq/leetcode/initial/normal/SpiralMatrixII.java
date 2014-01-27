package lzq.leetcode.initial.normal;

public class SpiralMatrixII {
	/**
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7,
	 * 6, 5 ] ] Discuss
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int[][] matrix = new int[n][n];
		int number = 1;
		int halfCol = (n - 1) / 2;
		int halfRow = (n - 1) / 2;
		int col = 0;
		int row = 0;
		while (row <= halfRow && col <= halfCol) {
			for (int i = col; i < n - col; i++) {
				matrix[row][i] = number++;
			}
			for (int i = row + 1; i < n - row; i++) {
				matrix[i][n - col - 1] = number++;
			}
			if (row != n - row - 1) {
				for (int i = n - col - 2; i >= col; i--) {
					matrix[n - row - 1][i] = number++;
				}
			}

			if (col != n - col - 1) {
				for (int i = n - row - 2; i >= row + 1; i--) {
					matrix[i][col] = number++;
				}
			}
			row++;
			col++;
		}
		return matrix;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
