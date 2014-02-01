package lzq.leetcode.initial.normal;

public class ValidSudoku {
	/**
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	 * 
	 * The Sudoku board could be partially filled, where empty cells are filled
	 * with the character '.'.
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!check(board, i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	boolean check(char[][] board, int x, int y) {
		for (int i = 0; i < 9; i++) {
			if (i != y && board[x][i] == board[x][y]) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i != x && board[i][y] == board[x][y]) {
				return false;
			}
		}
		for (int i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++) {
			for (int j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++) {
				if (i != x && j != y && board[i][j] == board[x][y]) {
					return false;
				}
			}
		}
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
		System.out.println(new ValidSudoku().isValidSudoku(sudoku));
	}

}
