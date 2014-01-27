package lzq.leetcode.better.recursion;

import java.util.ArrayList;

public class GenerateParentheses {
	/**
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 * 
	 * @param n
	 * @return
	 */
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// (()) ()()
		ArrayList<String> results = new ArrayList<String>();
		dfs(results, "", 0, 0, n);
		return results;
	}

	void dfs(ArrayList<String> results, String tmp, int right, int left, int n) {
		if (left == n) {
			for (int i = right; i < n; i++) {
				tmp += ")";
			}
			results.add(tmp);
			return;
		}
		dfs(results, tmp + "(", right, left + 1, n);
		if (right < left) {
			dfs(results, tmp + ")", right + 1, left, n);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GenerateParentheses().generateParenthesis(2));
	}

}
