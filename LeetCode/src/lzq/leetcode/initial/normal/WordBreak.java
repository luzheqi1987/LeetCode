package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
		boolean touched = false;
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (String sub : dict) {
			if (!s.contains(sub)) {
				unused.add(sub);
			}
		}
		dict.removeAll(unused);

		for (int i = 0; i < s.length(); i++) {
			for (String sub : dict) {
				String subTmp = s.substring(i);
				int start = i;
				while (subTmp.contains(sub)) {
					int index = subTmp.indexOf(sub);
					if (map.containsKey(start + index)) {
						map.get(start + index)
								.add(start + index + sub.length());
					} else {
						map.put(start + index, new HashSet<Integer>());
						map.get(start + index)
								.add(start + index + sub.length());
					}
					subTmp = subTmp.substring(index + sub.length());
					start = start + index + sub.length();
					if (start >= s.length()) {
						touched = true;
					}
				}
			}
		}
		if (!touched) {
			return false;
		}
		return wreak(s.length(), map, 0);
	}

	public boolean wreak(int length, Map<Integer, Set<Integer>> map, int x) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (!map.containsKey(x)) {
			return false;
		}
		for (int index : map.get(x)) {
			if (index >= length) {
				return true;
			}
			boolean result = wreak(length, map, index);
			if (result) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		String[] strs = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		for (String str : strs) {
			set.add(str);
		}
		System.out
				.println(new WordBreak()
						.wordBreak(
								"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
								set));
	}
}
