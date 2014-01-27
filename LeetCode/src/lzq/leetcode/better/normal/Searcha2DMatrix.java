package lzq.leetcode.better.normal;

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
		int start = 0;
		int end = matrix.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (matrix[mid][0] > target) {
				end = mid - 1;
			} else if (matrix[mid][0] < target) {
				start = mid + 1;
			} else {
				return true;
			}
		}
		if (matrix[start][0] == target) {
			return true;
		} else if (matrix[start][0] > target && start <= 0) {
			return false;
		}
		int row = matrix[start][0] > target ? start - 1 : start;
		start = 0;
		end = matrix[0].length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (matrix[row][mid] > target) {
				end = mid - 1;
			} else if (matrix[row][mid] < target) {
				start = mid + 1;
			} else {
				return true;
			}
		}
		if (matrix[row][start] == target) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		System.out.println(new Searcha2DMatrix().searchMatrix(m, 3));
	}

}
