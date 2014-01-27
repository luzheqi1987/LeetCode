package lzq.leetcode;


public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if ((null == s && p != null) || (null != s && null == p)) {
			return false;
		} else if (null == s && null == p) {
			return true;
		}
		int plenNoStar = 0;
		for (char c : p.toCharArray())
			if (c != '*')
				plenNoStar++;
		if (plenNoStar > s.length())
			return false;

		boolean[] match = new boolean[s.length() + 1];
		int firstTrue = 0;
		match[0] = true;

		int lens = s.length();
		int lenp = p.length();
		char[] ss = s.toCharArray();
		char[] ps = p.toCharArray();

		for (int i = 0; i < lenp; i++) {
			if (i > 0 && ps[i] == '*' && ps[i - 1] == '*') {
				continue;
			}
			if (ps[i] == '*') {
				for (int fi = firstTrue + 1; fi <= s.length(); ++fi) {
					match[fi] = true;
				}
			} else {
				int firstMatch = -1;
				for (int j = lens; j > firstTrue; j--) {
					if (ss[j - 1] == ps[i] || ps[i] == '?') {
						match[j] = match[j - 1];
					} else {
						match[j] = false;
					}
					if (match[j]) {
						firstMatch = j;
					}
				}
				if (firstMatch < 0) {
					return false;
				} else {
					firstTrue = firstMatch;
				}
			}
		}
		return match[lens];
	}

	// public boolean isMatch(String s, String p) {
	// // Note: The Solution object is instantiated only once and is reused by
	// // each test case.
	// if (s == null || p == null) return false;
	//
	// // calculate count for non-wildcard char
	// int count = 0;
	// for (Character c : p.toCharArray()) {
	// if (c != '*') ++count;
	// }
	// // the count should not be larger than that of s
	// if (count > s.length()) return false;
	//
	// boolean[] matches = new boolean[s.length()+1];
	// matches[0] = true;
	// int pid = 0, firstMatch = 0;
	// while (pid < p.length()) {
	// // skip duplicate '*'
	// if (pid > 0 && p.charAt(pid) == '*' && p.charAt(pid-1) == '*') {
	// ++pid;
	// continue;
	// }
	//
	// // if '*', fill up the rest of row
	// if (p.charAt(pid) == '*') {
	// // fill up the rest of row with true, up to the first match in previous
	// row
	// for (int i = firstMatch+1; i <= s.length(); ++i) matches[i] = true;
	// } else {
	// // fill up backwards:
	// // - set to true if match current char and previous diagnal also match
	// // - otherwise, set to false
	// int match = -1;
	// for (int i=s.length(); i>firstMatch; --i) {
	// matches[i] = (p.charAt(pid) == s.charAt(i-1) || p.charAt(pid) == '?')
	// && matches[i-1];
	// if (matches[i]) match = i;
	// }
	// if (match < 0) return false;
	// firstMatch = match;
	// }
	//
	// ++pid;
	// }
	//
	// return matches[s.length()];
	//
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new WildcardMatching().isMatch("aa", "aa"));
	}

}
