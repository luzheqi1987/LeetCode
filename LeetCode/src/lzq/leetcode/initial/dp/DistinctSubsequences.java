package lzq.leetcode.initial.dp;

public class DistinctSubsequences {
	/**
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of T in S.
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Here is an example: S = "rabbbit", T = "rabbit"
	 * 
	 * Return 3.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == S || null == T || T.length() > S.length()) {
			return 0;
		}
		if (S.equals(T)) {
			return 1;
		}
		int[][] sum = new int[S.length()][T.length()];
		if (S.charAt(0) == T.charAt(0)) {
			sum[0][0] = 1;
		}
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == T.charAt(0)) {
				sum[i][0] = 1 + sum[i - 1][0];
			} else {
				sum[i][0] = sum[i - 1][0];
			}
		}
		for (int i = 1; i < S.length(); i++) {
			for (int j = 1; j <= i && j < T.length(); j++) {
				if (S.charAt(i) == T.charAt(j)) {
					sum[i][j] = sum[i - 1][j] + sum[i - 1][j - 1];
				} else {
					sum[i][j] = sum[i - 1][j];
				}
			}
		}

		return sum[S.length() - 1][T.length() - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "ccc";
		String T = "c";
		int sum = new DistinctSubsequences().numDistinct(S, T);
		System.out.println(sum);
	}

}
