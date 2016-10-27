package lzq.leetcode.initial.dp;

public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {
		int[][] needBlood = new int[dungeon.length][dungeon[0].length];

		int width = dungeon[0].length;
		int height = dungeon.length;
		if (dungeon.length == 1 && dungeon[0].length == 1) {
			return 1 - dungeon[0][0] > 0 ? 1 - dungeon[0][0] : 1;
		}

		needBlood[height - 1][width - 1] = dungeon[height - 1][width - 1] > 0 ? 1
				: 1 - dungeon[height - 1][width - 1];

		for (int i = height - 2; i >= 0; i--) {
			int temp = needBlood[i + 1][width - 1] - dungeon[i][width - 1];
			if (temp > 0) {
				needBlood[i][width - 1] = temp;
			} else {
				needBlood[i][width - 1] = 1;
			}
		}

		for (int j = width - 2; j >= 0; j--) {
			int temp = needBlood[height - 1][j + 1] - dungeon[height - 1][j];
			if (temp > 0) {
				needBlood[height - 1][j] = temp;
			} else {
				needBlood[height - 1][j] = 1;
			}
		}

		for (int i = height - 2; i >= 0; i--) {
			for (int j = width - 2; j >= 0; j--) {
				int value1 = needBlood[i + 1][j] - dungeon[i][j];
				if (value1 < 0) {
					value1 = 1;
				}
				int value2 = needBlood[i][j + 1] - dungeon[i][j];
				if (value2 < 0) {
					value2 = 1;
				}
				needBlood[i][j] = Math.min(value1, value2);
			}
		}
		return needBlood[0][0];
	}

	public static void main(String[] args) {
		DungeonGame dungeonGame = new DungeonGame();
		// int[][] dungeon = new int[][] { { -2, -3, 3 }, { -5, -10, 1 },
		// { 10, 30, -5 } };
		// int[][] dungeon = new int[][] { { 0, 0, 0 }, { -1, 0, 0 }, { 2, 0, -2
		// } };
		int[][] dungeon = new int[][] { { 2, 1 }, { 1, -1 } };
		System.out.println(dungeonGame.calculateMinimumHP(dungeon));
	}
}
