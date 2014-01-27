package lzq.leetcode.initial.normal;

public class RotateImage {
	/**
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Follow up: Could you do this in-place?
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == matrix || matrix.length <= 0) {
			return;
		}
		int roll = (matrix.length - 1) / 2;
		for (int i = 0; i <= roll; i++) {
			for (int k = i; k < matrix.length - i - 1; k++) {
				int tmp = matrix[i][k];
				matrix[i][k] = matrix[matrix.length - k - 1][i];
				matrix[matrix.length - k - 1][i] = matrix[matrix.length - i - 1][matrix.length
						- k - 1];
				matrix[matrix.length - i - 1][matrix.length - k - 1] = matrix[k][matrix.length
						- i - 1];
				matrix[k][matrix.length - i - 1] = tmp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		new RotateImage().rotate(matrix);
	}

}
