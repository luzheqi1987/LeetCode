package lzq.leetcode.initial.dp;

public class ScrambleString {
	/**
	 * Given a string s1, we may represent it as a binary tree by partitioning
	 * it to two non-empty substrings recursively.
	 * 
	 * Below is one possible representation of s1 = "great":
	 * 
	 * great / \ gr eat / \ / \ g r e at / \ a t To scramble the string, we may
	 * choose any non-leaf node and swap its two children.
	 * 
	 * For example, if we choose the node "gr" and swap its two children, it
	 * produces a scrambled string "rgeat".
	 * 
	 * rgeat / \ rg eat / \ / \ r g e at / \ a t We say that "rgeat" is a
	 * scrambled string of "great".
	 * 
	 * Similarly, if we continue to swap the children of nodes "eat" and "at",
	 * it produces a scrambled string "rgtae".
	 * 
	 * rgtae / \ rg tae / \ / \ r g ta e / \ t a We say that "rgtae" is a
	 * scrambled string of "great".
	 * 
	 * Given two strings s1 and s2 of the same length, determine if s2 is a
	 * scrambled string of s1.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s1 && null == s2) {
			return true;
		} else if ((null == s1 && null != s2) || (null != s1 && null == s2)) {
			return false;
		} else if (s1.length() != s2.length()) {
			return false;
		} else if (s1.equals(s2)) {
			return true;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int length = s1.length();

		boolean[][][] is = new boolean[length][length][length];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				is[0][i][j] = (c1[i] == c2[j]);
			}
		}
		for (int k = 1; k < length; k++) {
			for (int m = length - k - 1; m >= 0; m--) {
				for (int n = length - k - 1; n >= 0; n--) {
					boolean r = false;
					for (int j = 1; j <= k && !r; j++) {
						if ((is[j - 1][m][n] && is[k - j][j + m][j + n])
								|| (is[j - 1][m][n + k + 1 - j] && is[k - j][m
										+ j][n])) {
							r = true;
						}
					}
					is[k][m][n] = r;
				}
			}
		}
		return is[length - 1][0][0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		String s2 = "bac";
		boolean is = new ScrambleString().isScramble(s1, s2);

		System.out.println(is);
	}

}
