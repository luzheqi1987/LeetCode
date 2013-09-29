package lzq.leetcode;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s1 && null == s2 && null == s3) {
			return true;
		} else if (null == s1 && null == s2 && null != s3) {
			return false;
		} else if (null == s1) {
			if (s2.equals(s3)) {
				return true;
			} else {
				return false;
			}
		} else if (null == s2) {
			if (s1.equals(s3)) {
				return true;
			} else {
				return false;
			}
		} else if (null != s1 && null != s2 && null != s3) {
			if (s3.length() != s1.length() + s2.length()) {
				return false;
			}
		}

		boolean[][] is = new boolean[s1.length() + 1][s2.length() + 1];
		is[0][0] = true;
		for (int i = 1; i < s1.length() + 1; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
				is[i][0] = true && is[i - 1][0];
			}
		}
		for (int i = 1; i < s2.length() + 1; i++) {
			if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
				is[0][i] = true & is[0][i - 1];
			}
		}
		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < s2.length() + 1; j++) {
				boolean b1 = false;
				boolean b2 = false;
				if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
					b1 = is[i - 1][j];
				}
				if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					b2 = is[i][j - 1];
				}
				is[i][j] = b1 || b2;
			}
		}
		return is[s1.length()][s2.length()];
		// return dfs(s1, s2, s3, 0, 0, 0);
	}

	boolean dfs(String s1, String s2, String s3, int i1, int i2, int i3) {
		if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
			return true;
		}
		boolean isInterleave1 = false;
		boolean isInterleave2 = false;
		if (i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1)) {
			isInterleave1 = dfs(s1, s2, s3, i1 + 1, i2, i3 + 1);
		}
		if (i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2)) {
			isInterleave2 = dfs(s1, s2, s3, i1, i2 + 1, i3 + 1);
		}
		return (isInterleave1 || isInterleave2) ? true : false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "abaa";
		boolean is = new InterleavingString().isInterleave(s1, s2, s3);

		System.out.println(is);
	}
}
