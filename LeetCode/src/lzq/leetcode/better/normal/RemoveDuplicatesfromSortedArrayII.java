package lzq.leetcode.better.normal;

public class RemoveDuplicatesfromSortedArrayII {
	/**
	 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
	 * twice?
	 * 
	 * For example, Given sorted array A = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
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
		boolean morethan2 = false;
		for (int nxt = 1; nxt < A.length; nxt++) {
			if (A[nxt] != A[len - 1]) {
				A[len++] = A[nxt];
				morethan2 = false;
			} else if (!morethan2) {
				A[len++] = A[nxt];
				morethan2 = true;
			}
		}
		return len;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RemoveDuplicatesfromSortedArrayII()
				.removeDuplicates(new int[] { 1, 1, 1, 2, 2 }));
	}

}
