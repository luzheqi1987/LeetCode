package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FourSumII {
	public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
		if (A == null || A.length <= 0 || B == null || B.length <= 0
				|| C == null || C.length <= 0 || C == null || C.length <= 0) {
			return 0;
		}
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		Arrays.sort(D);

		int number = 0;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			for (int j = 0; j < B.length; j++) {
				sum += B[j];
				for (int m = 0; m < C.length; m++) {
					sum += C[m];
					for (int n = 0; n < D.length; n++) {
						sum += D[n];
						if (sum > 0) {
							sum -= D[n];
							break;
						} else if (sum == 0) {
							number++;
						}
						sum -= D[n];
					}
					sum -= C[m];
				}
				sum -= B[j];
			}
			sum -= A[i];
		}
		return number;
	}

    Map<Integer, Integer> abSum = new HashMap<>();
    
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if (A == null || A.length <= 0 || B == null || B.length <= 0
				|| C == null || C.length <= 0 || C == null || C.length <= 0) {
			return 0;
		}
		int number = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
	            int tmp = A[i] + B[j];
	            abSum.put(tmp, abSum.getOrDefault(tmp, 0) + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				number += abSum.getOrDefault(-(C[i] + D[j]), 0);
			}
		}
		return number;
	}

	public static void main(String[] args) {
		int A[] = new int[] { 1, 2 };
		int B[] = new int[] { -2, -1 };
		int C[] = new int[] { -1, 2 };
		int D[] = new int[] { 0, 2 };
		FourSumII fourSumII = new FourSumII();
		System.out.println(fourSumII.fourSumCount(A, B, C, D));
	}

}
