package lzq.leetcode.better.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie,
	 * a ¡Ü b ¡Ü c) The solution set must not contain duplicate triplets. For
	 * example, given array S = {-1 0 1 2 -1 -4},
	 * 
	 * A solution set is: (-1, 0, 1) (-1, -1, 2)
	 * 
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (num.length <= 2) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
			return results;
		}
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		dfs(0, 0, results, result, num, used);
		return results;
	}

	void dfs(int step, int sum, ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> result, int[] num, boolean[] used) {
		if (result.size() == 3) {
			results.add(new ArrayList<Integer>(result));
			return;
		}
		if (step >= num.length) {
			return;
		}
		// no choose
		dfs(step + 1, sum, results, result, num, used);
		// choose
		if (step != 0 && num[step] == num[step - 1] && !used[step - 1]) {
			return;
		}
		if (result.size() == 2 && sum + num[step] != 0) {
			return;
		}
		used[step] = true;
		result.add(num[step]);
		dfs(step + 1, sum + num[step], results, result, num, used);
		used[step] = false;
		result.remove(result.size() - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ThreeSum().threeSum(new int[] { 0, 0, 0, 0 }));
	}

}
