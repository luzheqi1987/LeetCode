package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
	private static Map<Character, Integer> charMaps = new HashMap<Character, Integer>();
	static {
		charMaps.put('A', 1);
		charMaps.put('C', 2);
		charMaps.put('G', 4);
		charMaps.put('T', 8);

	}

	Set<Long> numbers = new HashSet<Long>();
	Set<String> numberSets = new HashSet<String>();

	public List<String> findRepeatedDnaSequences1(String s) {
		Set<String> result = new HashSet<String>();
		long currentNumber = 0;
		if (s.length() < 10) {
			return new ArrayList<String>(result);
		}
		for (int i = 0; i < 10; i++) {
			currentNumber = (currentNumber << 4)
					| (charMaps.get(s.charAt(i)) & 0xf);
		}
		numbers.add(currentNumber);
		for (int i = 10; i < s.length(); i++) {
			currentNumber = ((currentNumber << 4) & 0x000000fffffffff0l)
					| (charMaps.get(s.charAt(i)) & 0xf);
			if (numbers.contains(currentNumber)) {
				result.add(s.substring(i - 9, i + 1));
			} else {
				numbers.add(currentNumber);
			}
		}
		return new ArrayList<String>(result);
	}

	public List<String> findRepeatedDnaSequences2(String s) {
		Set<String> result = new HashSet<String>();
		if (s.length() < 10) {
			return new ArrayList<String>(result);
		}
		numberSets.add(s.substring(0, 10));
		for (int i = 10; i < s.length(); i++) {
			String currentNumber = s.substring(i - 9, i + 1);
			if (numberSets.contains(currentNumber)) {
				result.add(s.substring(i - 9, i + 1));
			} else {
				numberSets.add(currentNumber);
			}
		}
		return new ArrayList<String>(result);
	}

	public List<String> findRepeatedDnaSequences3(String s) {
		Set<String> result = new HashSet<String>();
		if (s.length() < 10) {
			return new ArrayList<String>(result);
		}
		for (int i = 0; i <= s.length() - 10; i++) {
			String currentNumber = s.substring(i, i + 10);
			if (numberSets.contains(currentNumber)) {
				result.add(s.substring(i, i + 10));
			} else {
				numberSets.add(currentNumber);
			}
		}
		return new ArrayList<String>(result);
	}

	public List<String> findRepeatedDnaSequences4(String s) {
		Set<Integer> words = new HashSet<>();
		Set<Integer> doubleWords = new HashSet<>();
		List<String> rv = new ArrayList<>();
		char[] map = new char[26];
		// map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		for (int i = 0; i < s.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];
			}
			if (!words.add(v) && doubleWords.add(v)) {
				rv.add(s.substring(i, i + 10));
			}
		}
		return rv;
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> result = new HashSet<String>();
		Set<String> numberSets = new HashSet<String>();
		if (s == null || s.length() < 10) {
			return new ArrayList<String>(result);
		}
		char[] chars = s.toCharArray();
		for (int i = 0; i <= s.length() - 10; i++) {
			String currentNumber = new String(chars, i, 10);
			if (numberSets.contains(currentNumber)) {
				result.add(currentNumber);
			} else {
				numberSets.add(currentNumber);
			}
		}
		return new ArrayList<String>(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s = "AAAAAAAAAAA";
		RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
		List<String> result = repeatedDNASequences.findRepeatedDnaSequences(s);
		for (String res : result) {
			System.out.println(res);
		}
	}

}
