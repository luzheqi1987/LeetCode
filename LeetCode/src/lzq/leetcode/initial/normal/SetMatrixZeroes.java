package lzq.leetcode.initial.normal;

public class SetMatrixZeroes {
	/**
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place.
	 * 
	 * click to show follow up.
	 * 
	 * Follow up: Did you use extra space? A straight forward solution using
	 * O(mn) space is probably a bad idea. A simple improvement uses O(m + n)
	 * space, but still not the best solution. Could you devise a constant space
	 * solution?
	 * 
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int zeroH = -1;
		int rows = matrix.length;
		int cols = matrix[0].length;
		if (0 == matrix[0][0]) {
			zeroH = 0;
		}
		for (int i = 1; i < rows; i++) {
			if (0 == matrix[i][0]) {
				matrix[0][0] = 0;
				break;
			}
		}
		for (int i = 1; i < cols; i++) {
			if (0 == matrix[0][i]) {
				zeroH = 0;
				break;
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (0 == matrix[i][j]) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < rows; i++) {
			if (0 == matrix[i][0]) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < cols; i++) {
			if (0 == matrix[0][i]) {
				for (int j = 0; j < rows; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		if (0 == zeroH) {
			for (int j = 0; j < cols; j++) {
				matrix[0][j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 0 }, { 1 } };
		new SetMatrixZeroes().setZeroes(matrix);
	}

}
