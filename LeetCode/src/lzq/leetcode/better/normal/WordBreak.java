package lzq.leetcode.better.normal;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	/**
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == s || "".equals(s) || dict.contains(s)) {
			return true;
		}
		Set<String> unused = new HashSet<String>();
		boolean[] t = new boolean[s.length() + 1];
		t[0] = true;
		for (String sub : dict) {
			if (!s.contains(sub)) {
				unused.add(sub);
			}
		}
		dict.removeAll(unused);

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				t[i] = t[j] && dict.contains(s.substring(j, i));
				if (t[i]) {
					break;
				}
			}
		}
		return t[s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		String[] strs = { "dog", "s", "gs" };
		for (String str : strs) {
			set.add(str);
		}
		System.out.println(new WordBreak().wordBreak("dogs", set));
	}
}
