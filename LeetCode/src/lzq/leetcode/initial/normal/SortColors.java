package lzq.leetcode.initial.normal;

public class SortColors {
	/**
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 * Note: You are not suppose to use the library's sort function for this
	 * problem.
	 * 
	 * click to show follow up.
	 * 
	 * Follow up: A rather straight forward solution is a two-pass algorithm
	 * using counting sort. First, iterate the array counting number of 0's,
	 * 1's, and 2's, then overwrite array with total number of 0's, then 1's and
	 * followed by 2's.
	 * 
	 * Could you come up with an one-pass algorithm using only constant space?
	 * Discuss
	 * 
	 * 
	 * @param A
	 */
	public void sortColors(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		// 012012012012
		int start = 0;
		int end = A.length - 1;
		while (start < A.length && A[start] == 0) {
			start++;
		}
		while (end > 0 && A[end] == 2) {
			end--;
		}
		for (int mid = start; mid <= end; mid++) {
			if (A[mid] == 0) {
				int tmp = A[mid];
				A[mid] = A[start];
				A[start] = tmp;
				start++;
				while (start < A.length && A[start] == 0) {
					start++;
				}
				mid = start - 1;
			} else if (mid != end && A[mid] == 2) {
				int tmp = A[mid];
				A[mid] = A[end];
				A[end] = tmp;
				end--;
				mid--;
				while (end > 0 && A[end] == 2) {
					end--;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 0, 1 };
		new SortColors().sortColors(A);

		System.out.println(A);
	}

}
