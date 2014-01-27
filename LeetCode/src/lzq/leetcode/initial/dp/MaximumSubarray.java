package lzq.leetcode.initial.dp;

public class MaximumSubarray {
	/**
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 * 
	 * click to show more practice.
	 * 
	 * More practice: If you have figured out the O(n) solution, try coding
	 * another solution using the divide and conquer approach, which is more
	 * subtle.
	 * 
	 * @param A
	 * @return
	 */
	public int maxSubArray(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (null == A || A.length <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int tmpmax = 0;
		for (int i = 0; i < A.length; i++) {
			tmpmax += A[i];
			if (tmpmax > max) {
				max = tmpmax;
			}
			if (tmpmax < 0) {
				tmpmax = 0;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
