package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	/**
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * 
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public String minWindow(String S, String T) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (T.length() > S.length()) {
			return "";
		}
		Map<Character, Integer> table = new HashMap<Character, Integer>();
		char[] ss = S.toCharArray();
		char[] tt = T.toCharArray();
		Map<Character, Integer> ttable = new HashMap<Character, Integer>();
		ArrayList<Character> cs = new ArrayList<Character>();
		for (char c : tt) {
			if (ttable.containsKey(c)) {
				int num = ttable.get(c);
				ttable.put(c, num + 1);
			} else {
				ttable.put(c, 1);
			}
			cs.add(c);
		}
		int start = -1;
		int end = -1;
		String substring = "";
		for (int i = 0; i < ss.length; i++) {
			if (ttable.keySet().contains(ss[i])) {
				if (-1 == start) {
					start = i;
				}
				int num = ttable.get(ss[i]);
				if (num > 1) {
					ttable.put(ss[i], num - 1);
				} else {
					ttable.remove(ss[i]);
				}
				if (ttable.isEmpty()) {
					end = i;
					substring = S.substring(start, end + 1);
					break;
				}
			} else if (cs.contains(ss[i])) {
				if (table.containsKey(ss[i])) {
					int num = table.get(ss[i]);
					table.put(ss[i], num + 1);
				} else {
					table.put(ss[i], 1);
				}
			}
		}
		if (-1 == start || -1 == end) {
			return "";
		}
		for (start = start + 1; start <= ss.length - tt.length
				&& end < ss.length; start++) {
			if (!cs.contains(ss[start - 1])) {
				String tmp = S.substring(start, end + 1);
				if (tmp.length() < substring.length()) {
					substring = tmp;
				}
				continue;
			} else {
				if (table.containsKey(ss[start - 1])) {
					int num = table.get(ss[start - 1]);
					if (num > 1) {
						table.put(ss[start - 1], num - 1);
					} else {
						table.remove(ss[start - 1]);
					}
					String tmp = S.substring(start, end + 1);
					if (tmp.length() < substring.length()) {
						substring = tmp;
					}
				} else {
					for (end = end + 1; end < ss.length; end++) {
						if (ss[start - 1] == ss[end]) {
							break;
						}
						if (cs.contains(ss[end])) {
							if (table.containsKey(ss[end])) {
								int num = table.get(ss[end]);
								table.put(ss[end], num + 1);
							} else {
								table.put(ss[end], 1);
							}
						}
					}
					if (end < ss.length) {
						String tmp = S.substring(start, end + 1);
						if (tmp.length() < substring.length()) {
							substring = tmp;
						}
					} else {
						break;
					}
				}
			}
		}
		return substring;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "abbbb";
		String T = "aa";

		String sub = new MinimumWindowSubstring().minWindow(S, T);

		System.out.println(sub);
	}

}
