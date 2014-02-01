package lzq.leetcode.initial.normal;

import java.util.Arrays;

public class TwoSum {
	/**
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are not
	 * zero-based.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * 
	 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
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
