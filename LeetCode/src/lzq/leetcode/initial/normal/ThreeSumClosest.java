package lzq.leetcode.initial.normal;

import java.util.Arrays;

public class ThreeSumClosest {
	/**
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] num, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (num.length <= 2) {
			return -1;
		}
		Arrays.sort(num);
		int targetClosest = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			int sum = num[i];
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (targetClosest == Integer.MAX_VALUE
						|| (Math.abs(num[start] + num[end] + sum - target) < Math
								.abs(targetClosest - target))) {
					targetClosest = num[start] + num[end] + sum;
				}
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
					return target;
				}
			}
			while (i < num.length - 2 && num[i + 1] == num[i]) {
				i++;
			}
		}
		return targetClosest;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ThreeSumClosest().threeSumClosest(new int[] {
				-3, -2, -5, 3, -4 }, -1));
	}

}
