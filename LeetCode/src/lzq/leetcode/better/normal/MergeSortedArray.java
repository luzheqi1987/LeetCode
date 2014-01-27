package lzq.leetcode.better.normal;

public class MergeSortedArray {
	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted
	 * array.
	 * 
	 * Note: You may assume that A has enough space to hold additional elements
	 * from B. The number of elements initialized in A and B are m and n
	 * respectively.
	 * 
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == B || B.length <= 0) {
			return;
		}
		int M = m - 1;
		int N = n - 1;
		int P = m + n - 1;
		while (M >= 0 && N >= 0) {
			A[P--] = B[N] > A[M] ? B[N--] : A[M--];
		}
		while (N >= 0) {
			A[P--] = B[N--];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[255];
		int[] B = new int[] { -1, 1, 1, 1, 2, 3 };
		A[0] = 0;
		A[1] = 0;
		A[2] = 3;
		// A[3] = 3;
		// A[4] = 3;
		// A[5] = 3;

		new MergeSortedArray().merge(A, 3, B, 6);
	}

}
