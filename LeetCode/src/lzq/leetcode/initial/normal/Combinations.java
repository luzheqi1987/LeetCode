package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {
	/**
	 * Given two integers n and k, return all possible combinations of k numbers
	 * out of 1 ... n.
	 * 
	 * For example, If n = 4 and k = 2, a solution is:
	 * 
	 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < k) {
			return null;
		}

		ArrayList<Integer> sList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			sList.add(i);
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> element = new ArrayList<Integer>();
			element.add(i);
			result.add(element);
		}
		int start = 0;
		int end = result.size();
		for (int num = 2; num <= k; num++) {
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
			for (int i = start; i < end; i++) {
				ArrayList<Integer> oldElement = result.get(i);
				for (int j = sList
						.indexOf(oldElement.get(oldElement.size() - 1)) + 2; j <= n; j++) {
					ArrayList<Integer> element = new ArrayList<Integer>();
					element.addAll(oldElement);
					element.add(j);
					tmp.add(element);
				}
			}
			result.clear();
			result.addAll(tmp);
			start = 0;
			end = result.size();
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
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
			result.add(element);
		}
		int start = 0;
		int end = result.size();
		for (int num = 2; num <= S.length; num++) {
			for (int i = start; i < end; i++) {
				ArrayList<Integer> oldElement = result.get(i);
				for (int j = sList
						.indexOf(oldElement.get(oldElement.size() - 1)) + 1; j < S.length; j++) {
					ArrayList<Integer> element = new ArrayList<Integer>();
					element.addAll(oldElement);
					element.add(S[j]);
					result.add(element);
				}
			}
			start = end;
			end = result.size();
		}
		result.add(new ArrayList<Integer>());
		return result;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = { 1, 2, 3, 4 };
		ArrayList<ArrayList<Integer>> result = new Combinations().combine(4, 4);
		System.out.println(result);
	}

}
