package lzq.leetcode.better.dfs;

import java.util.ArrayList;

public class Combinations {
	private ArrayList<ArrayList<Integer>> results = null;
	private ArrayList<Integer> result = null;

	/**
	 * Given two integers n and k, return all possible combinations of k numbers
	 * out of 1 ... n.
	 * 
	 * For example, If n = 4 and k = 2, a solution is:
	 * 
	 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < k) {
			return null;
		}

		results = new ArrayList<ArrayList<Integer>>();
		result = new ArrayList<Integer>();
		dfs(0, k, n, 1);
		return results;
	}

	public void dfs(int depth, int maxDepth, int n, int start) {
		if (depth == maxDepth) {
			results.add(new ArrayList<Integer>(result));
			return;
		}
		for (int i = start; i <= n; i++) {
			result.add((Integer) i);
			dfs(depth + 1, maxDepth, n, i + 1);
			result.remove((Integer) i);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = { 1, 2, 3, 4 };
		ArrayList<ArrayList<Integer>> result = new Combinations().combine(4, 4);
		System.out.println(result);
	}

}
