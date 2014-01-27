package lzq.leetcode.better.normal;

public class MaximalRectangle {
	/**
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest
	 * rectangle containing all ones and return its area.
	 * 
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == matrix || matrix.length <= 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] L = new int[cols];
		int[] R = new int[cols];
		int[] H = new int[cols];
		int max = -1;

		for (int i = 0; i < cols; i++) {
			L[i] = -1;
			R[i] = cols;
		}

		for (int i = 0; i < rows; i++) {
			int nearestLeft = -1;
			for (int j = 0; j < cols; j++) {
				L[j] = Math.max(nearestLeft, L[j]);
				if (matrix[i][j] == '1') {
					H[j]++;
				} else {
					H[j] = 0;
					L[j] = -1;
					nearestLeft = j;
				}
			}
			int nearestRight = cols;
			for (int j = cols - 1; j >= 0; j--) {
				R[j] = Math.min(nearestRight, R[j]);
				if (matrix[i][j] == '0') {
					nearestRight = j;
					R[j] = cols;
				}
				max = Math.max(max, H[j] * (R[j] - L[j] - 1));
			}
		}

		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][] { { '0', '0', '1', '0' },
				{ '1', '1', '1', '1' }, { '1', '1', '1', '1' },
				{ '1', '1', '1', '0' }, { '1', '1', '0', '0' },
				{ '1', '1', '1', '1' }, { '1', '1', '1', '0' } };
		int max = new MaximalRectangle().maximalRectangle(matrix);

		System.out.println(max);
	}

}
