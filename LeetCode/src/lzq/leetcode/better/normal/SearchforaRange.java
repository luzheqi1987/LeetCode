package lzq.leetcode.better.normal;

public class SearchforaRange {
	/**
	 * Given a sorted array of integers, find the starting and ending position
	 * of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] A, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] >= target) {
				end = mid - 1;
			}
		}
		int left = start;
		start = 0;
		end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] <= target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid - 1;
			}
		}
		int right = end;
		if (left > (A.length - 1) || A[left] != target || right < 0
				|| A[right] != target) {
			return new int[] { -1, -1 };
		}
		return new int[] { left, right};
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = new SearchforaRange().searchRange(new int[] { 5, 7, 7,
				8, 8, 10 }, 11);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
