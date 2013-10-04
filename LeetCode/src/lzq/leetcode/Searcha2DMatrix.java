package lzq.leetcode;

public class Searcha2DMatrix {
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
