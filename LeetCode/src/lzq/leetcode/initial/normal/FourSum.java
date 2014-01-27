package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
	 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate
	 * quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and target =
	 * 0.
	 * 
	 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (num.length <= 3) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
			return results;
		}
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 3; i++) {
			for (int j = i + 3; j < num.length; j++) {
				int sum = num[i] + num[j];
				int start = i + 1;
				int end = j - 1;
				while (start < end) {
					if (num[start] + num[end] > target - sum) {
						while (start < end && num[end - 1] == num[end]) {
							end--;
						}
						end--;
					} else if (num[start] + num[end] < target - sum) {
						while (start < end && num[start + 1] == num[start]) {
							start++;
						}
						start++;
					} else {
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[start]);
						result.add(num[end]);
						result.add(num[j]);
						if (!results.contains(result)) {
							results.add(result);
						}
						start++;
						end--;
					}
				}
			}

			while (i < num.length - 3 && num[i + 1] == num[i]) {
				i++;
			}
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FourSum().fourSum(new int[] { -1, 2, 2, -5, 0,
				-1, 4 }, 3));
	}

}
