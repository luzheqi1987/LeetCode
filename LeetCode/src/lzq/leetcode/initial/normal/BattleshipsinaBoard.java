package lzq.leetcode.initial.normal;

public class BattleshipsinaBoard {
	public int countBattleships(char[][] board) {
		int shipNumber = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					if (i > 0) {
						if (board[i - 1][j] == 'X') {
							continue;
						}
					}
					if (j > 0) {
						if (board[i][j - 1] == 'X') {
							continue;
						}
					}
					shipNumber++;
				}
			}
		}
		return shipNumber;
	}

	public static void main(String[] args) {
		char[][] ships = new char[][] { { 'X', '.', '.', 'X' },
				{ '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		BattleshipsinaBoard battleshipsinaBoard = new BattleshipsinaBoard();
		System.out.println(battleshipsinaBoard.countBattleships(ships));
	}

}
