package lzq.leetcode.initial.normal;

public class SearchinRotatedSortedArrayII {
	/**
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 * 
	 * Would this affect the run-time complexity? How and why?
	 * 
	 * Write a function to determine if a given target is in the array.
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public boolean search(int[] A, int target) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int pivot = 1;
		for (; pivot < A.length; pivot++) {
			if (A[pivot] < A[pivot - 1]) {
				break;
			}
		}
		int start = 0;
		int end = 0;
		if (pivot == A.length) {
			end = A.length - 1;
		} else {
			if (A[0] <= target && A[pivot - 1] >= target) {
				start = 0;
				end = pivot - 1;
			} else {
				start = pivot;
				end = A.length - 1;
			}
		}
		while (start < end) {
			int mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid;
			} else {
				return true;
			}
		}
		if (A[start] == target) {
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
