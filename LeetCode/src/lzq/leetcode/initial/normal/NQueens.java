package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class NQueens {
	/**
	 * The n-queens puzzle is the problem of placing n queens on an n¡Án
	 * chessboard such that no two queens attack each other.
	 * 
	 * 
	 * 
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * 
	 * Each solution contains a distinct board configuration of the n-queens'
	 * placement, where 'Q' and '.' both indicate a queen and an empty space
	 * respectively.
	 * 
	 * For example, There exist two distinct solutions to the 4-queens puzzle:
	 * 
	 * [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
	 * 
	 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
	 * 
	 * @param n
	 * @return
	 */
	public ArrayList<String[]> solveNQueens(int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<Integer> cols = new ArrayList<Integer>();
		ArrayList<String[]> result = createNQueens(n, cols, 0);
		return result;
	}

	public ArrayList<String[]> createNQueens(int n, ArrayList<Integer> cols,
			int col) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<String[]> results = new ArrayList<String[]>();
		for (int i = 0; i < n; i++) {
			if (cols.contains((Integer) i)) {
				continue;
			} else if (!cols.isEmpty()) {
				int j;
				for (j = cols.size() - 1; j >= 0; j--) {
					if (Math.abs(i - cols.get(j)) == cols.size() - j) {
						break;
					}
				}
				if (j >= 0) {
					continue;
				}
			}
			cols.add((Integer) i);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (j != i) {
					sb.append('.');
				} else {
					sb.append('Q');
				}
			}
			if (col == n - 1) {
				String[] strs = new String[n];
				strs[col] = sb.toString();
				results.add(strs);
			} else {
				ArrayList<String[]> nextResult = createNQueens(n, cols, col + 1);
				for (String[] strs : nextResult) {
					strs[col] = sb.toString();
					results.add(strs);
				}
			}
			cols.remove((Integer) i);

		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NQueens().solveNQueens(4));
	}

}
