package lzq.leetcode.initial.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all
	 * unique combinations in C where the candidate numbers sums to T.
	 * 
	 * The same repeated number may be chosen from C unlimited number of times.
	 * 
	 * Note: All numbers (including target) will be positive integers. Elements
	 * in a combination (a1, a2, … , ak) must be in non-descending order. (ie,
	 * a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate
	 * combinations. For example, given candidate set 2,3,6,7 and target 7, A
	 * solution set is: [7] [2, 2, 3]
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		Arrays.sort(candidates);
		return dfs(candidates, target, 0, 0);
	}

	ArrayList<ArrayList<Integer>> dfs(int[] candidates, int target, int sum,
			int i) {
		if (i >= candidates.length) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
			return results;
		}
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		for (int index = 0; index * candidates[i] <= target; index++) {
			int tmpsum = sum + index * candidates[i];
			if (tmpsum == target) {
				ArrayList<Integer> result = new ArrayList<Integer>();
				for (int m = 0; m < index; m++) {
					result.add(0, candidates[i]);
				}
				results.add(result);
			} else if (tmpsum < target) {
				ArrayList<ArrayList<Integer>> tmpResults = dfs(candidates,
						target, tmpsum, i + 1);
				for (ArrayList<Integer> tmpResult : tmpResults) {
					ArrayList<Integer> newResult = new ArrayList<Integer>();
					newResult.addAll(tmpResult);
					for (int m = 0; m < index; m++) {
						newResult.add(0, candidates[i]);
					}
					results.add(newResult);
				}
			}
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> rrrr = new CombinationSum()
				.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		System.out.println(rrrr);
	}

}
