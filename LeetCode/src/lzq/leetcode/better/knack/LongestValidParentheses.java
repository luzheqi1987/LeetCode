package lzq.leetcode.better.knack;

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
	/**
	 * 这个解法里面的stack，不是用来存左右括号的，是来存左括号的index。遍历S。遇到'('，放入lefts
	 * 。如果遇到')'，如果lefts是空，说明这是一个无法匹配的')'，记录下last。last里面存放的其实是最后一个无法匹配的')'。
	 * 为啥要保存这个值呢？主要是为了计算后面完整的表达式的长度。可以这样理解： “所有无法匹配的')'”的index其实都是各个group的分界点。
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
		Stack<Integer> stack = new Stack<Integer>();
		int last = -1;
		int max = 0;
		for (int i = 0; i < cs.length; i++) {
			if ('(' == cs[i]) {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - last);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
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
		System.out.println(new LongestValidParentheses()
				.longestValidParentheses("()(()"));
	}

}
