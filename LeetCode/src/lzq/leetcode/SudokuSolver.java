package lzq.leetcode;

import java.util.ArrayList;

public class SudokuSolver {
	private final static char[] nineNumbers = { '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };

	public void solveSudoku(char[][] board) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<Character>> cols = new ArrayList<ArrayList<Character>>();
		ArrayList<ArrayList<Character>> rows = new ArrayList<ArrayList<Character>>();
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < 9; i++) {
			ArrayList<Character> row = new ArrayList<Character>();
			for (int j = 0; j < 9; j++) {
				row.add(board[i][j]);
				if (board[i][j] == '.') {
					int index = j + i * 9;
					indexes.add(index);
				}
			}
			rows.add(row);
		}
		for (int i = 0; i < 9; i++) {
			ArrayList<Character> col = new ArrayList<Character>();
			for (int j = 0; j < 9; j++) {
				col.add(board[j][i]);
			}
			cols.add(col);
		}
		dfs(cols, rows, indexes, indexes.size(), 0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					board[i][j] = rows.get(i).get(j);
				}
			}
		}
	}

	boolean dfs(ArrayList<ArrayList<Character>> cols,
			ArrayList<ArrayList<Character>> rows, ArrayList<Integer> indexes,
			int indexNumber, int index) {
		if (index >= indexNumber) {
			return true;
		}
		int row = indexes.get(index) / 9;
		int col = indexes.get(index) % 9;

		for (int i = 0; i < nineNumbers.length; i++) {
			if (rows.get(row).contains(nineNumbers[i])
					|| cols.get(col).contains(nineNumbers[i])) {
				continue;
			} else {
				int m = 0;
				int n = 0;
				for (m = 3 * (row / 3); m < 3 * (row / 3 + 1); m++) {
					for (n = 3 * (col / 3); n < 3 * (col / 3 + 1); n++) {
						if (rows.get(m).get(n) == nineNumbers[i]) {
							break;
						}
					}
					if (n < 3 * (col / 3 + 1)) {
						break;
					}
				}
				if (m < 3 * (row / 3 + 1) || n < 3 * (col / 3 + 1)) {
					continue;
				}
			}
			rows.get(row).set(col, nineNumbers[i]);
			cols.get(col).set(row, nineNumbers[i]);
			boolean result = dfs(cols, rows, indexes, indexNumber, index + 1);
			if (result) {
				return true;
			}
			rows.get(row).set(col, '.');
			cols.get(col).set(row, '.');

		}
		return false;
	}

	// void solveSudoku(char[][] board) {
	// dfs(board);
	// System.out.println(true);
	// }
	//
	boolean dfs(char[][] board) {
		for (int i = 0; i < 9; ++i)
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					for (int k = 0; k < 9; ++k) {
						board[i][j] = (char) ('1' + k);
						if (isValid(board, i, j) && dfs(board))
							return true;
						board[i][j] = '.';
					}
					return false;
				}
			}
		return true;
	}

	// 检查 (x, y) 是否合法
	boolean isValid(char[][] board, int x, int y) {
		int i, j;
		for (i = 0; i < 9; i++)
			// 检查 y 列
			if (i != x && board[i][y] == board[x][y])
				return false;
		for (j = 0; j < 9; j++)
			// 检查 x 行
			if (j != y && board[x][j] == board[x][y])
				return false;
		for (i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++)
			for (j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++)
				if (i != x && j != y && board[i][j] == board[x][y])
					return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] sudoku = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		new SudokuSolver().solveSudoku(sudoku);
	}

}
