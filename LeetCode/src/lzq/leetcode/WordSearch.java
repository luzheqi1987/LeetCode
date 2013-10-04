package lzq.leetcode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == board || board.length <= 0) {
			return false;
		}
		if (null == word || "".equals(word)) {
			return true;
		}
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] walked = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (checkExist(board, word, i, j, 0, walked)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean checkExist(char[][] board, String word, int i, int j, int index,
			boolean[][] walked) {
		boolean existed = false;
		if (board[i][j] == word.charAt(index) && !walked[i][j]) {
			if (index == word.length() - 1) {
				return true;
			}
			for (int m = -1; m <= 1; m++) {
				for (int n = -1; n <= 1; n++) {
					if (Math.abs(n - m) != 1 || i + m < 0
							|| i + m >= board.length || j + n < 0
							|| j + n >= board[0].length || walked[m + i][n + j]) {
						continue;
					}
					walked[i][j] = true;
					existed = checkExist(board, word, m + i, n + j, index + 1,
							walked);
					walked[i][j] = false;
					if (existed) {
						return existed;
					}
				}
			}
		}
		return existed;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
		// { 'A', 'D', 'E', 'E' } };
		// String s = "ABCB";
		// char[][] board = { { 'a' } };
		// String s = "a";
		char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' },
				{ 'B', 'C', 'D' } };
		String s = "AAB";
		boolean existed = new WordSearch().exist(board, s);

		System.out.println(existed);
	}
}
