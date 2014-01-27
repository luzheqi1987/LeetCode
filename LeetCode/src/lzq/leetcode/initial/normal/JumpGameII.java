package lzq.leetcode.initial.normal;

public class JumpGameII {
	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * 
	 * For example: Given array A = [2,3,1,1,4]
	 * 
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
	 * from index 0 to 1, then 3 steps to the last index.)
	 * 
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == A || A.length <= 1)
			return 0;

		int maxIndex = 0;
		int i = 0;
		int length = A.length;
		int step = 0;

		while (i < length && i <= maxIndex) {
			int tmpMaxIndex = maxIndex;
			while (i <= tmpMaxIndex) { //the max index that the step can reach
				if (i + A[i] > maxIndex)
					maxIndex = i + A[i];
				++i;
			}
			++step;
			if (maxIndex >= length - 1)
				return step;
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 1, 1, 4 };
		System.out.println(new JumpGameII().jump(A));
	}

}
