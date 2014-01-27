package lzq.leetcode;

import java.util.Arrays;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		if (null == numbers || numbers.length <= 1) {
			return new int[] {};
		}
		int[] tmp = new int[numbers.length];
		int[] results = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			tmp[i] = numbers[i];
		}
		Arrays.sort(tmp);
		int start = 0;
		int end = tmp.length - 1;
		while (start < end) {
			if (tmp[start] + tmp[end] < target) {
				start++;
			} else if (tmp[start] + tmp[end] > target) {
				end--;
			} else {
				break;
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == tmp[start] || numbers[i] == tmp[end]) {
				results[0] = i + 1;
				break;
			}
		}
		for (int i = numbers.length - 1; i >= results[0] - 1; i--) {
			if (numbers[i] == tmp[start] || numbers[i] == tmp[end]) {
				results[1] = i + 1;
				break;
			}
		}

		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TwoSum().twoSum(new int[] { 150, 24, 79, 50, 88,
				345, 3 }, 200));
	}

}
