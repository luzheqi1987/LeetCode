package lzq.leetcode.better.dcc;

public class LongestCommonPrefix {
	/**
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 * 
	 * @param strs
	 * @return
	 */
	// FIXME even worse
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
		maxIndex = divide(strs, 0, strs.length - 1);
		return strs[0].substring(0, maxIndex);
	}

	int divide(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start].length();
		} else if (start == end - 1) {
			char[] starts = strs[start].toCharArray();
			char[] ends = strs[end].toCharArray();
			int length = Math.min(starts.length, ends.length);
			for (int i = 0; i < length; i++) {
				if (starts[i] != ends[i]) {
					return i;
				}
			}
			return length;
		}
		int mid = start + (end - start) / 2;
		int leftmin = divide(strs, start, mid - 1);
		int rightmin = divide(strs, mid, end);

		char[] starts = strs[start].toCharArray();
		char[] ends = strs[end].toCharArray();
		int length = Math.min(leftmin, rightmin);
		for (int i = 0; i < length; i++) {
			if (starts[i] != ends[i]) {
				return i;
			}
		}
		return length;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "ca", "c", "bba", "bacb", "bcb" };
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}

}
