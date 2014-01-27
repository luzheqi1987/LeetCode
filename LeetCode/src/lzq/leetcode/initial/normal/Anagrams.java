package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	/**
	 * Given an array of strings, return all groups of strings that are
	 * anagrams.
	 * 
	 * Note: All inputs will be in lower-case.
	 * 
	 * For example, "triangle" and "integral"
	 * 
	 * @param strs
	 * @return
	 */
	public ArrayList<String> anagrams(String[] strs) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> result = new ArrayList<String>();

		for (String str : strs) {
			char[] cs = str.toCharArray();
			Arrays.sort(cs);
			String newStr = new String(cs);
			if (map.containsKey(newStr)) {
				ArrayList<String> value = map.get(newStr);
				value.add(str);
				map.put(newStr, value);
			} else {
				ArrayList<String> value = new ArrayList<String>();
				value.add(str);
				map.put(newStr, value);
			}
		}
		for (ArrayList<String> value : map.values()) {
			if (value.size() > 1) {
				result.addAll(value);
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
