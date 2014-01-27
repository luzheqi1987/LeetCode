package lzq.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
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
