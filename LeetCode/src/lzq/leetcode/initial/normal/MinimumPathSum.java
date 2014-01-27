package lzq.leetcode.initial.normal;

public class MinimumPathSum {
	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 * 
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] sum = new int[grid.length][grid[0].length];
		sum[0][0] = grid[0][0];
		for (int i = 1; i < grid.length; i++) {
			sum[i][0] = grid[i][0] + sum[i - 1][0];
		}
		for (int i = 1; i < grid[0].length; i++) {
			sum[0][i] = grid[0][i] + sum[0][i - 1];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
			}
		}
		return sum[sum.length - 1][sum[0].length - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
