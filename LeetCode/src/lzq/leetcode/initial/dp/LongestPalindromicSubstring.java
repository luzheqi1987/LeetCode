package lzq.leetcode.initial.dp;

public class LongestPalindromicSubstring {
	/**
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s || s.length() <= 0) {
			return "";
		} else if (s.length() == 1) {
			return s;
		}
		boolean[][] isPalindromic = new boolean[s.length()][s.length()];
		char[] cs = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			isPalindromic[i][i] = true;
		}
		int start = -1;
		int end = -1;
		for (int i = s.length() - 2; i >= 0; i--) {
			isPalindromic[i][i + 1] = cs[i] == cs[i + 1];
			if (end - start < 1 && isPalindromic[i][i + 1]) {
				start = i;
				end = i + 1;
			}
			for (int j = i + 2; j < s.length(); j++) {
				isPalindromic[i][j] = cs[i] == cs[j]
						&& isPalindromic[i + 1][j - 1];
				if (end - start < j - i && isPalindromic[i][j]) {
					start = i;
					end = j;
				}
			}
		}
		if (start == -1 && end == -1) {
			return s.substring(0, 1);
		} else {
			return s.substring(start, end + 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindromicSubstring()
				.longestPalindrome("aab"));
	}

}
