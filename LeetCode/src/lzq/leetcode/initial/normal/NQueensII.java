package lzq.leetcode.initial.normal;

public class NQueensII {
	/**
	 * Follow up for N-Queens problem.
	 * 
	 * Now, instead outputting board configurations, return the total number of
	 * distinct solutions.
	 * 
	 * @param n
	 * @return
	 */
	public int totalNQueens(int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int[] cols = new int[n];
		for (int i = 0; i < n; i++) {
			cols[i] = -1;
		}
		int number = createNQueens(n, cols, 0);
		return number;

	}

	public int createNQueens(int col, int[] rows, int row) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int number = 0;
		for (int i = 0; i < col; i++) {
			int j;
			for (j = 0; j < row; j++) {
				if (rows[j] == i || (row - j == Math.abs(rows[j] - i))) {
					break;
				}
			}
			if (j < row) {
				continue;
			}
			rows[row] = i;
			if (row == col - 1) {
				rows[row] = -1;
				return 1;
			} else {
				int tmp = createNQueens(col, rows, row + 1);
				number += tmp;
			}
			rows[row] = -1;

		}
		return number;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NQueensII().totalNQueens(9));
	}

}
