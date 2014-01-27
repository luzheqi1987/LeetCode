package lzq.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		Set<String> unused = new HashSet<String>();
		boolean touched = false;
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (String dic : dict) {
			if (!s.contains(dic)) {
				unused.add(dic);
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
			return new ArrayList<String>();
		}

		return wbreak(s, s.length(), map, 0);
	}

	ArrayList<String> wbreak(String s, int length,
			Map<Integer, Set<Integer>> map, int x) {
		if (!map.containsKey(x)) {
			return new ArrayList<String>();
		}
		ArrayList<String> results = new ArrayList<String>();
		for (int index : map.get(x)) {
			String subString = s.substring(x, index);
			if (index >= length) {
				results.add(subString);
			} else {
				ArrayList<String> subResults = wbreak(s, length, map, index);
				if (subResults.isEmpty()) {
					continue;
				} else {
					for (String subResult : subResults) {
						String result = subString + " " + subResult;
						results.add(result);
					}
				}
			}
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
