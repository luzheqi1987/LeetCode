package lzq.leetcode.initial.normal;

import java.util.Stack;

public class LongestValidParentheses {
	/**
	 * Given a string containing just the characters '(' and ')', find the
	 * length of the longest valid (well-formed) parentheses substring.
	 * 
	 * For "(()", the longest valid parentheses substring is "()", which has
	 * length = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses
	 * substring is "()()", which has length = 4.
	 * 
	 * Discuss
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (s.length() <= 1) {
			return 0;
		}
		char[] cs = s.toCharArray();
		Stack<Object> stack = new Stack<Object>();
		int max = 0;
		for (char c : cs) {
			if (c == ')') {
				if (stack.isEmpty()) {
					continue;
				} else {
					Object pc = stack.pop();
					int tmp = 0;
					while (!(pc instanceof Character) && !stack.isEmpty()) {
						tmp += (Integer) pc;
						pc = stack.pop();
					}
					if (pc instanceof Character) {
						stack.add(tmp + 2);
					} else {
						if (tmp + (Integer) pc > max) {
							max = tmp + (Integer) pc;
						}
					}
				}
			} else {
				stack.push(c);
			}
		}
		int tmp = 0;
		while (!stack.isEmpty()) {
			Object pc = stack.pop();
			if (!(pc instanceof Character)) {
				tmp += (Integer) pc;
			} else {
				if (tmp > max) {
					max = tmp;
				}
				tmp = 0;
			}
		}
		if (tmp > max) {
			max = tmp;
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestValidParentheses()
				.longestValidParentheses(")(((((()())()()))()(()))("));
	}

}
