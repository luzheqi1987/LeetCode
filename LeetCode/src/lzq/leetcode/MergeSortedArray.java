package lzq.leetcode;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == B) {
			return;
		}
		int[] insert = new int[n + 1];
		insert[0] = -1;
		int insertIndex = 1;
		int lastJ = 0;
		for (int i = 0, j = 0; j < m && i < n;) {
			if (A[j] < B[i]) {
				j++;
				continue;
			} else {
				insert[insertIndex] = insert[insertIndex - 1] + j - lastJ + 1;
				insertIndex++;
				int k;
				for (k = i + 1; k < n; k++) {
					if (B[k] <= A[j]) {
						insert[insertIndex] = insert[insertIndex - 1] + 1;
						insertIndex++;
					} else {
						break;
					}
				}
				i += k - i;
				lastJ = j;
			}
		}
		int moveStep = insertIndex - 1;
		for (int i = m - 1; i >= 0; i--) {
			if (insert[moveStep] != i + moveStep || moveStep == 0) {
				A[i + moveStep] = A[i];
			} else {
				A[i + moveStep] = B[moveStep - 1];
				i++;
				moveStep--;
			}
		}
		if (moveStep != 0) {
			for (int i = 0; i < moveStep; i++) {
				A[i] = B[i];
			}
		}
		if (insertIndex - 1 < n) {
			for (int i = m - 1 + insertIndex; i < m + n; i++) {
				A[i] = B[i - m];
			}
		}
		System.out.println(A);
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
