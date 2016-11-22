package lzq.leetcode.initial.normal;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {

	/*
	 * public int numberOfArithmeticSlices(int[] A) { if (null == A || A.length
	 * <= 2) { return 0; } long[] B = new long[A.length]; for (int i = 0; i <
	 * A.length; i++) { B[i] = A[i]; } int result = 0; for (int i = 0; i <
	 * A.length; i++) { for (int j = i + 1; j < A.length; j++) { result +=
	 * findSutiable(j, B[j] - B[i], B); } } return result; }
	 * 
	 * int findSutiable(int start, long inter, long[] A) { int result = 0; for
	 * (int i = start + 1; i < A.length; i++) { if (A[i] - A[start] == inter) {
	 * result += 1 + findSutiable(i, inter, A); } } return result; }
	 */

	public int numberOfArithmeticSlices(int[] A) {
		int re = 0;
		HashMap<Integer, HashMap<Long, Integer>> diffMaps = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			HashMap<Long, Integer> diffMap = new HashMap<>();
			diffMaps.put(i, diffMap);
			int num = A[i];
			for (int j = 0; j < i; j++) {
				if ((long) num - A[j] > Integer.MAX_VALUE)
					continue;
				if ((long) num - A[j] < Integer.MIN_VALUE)
					continue;
				long diff = (long) num - A[j];
				int count = diffMaps.get(j).getOrDefault(diff, 0);
				diffMaps.get(i).put(diff, diffMaps.get(i).getOrDefault(diff, 0) + count + 1);
				re += count;
			}
		}
		return re;
	}

	public static void main(String[] args) {
		ArithmeticSlicesIISubsequence arithmeticSlicesIISubsequence = new ArithmeticSlicesIISubsequence();
		// int[] nums = new int[] { 2, 4, 6, 8, 10 };
		// int[] nums = new int[] { 0,2000000000,-294967296};
		// int[] nums = new int[] { 79, 20, 64, 28, 67, 81, 60, 58, 97, 85, 92,
		// 96, 82, 89, 46, 50, 15, 2, 36, 44, 54, 2, 90, 37, 7, 79, 26,
		// 40, 34, 67, 64, 28, 60, 89, 46, 31, 9, 95, 43, 19, 47, 64, 48,
		// 95, 80, 31, 47, 19, 72, 99, 28, 46, 13, 9, 64, 4, 68, 74, 50,
		// 28, 69, 94, 93, 3, 80, 78, 23, 80, 43, 49, 77, 18, 68, 28, 13,
		// 61, 34, 44, 80, 70, 55, 85, 0, 37, 93, 40, 47, 47, 45, 23, 26,
		// 74, 45, 67, 34, 20, 33, 71, 48, 96 };
		int[] nums = new int[] { 1, 1, 1, 1 };
		System.out.println(arithmeticSlicesIISubsequence
				.numberOfArithmeticSlices(nums));

	}

}
