package lzq.leetcode;

public class SortColors {
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
