package lzq.leetcode.initial.normal;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringsinWraparoundString {

	public int findSubstringInWraproundString1(String p) {
		if (p == null || p.length() <= 0) {
			return 0;
		}
		int sum = 0;
		Set<String> alreadyContain = new HashSet<>();
		char[] cs = p.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			String cstr = p.substring(i, i + 1);
			if (!alreadyContain.contains(cstr)) {
				alreadyContain.add(cstr);
				sum++;
			}
			for (int j = i + 1; j < cs.length; j++) {
				if (cs[j] - cs[j - 1] == 1
						|| (cs[j - 1] == 'z' && cs[j] == 'a')) {
					String csstr = p.substring(i, j + 1);
					if (!alreadyContain.contains(csstr)) {
						alreadyContain.add(csstr);
						sum++;
					}
				} else {
					break;
				}
			}
		}
		return sum;
	}

	public int findSubstringInWraproundString(String p) {
		// count[i] is the maximum unique substring end with ith letter.
		// 0 - 'a', 1 - 'b', ..., 25 - 'z'.
		int[] count = new int[26];

		// store longest contiguous substring ends at current position.
		int maxLengthCur = 0;

		for (int i = 0; i < p.length(); i++) {
			if (i > 0
					&& (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1)
							- p.charAt(i) == 25))) {
				maxLengthCur++;
			} else {
				maxLengthCur = 1;
			}

			int index = p.charAt(i) - 'a';
			count[index] = Math.max(count[index], maxLengthCur);
		}

		// Sum to get result
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += count[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		String str = "abcde";
		UniqueSubstringsinWraparoundString uniqueSubstringsinWraparoundString = new UniqueSubstringsinWraparoundString();
		System.out
				.println(uniqueSubstringsinWraparoundString
						.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
	}

}
