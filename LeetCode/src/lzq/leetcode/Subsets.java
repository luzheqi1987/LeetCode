package lzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = { 1, 2, 3, 4 };
		ArrayList<ArrayList<Integer>> result = new Subsets().subsets(is);
		System.out.println(result);
	}

}
