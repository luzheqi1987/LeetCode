package lzq.leetcode.initial.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	// public void solve(char[][] board) {
	// // Start typing your Java solution below
	// // DO NOT write main() function
	// if (null == board || board.length == 0) {
	// return;
	// }
	// boolean[][] catched = new boolean[board.length][board[0].length];
	// for (int i = 0; i < board.length; i++) {
	// for (int j = 0; j < board[i].length; j++) {
	// catched[i][j] = false;
	// }
	// }
	//
	// for (int i = 0; i < board.length; i++) {
	// if ('O' == board[i][0] && !catched[i][0]) {
	// dfs(catched, board, i, 0);
	// }
	// if ('O' == board[i][board.length - 1]
	// && !catched[i][board.length - 1]) {
	// dfs(catched, board, i, board.length - 1);
	// }
	// }
	// for (int j = 1; j < board[0].length - 1; j++) {
	// if ('O' == board[0][j] && !catched[0][j]) {
	// dfs(catched, board, 0, j);
	// }
	// if ('O' == board[board[0].length - 1][j]
	// && !catched[board[0].length - 1][j]) {
	// dfs(catched, board, board[0].length - 1, j);
	// }
	// }
	// for (int i = 0; i < board.length; i++) {
	// for (int j = 0; j < board[0].length; j++) {
	// board[i][j] = catched[i][j] ? 'O' : 'X';
	// }
	// }
	// }
	//
	// void dfs(boolean[][] catched, char[][] board, int x, int y) {
	// if (x < 0 || x >= catched.length || y < 0 || y >= catched[0].length
	// || board[x][y] != 'O' || catched[x][y])
	// return;
	// catched[x][y] = true;
	// dfs(catched, board, x - 1, y);
	// dfs(catched, board, x + 1, y);
	// dfs(catched, board, x, y - 1);
	// dfs(catched, board, x, y + 1);
	// }

	/**
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded
	 * by 'X'.
	 * 
	 * A region is captured by flipping all 'O's into 'X's in that surrounded
	 * region .
	 * 
	 * For example, X X X X X O O X X X O X X O X X After running your function,
	 * the board should be:
	 * 
	 * X X X X X X X X X X X X X O X X
	 * 
	 * @param board
	 */
	public void solve(char[][] board) {
		if (null == board || board.length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				queue.offer(i * m);
			}

			if (board[i][n - 1] == 'O') {
				queue.offer(i * m + n - 1);
			}
		}

		for (int j = 1; j < n - 1; j++) {
			if (board[0][j] == 'O') {
				queue.offer(j);
			}

			if (board[m - 1][j] == 'O') {
				queue.offer((m - 1) * m + j);
			}
		}

		while (!queue.isEmpty()) {
			int all = queue.poll();
			int x = all / m;
			int y = all % m;
			board[x][y] = 'L';
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (x + i < 0 || x + i > m - 1 || y + j < 0
							|| y + j > n - 1 || (Math.abs(i + j) != 1)) {
						continue;
					}
					int tmpAll = (x + i) * m + y + j;
					if (board[x + i][y + j] == 'O') {
						queue.offer(tmpAll);
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] == 'L' ? 'O' : 'X';
			}
		}
	}

	// void bfs(char[][] board, int i, int j, Queue<Integer> queue) {
	// fill(board, i, j, queue);
	//
	// while (!queue.isEmpty()) {
	// int all = queue.poll();
	// int x = all / board.length;
	// int y = all % board.length;
	//
	// fill(board, x - 1, y, queue);
	// fill(board, x + 1, y, queue);
	// fill(board, x, y - 1, queue);
	// fill(board, x, y + 1, queue);
	// }
	// }
	//
	// void fill(char[][] board, int i, int j, Queue<Integer> queue) {
	// if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
	// || board[i][j] != 'O') {
	// return;
	// }
	// board[i][j] = 'L';
	// queue.add(i * board.length + j);
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] cs = { "OO".toCharArray(), "OX".toCharArray() };
		new SurroundedRegions().solve(cs);
		System.out.println(cs);
	}
}
