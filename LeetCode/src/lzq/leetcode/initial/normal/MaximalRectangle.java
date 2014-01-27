package lzq.leetcode.initial.normal;

import java.util.Stack;

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
		int[][] vmax = new int[rows][cols];
		if (matrix[0][0] == '1') {
			vmax[0][0] = 1;
		}
		int maximum = Integer.MIN_VALUE;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0) {
					if (matrix[i][j] == '1') {
						vmax[i][j] = 1;
					}
				} else {
					if (matrix[i][j] == '1') {
						vmax[i][j] = 1 + vmax[i - 1][j];
					} else {
						vmax[i][j] = 0;
					}
				}
			}
		}
		for (int i = rows - 1; i >= 0; i--) {
			int tmp = largestRectangleArea(vmax[i]);
			if (tmp > maximum) {
				maximum = tmp;
			}
		}
		return maximum;
	}

	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == height || height.length <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		Stack<Integer> indexHeight = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (index.isEmpty() || height[i] > indexHeight.peek()) {
				indexHeight.push(height[i]);
				index.push(i);
			} else if (height[i] < indexHeight.peek()) {
				int indexTmp = 0;
				while (!index.isEmpty() && height[i] < indexHeight.peek()) {
					indexTmp = index.pop();
					int indexHeightTmp = indexHeight.pop();
					int tmp = (i - indexTmp) * indexHeightTmp;
					if (max < tmp) {
						max = tmp;
					}
				}
				if (index.isEmpty() || height[i] > indexHeight.peek()) {
					indexHeight.push(height[i]);
					index.push(indexTmp);
				}
			}
		}
		while (!indexHeight.isEmpty()) {
			int tmp = indexHeight.pop() * (height.length - index.pop());
			if (tmp > max) {
				max = tmp;
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
