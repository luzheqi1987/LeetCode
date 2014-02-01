package lzq.leetcode.better.knack;

public class UniquePaths {
	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * 
	 * Above is a 3 x 7 grid. How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (m > n) {
			return uniquePaths(n, m);
		}
		return (int) calc(m + n - 2, m - 1);
	}

	long calc(int n, int k) {
		if (k > n) {
			return 0;
		}
		long r = 1L;
		for (int d = 1; d <= k; ++d) {
			r *= n--;
			r /= d;
		}
		return r;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
