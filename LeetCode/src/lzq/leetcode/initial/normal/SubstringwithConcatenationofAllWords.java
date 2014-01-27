package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	/**
	 * You are given a string, S, and a list of words, L, that are all of the
	 * same length. Find all starting indices of substring(s) in S that is a
	 * concatenation of each word in L exactly once and without any intervening
	 * characters.
	 * 
	 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
	 * 
	 * You should return the indices: [0,9]. (order does not matter).
	 * 
	 * @param S
	 * @param L
	 * @return
	 */
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		ArrayList<Integer> starts = new ArrayList<Integer>();
		int wordLength = L[0].length();
		int wordNumber = L.length;
		int allLength = wordLength * wordNumber;
		for (String l : L) {
			if (wordMap.containsKey(l)) {
				int num = wordMap.get(l);
				wordMap.put(l, num + 1);
			} else {
				wordMap.put(l, 1);
			}
		}
		for (int i = 0; i <= S.length() - allLength; i++) {
			Map<String, Integer> tmpWordMap = new HashMap<String, Integer>();
			boolean flag = true;
			for (int k = i, curWordNum = 0; curWordNum < wordNumber; k += wordLength, curWordNum++) {
				String tmpStr = S.substring(k, k + wordLength);
				if (tmpWordMap.containsKey(tmpStr)) {
					int number = tmpWordMap.get(tmpStr);
					tmpWordMap.put(tmpStr, number + 1);
				} else {
					tmpWordMap.put(tmpStr, 1);
				}
				if (!wordMap.containsKey(tmpStr)
						|| tmpWordMap.get(tmpStr) > wordMap.get(tmpStr)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				starts.add(i);
			}
		}
		return starts;
	}

	// void dfs(ArrayList<ArrayList<Integer>> results, Set<Integer> set, int i,
	// ArrayList<Integer> starts, String[] L, int length, String S) {
	// if (i > S.length()) {
	// return;
	// }
	// if (set.size() >= L.length) {
	// if (starts.contains(i - length)) {
	// return;
	// }
	// starts.add(i - length);
	// return;
	// }
	// for (int m = 0; m < results.size(); m++) {
	// ArrayList<Integer> result = results.get(m);
	// if (result.contains(i) && !set.contains(m)) {
	// set.add((Integer) m);
	// dfs(results, set, i + L[m].length(), starts, L, length, S);
	// set.remove((Integer) m);
	// }
	// }
	// }
	//
	// int[] getNext(String s) {
	// int j = 0, k = -1;
	// char[] cs = s.toCharArray();
	// int[] next = new int[cs.length];
	// next[0] = -1;
	// for (; j < cs.length; j++) {
	// if (k == -1 || cs[j] == cs[k]) {
	// ++j;
	// ++k;
	// if (j >= cs.length) {
	// continue;
	// }
	// if (cs[j] != cs[k])
	// next[j] = k;
	// else
	// next[j] = next[k];
	// } else
	// k = next[k];
	// }
	// return next;
	// }
	//
	// ArrayList<Integer> KMP(String s, String t) // const 表示函数内部不会改变这个参数的值。
	// {
	// if (null == s || null == t || "".equals(s) || "".equals(t))
	// return new ArrayList<Integer>();
	// int[] next = getNext(t);
	//
	// int index = 0, i = 0, j = 0;
	// char[] ss = s.toCharArray();
	// char[] ts = t.toCharArray();
	// ArrayList<Integer> starts = new ArrayList<Integer>();
	// while (i < ss.length) {
	// while (i < ss.length && j < ts.length) {
	// if (ss[i] == ts[j]) {
	// ++i;
	// ++j;
	// } else {
	// index += j - next[j];
	// if (next[j] != -1)
	// j = next[j];// 模式串向右移动
	// else {
	// j = 0;
	// ++i;
	// }
	// }
	// }
	// if (j >= ts.length) {
	// starts.add(index);
	// j = 0;
	// index = i;
	// }
	// }
	// return starts;
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] L = { "fooo", "barr", "wing", "ding", "wing" };
		ArrayList<Integer> result = new SubstringwithConcatenationofAllWords()
				.findSubstring(S, L);
		System.out.println(result);
	}

}
