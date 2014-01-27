package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
	/**
	 * Given a collection of integers that might contain duplicates, S, return
	 * all possible subsets.
	 * 
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. For example, If S = [1,2,2], a
	 * solution is:
	 * 
	 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
	 * 
	 * @param S
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == S || S.length <= 0) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			result.add(new ArrayList<Integer>());
			return result;
		}
		Arrays.sort(S);
		ArrayList<Integer> sList = new ArrayList<Integer>();
		for (int i = 0; i < S.length; i++) {
			sList.add(S[i]);
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < S.length; i++) {
			ArrayList<Integer> element = new ArrayList<Integer>();
			element.add(S[i]);
			if (!result.contains(element)) {
				result.add(element);
			}
		}
		int start = 0;
		int end = result.size();
		for (int num = 2; num <= S.length; num++) {
			for (int i = start; i < end; i++) {
				ArrayList<Integer> oldElement = result.get(i);
				int j = sList.indexOf(oldElement.get(oldElement.size() - 1)) + 1;
				if (oldElement.size() > 1) {
					for (int m = oldElement.size() - 2; m >= 0; m--) {
						if (oldElement.get(m) == oldElement.get(oldElement
								.size() - 1)) {
							j++;
						} else {
							break;
						}
					}
				}
				for (; j < S.length; j++) {
					ArrayList<Integer> element = new ArrayList<Integer>();
					element.addAll(oldElement);
					element.add(S[j]);
					if (!result.contains(element)) {
						result.add(element);
					}
				}
			}
			start = end;
			end = result.size();
		}
		result.add(new ArrayList<Integer>());
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = { 1, 2, 2, 2 };
		ArrayList<ArrayList<Integer>> result = new SubsetsII()
				.subsetsWithDup(is);
		System.out.println(result);
	}

}
