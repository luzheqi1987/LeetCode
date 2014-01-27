package lzq.leetcode.better.normal;

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
		int last0 = A.length - 1;
		int last1 = A.length - 1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (1 == A[i]) {
				int tmp = A[i];
				A[i] = A[last0];
				A[last0] = tmp;
				last0--;
			} else if (2 == A[i]) {
				int tmp = A[i];
				A[i] = A[last0];
				A[last0] = A[last1];
				A[last1] = tmp;
				last0--;
				last1--;
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
