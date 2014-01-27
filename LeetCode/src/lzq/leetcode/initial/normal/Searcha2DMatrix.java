package lzq.leetcode.initial.normal;

public class Searcha2DMatrix {
	/**
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3,
	 * return true.
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (null == matrix || matrix.length <= 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int all = rows * cols;
		boolean finded = false;
		int i;
		for (i = 0; i < all - 1; i++) {
			if (matrix[i / cols][i % cols] > matrix[(i + 1) / cols][(i + 1)
					% cols]) {
				break;
			}
			if (matrix[i / cols][i % cols] == target) {
				finded = true;
			}
		}
		if (i < all - 1) {
			return false;
		} else if (matrix[rows - 1][cols - 1] == target) {
			finded = true;
		}
		return finded;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
