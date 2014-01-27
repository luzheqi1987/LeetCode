package lzq.leetcode.initial.dp;

public class EditDistance {
	/**
	 * Given two words word1 and word2, find the minimum number of steps
	 * required to convert word1 to word2. (each operation is counted as 1
	 * step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * a) Insert a character b) Delete a character c) Replace a character
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] min = new int[len1 + 1][len2 + 1];
		min[0][0] = 0;
		for (int i = 1; i < len1 + 1; i++) {
			min[i][0] = i;
		}
		for (int i = 1; i < len2 + 1; i++) {
			min[0][i] = i;
		}
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					min[i][j] = min[i - 1][j - 1];
				} else {
					min[i][j] = Math.min(
							Math.min(min[i - 1][j] + 1, min[i][j - 1] + 1),
							min[i - 1][j - 1] + 1);
				}
			}
		}
		return min[len1][len2];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
