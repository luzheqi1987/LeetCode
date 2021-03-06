package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie,
	 * a �� b �� c) The solution set must not contain duplicate triplets. For
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
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int sum = num[i];
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (num[start] + num[end] > 0 - sum) {
					while (start < end && num[end - 1] == num[end]) {
						end--;
					}
					end--;
				} else if (num[start] + num[end] < 0 - sum) {
					while (start < end && num[start + 1] == num[start]) {
						start++;
					}
					start++;
				} else {
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[i]);
					result.add(num[start]);
					result.add(num[end]);
					if (!results.contains(result)) {
						results.add(result);
					}
					start++;
					end--;
				}
			}
			while (i < num.length - 2 && num[i + 1] == num[i]) {
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
		System.out.println(new ThreeSum().threeSum(new int[] { 0, 0, 0, 0 }));
	}

}
