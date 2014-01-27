package lzq.leetcode.initial.recursion;

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
		return dfs(0, n, n);
	}

	ArrayList<String> dfs(int right, int left, int n) {
		if (0 == left) {
			ArrayList<String> results = new ArrayList<String>();
			String str = "";
			for (int i = 0; i < n - right; i++) {
				str += ")";
			}
			results.add(str);
			return results;
		}
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 0; i <= n - left - right; i++) {
			for (int j = 1; j <= 1; j++) {
				ArrayList<String> strs = dfs(i + right, left - j, n);
				for (String str : strs) {
					for (int k = 1; k <= j; k++) {
						str = "(" + str;
					}
					for (int k = 0; k < i; k++) {
						str = ")" + str;
					}
					results.add(new String(str));
				}
			}
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GenerateParentheses().generateParenthesis(2));
	}

}
