package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {
	Map<Character, Integer> charNumber = new HashMap<>();
	Map<Integer, List<Character>> numberChar = new TreeMap<>(
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});

	public String frequencySort(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		char[] cs = s.toCharArray();
		for (char c : cs) {
			charNumber.put(c, charNumber.getOrDefault(c, 0) + 1);
			int number = charNumber.get(c);
			if (number > 1) {
				List<Character> chars = numberChar.get(number - 1);
				chars.remove((Character) c);
			}

			List<Character> chars = numberChar.get(number);
			if (null == chars) {
				chars = new ArrayList<>();
			}
			chars.add(c);

			numberChar.put(number, chars);

		}
		StringBuilder sb = new StringBuilder();
		for (int n : numberChar.keySet()) {
			for (char c : numberChar.get(n)) {
				for (int i = 0; i < n; i++) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
		System.out.println(sortCharactersByFrequency.frequencySort("tree"));

	}

}
