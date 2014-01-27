package lzq.leetcode.initial.normal;

public class LongestCommonPrefix {
	/**
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == strs || 0 == strs.length) {
			return "";
		} else if (1 == strs.length) {
			return strs[0];
		}
		int maxIndex = strs[0].length() - 1;
		if (maxIndex < 0) {
			return "";
		}
		char[] cs = strs[0].toCharArray();
		for (int i = 1; i < strs.length; i++) {
			char[] ss = strs[i].toCharArray();
			int j = 0;
			while (j < cs.length && j < ss.length && j <= maxIndex
					&& cs[j] == ss[j]) {
				j++;
			}
			if (j > maxIndex) {
				continue;
			}
			maxIndex = j - 1;
			if (maxIndex < 0) {
				return "";
			}
		}
		return strs[0].substring(0, maxIndex + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "a", "b" };
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}

}
