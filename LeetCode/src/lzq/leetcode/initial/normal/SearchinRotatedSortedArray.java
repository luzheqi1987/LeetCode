package lzq.leetcode.initial.normal;

public class SearchinRotatedSortedArray {
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int search(int[] A, int target) {
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
				return mid;
			}
		}
		if (A[start] == target) {
			return start;
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
