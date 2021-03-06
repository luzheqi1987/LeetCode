package lzq.leetcode.better.normal;

public class RemoveDuplicatesfromSortedArray {
	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array A = [1,1,2],
	 * 
	 * Your function should return length = 2, and A is now [1,2].
	 * 
	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A.length <= 0) {
			return 0;
		}
		int len = 1;
		for (int nxt = 1; nxt < A.length; nxt++) {
			if (A[nxt] != A[len - 1]) {
				A[len++] = A[nxt];
			}
		}
		return len;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RemoveDuplicatesfromSortedArray()
				.removeDuplicates(new int[] { 1, 1, 2, 2 }));
	}

}
