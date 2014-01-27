package lzq.leetcode.initial.dp;

public class RegularExpressionMatching {
	/**
	 * Implement regular expression matching with support for '.' and '*'.
	 * 
	 * '.' Matches any single character. '*' Matches zero or more of the
	 * preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa",
	 * ".*") → true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function

		boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
		f[0][0] = true;
		char[] ss = s.toCharArray();
		char[] ps = p.toCharArray();
		for (int i = 0; i <= s.length(); ++i) {
			char preChar = '\0';
			int preIdx = 0;
			for (int j = 1; j <= p.length(); ++j) {
				if (i >= 1 && (ps[j - 1] == '.' || ss[i - 1] == ps[j - 1]))
					f[i][j] = f[i - 1][j - 1];
				else if (ps[j - 1] == '*') {
					if (i >= 1 && (preChar == ss[i - 1] || preChar == '.'))
						f[i][j] = f[i - 1][j] || f[i][j - 1];
					f[i][j] = f[i][j] || f[i][preIdx];
					// f[i-1][j] = f[i-1][j] || f[i-1][preIdx];
				}
				if (ps[j - 1] != '*') {
					preChar = ps[j - 1];
					preIdx = j - 1;
				}
			}
		}

		return f[s.length()][p.length()];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RegularExpressionMatching().isMatch("bbb", "b*"));
	}

}
