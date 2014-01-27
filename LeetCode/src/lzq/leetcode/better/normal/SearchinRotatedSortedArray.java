package lzq.leetcode.better.normal;

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
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[start] < A[mid]) {
				if (A[start] <= target && A[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (A[mid] < A[end]) {
				if (A[mid] < target && A[end] >= target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (A[start] == A[mid]) {
				start++;
			} else if (A[mid] == A[end]) {
				end--;
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
		new SearchinRotatedSortedArray().search(new int[] { 3, 1 }, 0);
	}

}
