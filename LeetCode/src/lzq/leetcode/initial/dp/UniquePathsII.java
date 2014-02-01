package lzq.leetcode.initial.dp;

public class UniquePathsII {
	/**
	 * Follow up for "Unique Paths":
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid.
	 * 
	 * For example, There is one obstacle in the middle of a 3x3 grid as
	 * illustrated below.
	 * 
	 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] sum = new int[m][n];
		sum[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				sum[i][0] = 0;
			} else {
				sum[i][0] = sum[i - 1][0];
			}
		}
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				sum[0][i] = 0;
			} else {
				sum[0][i] = sum[0][i - 1];
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] != 1) {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
				} else {
					sum[i][j] = 0;
				}

			}
		}
		return sum[m - 1][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = new int[][] { { 1, 0 } };
		System.out.println(new UniquePathsII()
				.uniquePathsWithObstacles(obstacleGrid));
	}

}
