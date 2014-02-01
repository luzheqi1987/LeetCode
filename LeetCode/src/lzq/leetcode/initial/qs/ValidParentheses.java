package lzq.leetcode.initial.qs;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		char[] ss = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char c : ss) {
			if ('(' == c || '{' == c || '[' == c) {
				stack.add(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (')' == c && stack.pop() != '(') {
					return false;
				} else if (']' == c && stack.pop() != '[') {
					return false;
				} else if ('}' == c && stack.pop() != '{') {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidParentheses().isValid("([)]"));
	}

}
