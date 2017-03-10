package lzq.leetcode.initial.normal;

public class Minesweeper {

	public char[][] updateBoard(char[][] board, int[] click) {
		if (board.length <= 0 || board[0].length <= 0) {
			return board;
		}
		char[][] tmpBoard = new char[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				tmpBoard[i][j] = board[i][j];
			}
		}
		changeBoard(tmpBoard, click);
		return tmpBoard;
	}

	private void changeBoard(char[][] board, int[] click) {
		int x = click[0];
		int y = click[1];
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
			return;
		}
		if (board[x][y] == 'M') {
			board[x][y] = 'X';
			return;
		}

		if (board[x][y] != 'E') {
			return;
		}

		int mineNumber = (x - 1 >= 0 ? (board[x - 1][y] == 'M' ? 1 : 0) : 0)
				+ (x - 1 >= 0 && y - 1 >= 0 ? (board[x - 1][y - 1] == 'M' ? 1
						: 0) : 0)
				+ (x - 1 >= 0 && y + 1 < board[0].length ? (board[x - 1][y + 1] == 'M' ? 1
						: 0)
						: 0)
				+ (y - 1 >= 0 ? (board[x][y - 1] == 'M' ? 1 : 0) : 0)
				+ (y + 1 < board[0].length ? (board[x][y + 1] == 'M' ? 1 : 0)
						: 0)
				+ (x + 1 < board.length ? (board[x + 1][y] == 'M' ? 1 : 0) : 0)
				+ (x + 1 < board.length && y - 1 >= 0 ? (board[x + 1][y - 1] == 'M' ? 1
						: 0)
						: 0)
				+ (x + 1 < board.length && y + 1 < board[0].length ? (board[x + 1][y + 1] == 'M' ? 1
						: 0)
						: 0);
		if (mineNumber == 0) {
			board[x][y] = 'B';
			changeBoard(board, new int[] { x - 1, y });
			changeBoard(board, new int[] { x - 1, y - 1 });
			changeBoard(board, new int[] { x - 1, y + 1 });
			changeBoard(board, new int[] { x, y - 1 });
			changeBoard(board, new int[] { x, y + 1 });
			changeBoard(board, new int[] { x + 1, y - 1 });
			changeBoard(board, new int[] { x + 1, y });
			changeBoard(board, new int[] { x + 1, y + 1 });
		} else {
			board[x][y] = (char) (mineNumber + '0');
		}
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'M', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E' } };
		Minesweeper minesweeper = new Minesweeper();
		char[][] result = minesweeper.updateBoard(board, new int[] { 3, 0 });

		for (char[] row : result) {
			for (char item : row) {
				System.out.print(String.valueOf(item) + '\t');
			}
			System.out.println();
		}
	}

}
