package lzq.leetcode.better.knack;

public class NQueensII {
	/**
	 * Follow up for N-Queens problem.
	 * 
	 * Now, instead outputting board configurations, return the total number of
	 * distinct solutions.
	 * 
	 * http://www.matrix67.com/blog/archives/266
	 * 
	 * @param n
	 * @return
	 */
	public int totalNQueens(int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int max = (1 << n) - 1;
		int number = queue(0, 0, 0, max);
		return number;

	}

	int queue(int row, int ld, int rd, int max) {
		int all, p, number = 0;
		if (row != max) {
			all = max & (~(row | ld | rd));
			while (all != 0) {
				p = all & (-all);
				all = all - p;
				number += queue(row + p, (ld + p) << 1, (rd + p) >> 1, max);
			}
		} else {
			return 1;
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
