package lzq.leetcode.initial.dp;

public class ClimbingStairs {
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (n <= 0) {
			return 0;
		} else if (1 == n) {
			return 1;
		} else if (2 == n) {
			return 2;
		}
		int[] ways = new int[n + 1];
		ways[1] = 1;
		ways[2] = 2;
		for (int i = 3; i <= n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}
		return ways[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
