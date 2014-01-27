package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s || "".equals(s)) {
			return 0;
		}
		ArrayList<Character> list = new ArrayList<Character>();
		int max = Integer.MIN_VALUE;
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (list.isEmpty()) {
				list.add(cs[i]);
			} else {
				int index = list.indexOf(cs[i]);
				if (index == -1) {
					list.add(cs[i]);
				} else {
					for (int j = 0; j <= index; j++) {
						list.remove(0);
					}
					list.add(cs[i]);
				}
			}
			if (list.size() > max) {
				max = list.size();
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestSubstringWithoutRepeatingCharacters()
				.lengthOfLongestSubstring("bbbbbbbbbbbbbbbbbbbbb"));
	}

}
