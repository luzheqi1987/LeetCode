package lzq.leetcode.initial.knack;

public class ImplementstrStr {
	/**
	 * Implement strStr().
	 * 
	 * Returns a pointer to the first occurrence of needle in haystack, or null
	 * if needle is not part of haystack.
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (haystack.equals(needle)) {
			return haystack;
		}
		int index = KMP(haystack, needle);
		if (index == -1) {
			return null;
		}
		return haystack.substring(index);
	}

	int[] getNext(String s) {
		int j = 0, k = -1;
		char[] cs = s.toCharArray();
		int[] next = new int[cs.length];
		next[0] = -1;
		for (; j < cs.length;) {
			if (k == -1 || cs[j] == cs[k]) {
				++j;
				++k;
				if (j >= cs.length) {
					continue;
				}
				if (cs[j] != cs[k])
					next[j] = k;
				else
					next[j] = next[k];
			} else
				k = next[k];
		}
		return next;
	}

	int KMP(String s, String t) {
		if (null == s || null == t || "".equals(t))
			return 0;
		int[] next = getNext(t);

		int index = 0, i = 0, j = 0;
		char[] ss = s.toCharArray();
		char[] ts = t.toCharArray();

		while (i < ss.length && j < ts.length) {
			if (ss[i] == ts[j]) {
				++i;
				++j;
			} else {
				index += j - next[j];
				if (next[j] != -1)
					j = next[j];
				else {
					j = 0;
					++i;
				}
			}
		}
		if (j >= ts.length) {
			return index;
		} else {
			return -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(new ImplementstrStr().strStr("mississippi", "issip"));
	}

}
