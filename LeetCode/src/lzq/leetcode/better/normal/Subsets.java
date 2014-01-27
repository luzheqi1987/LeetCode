package lzq.leetcode.better.normal;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	/**
	 * Given a set of distinct integers, S, return all possible subsets.
	 * 
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. For example, If S = [1,2,3], a
	 * solution is:
	 * 
	 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
	 * 
	 * 
	 * @param S
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> sList = new ArrayList<ArrayList<Integer>>();
		sList.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			int oldLen = sList.size();
			for (int j = 0; j < oldLen; j++) {
				ArrayList<Integer> result = new ArrayList<Integer>(sList.get(j));
				result.add(S[i]);
				sList.add(result);
			}
		}
		return sList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = { 1, 2, 3, 4 };
		ArrayList<ArrayList<Integer>> result = new Subsets().subsets(is);
		System.out.println(result);
	}

}
