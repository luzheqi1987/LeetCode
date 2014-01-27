package lzq.leetcode.initial.dp;

public class PalindromePartitioningII {
	/**
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return the minimum cuts needed for a palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return 1 since the palindrome partitioning
	 * ["aa","b"] could be produced using 1 cut.
	 * 
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		return partition(s);
	}

	/**
	 * 使用动态规划计算任意两点间是否为回文
	 * 
	 * @param s
	 *            字符串
	 * @return 最小Cut次数
	 */
	private int partition(String s) {
		if (s == null || s.length() == 0)
			return 0;

		boolean[][] isPalindromes = new boolean[s.length()][s.length()]; // 表示任意两点之间的字符串是否为回文

		for (int i = 0; i < s.length(); i++) {
			isPalindromes[i][i] = true;
		}
		for (int i = s.length() - 2; i >= 0; i--) {
			isPalindromes[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			for (int j = i + 2; j < s.length(); j++)
				isPalindromes[i][j] = (s.charAt(i) == s.charAt(j))
						&& isPalindromes[i + 1][j - 1];
		}

		return getMinCut(s, isPalindromes);
	}

	/**
	 * 使用动态规划计算最小Cut次数
	 * 
	 * @param s
	 *            字符串
	 * @param isPalindromes
	 *            表示任意两点之间的字符串是否为回文
	 * @return
	 */
	private int getMinCut(String s, boolean[][] isPalindromes) {
		int[] cuts = new int[s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			if (isPalindromes[i][s.length() - 1]) {
				cuts[i] = 0;
				continue;
			}
			int min = Integer.MAX_VALUE;
			for (int j = s.length() - 2; j >= i; j--) {
				if (isPalindromes[i][j]) {
					int tmp = 1 + cuts[j + 1];
					min = min > tmp ? tmp : min;
				}
			}
			cuts[i] = min;
		}
		return cuts[0];
	}
}
