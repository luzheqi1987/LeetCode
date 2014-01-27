package lzq.leetcode.initial.normal;

public class SearchInsertPosition {
	/**
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order.
	 * 
	 * You may assume no duplicates in the array.
	 * 
	 * Here are few examples. [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4
	 * [1,3,5,6], 0 ¡ú 0
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] A, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid;
			} else {
				return mid;
			}
		}
		if (A[start] >= target) {
			return start;
		} else {
			return start + 1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SearchInsertPosition().searchInsert(new int[] {
				1, 3, 5, 6 }, 0));
	}

}
