package lzq.leetcode.initial.normal;

public class JumpGame {
	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 * 
	 * @param A
	 * @return
	 */
	public boolean canJump(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (A.length == 1) {
			return A[0] >= 0;
		}
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] - 1 < 0) {
				return false;
			} else {
				A[i] = Math.max(A[i - 1] - 1, A[i]);
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
