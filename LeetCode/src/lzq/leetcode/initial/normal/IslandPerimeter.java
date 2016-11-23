package lzq.leetcode.initial.normal;

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		int sum = 0;
		if (grid.length <= 0) {
			return 0;
		}
		if (grid[0].length <= 0) {
			return 0;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					sum += calcPerimeter(grid, i, j);
				}
			}
		}
		return sum;
	}

	public int calcPerimeter(int[][] grid, int x, int y) {
		int perimeter = 0;
		if (x == 0 || grid[x - 1][y] == 0) {
			perimeter++;
		}
		if (x == grid.length - 1 || grid[x + 1][y] == 0) {
			perimeter++;
		}
		if (y == 0 || grid[x][y - 1] == 0) {
			perimeter++;
		}
		if (y == grid[0].length - 1 || grid[x][y + 1] == 0) {
			perimeter++;
		}
		return perimeter;
	}

	public static void main(String[] args) {

	}

}
