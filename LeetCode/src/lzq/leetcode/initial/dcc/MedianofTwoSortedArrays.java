package lzq.leetcode.initial.dcc;

public class MedianofTwoSortedArrays {
	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int k = A.length + B.length;
		if ((k & 0x1) == 1) {
			return find(A, 0, A.length, B, 0, B.length, k / 2 + 1);
		} else {
			return (find(A, 0, A.length, B, 0, B.length, k / 2) + find(A, 0,
					A.length, B, 0, B.length, k / 2 + 1)) / 2.0;
		}
	}

	double find(int A[], int startA, int lengthA, int B[], int startB,
			int lengthB, int k) {
		if (lengthA > lengthB) {
			return find(B, startB, lengthB, A, startA, lengthA, k);
		}

		if (lengthA <= 0) {
			return B[startB + k - 1];
		}
		if (lengthB <= 0) {
			return A[startA + k - 1];
		}

		if (k <= 1) {
			return Math.min(A[startA], B[startB]);
		}

		int i = Math.min(k >> 1, lengthA);
		int j = k - i;

		if (A[startA + i - 1] < B[startB + j - 1]) {
			return find(A, startA + i, lengthA - i, B, startB, lengthB, k - i);
		} else {
			return find(A, startA, lengthA, B, startB + j, lengthB - j, k - j);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(new MedianofTwoSortedArrays().findMedianSortedArrays(
						new int[] { 2, 3, 4 }, new int[] { 1 }));
	}

}
