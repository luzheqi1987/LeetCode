package lzq.leetcode.initial.qs;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	/**
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation.
	 * 
	 * Valid operators are +, -, *, /. Each operand may be an integer or another
	 * expression.
	 * 
	 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4",
	 * "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 * 
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		Stack<Integer> numbers = new Stack<Integer>();
		for (String token : tokens) {
			if (token.equals("+") || token.equals("-") || token.equals("*")
					|| token.equals("/")) {
				int number2 = numbers.pop();
				int number1 = numbers.pop();
				if (token.equals("+")) {
					numbers.push(number1 + number2);
				}
				if (token.equals("-")) {
					numbers.push(number1 - number2);
				}
				if (token.equals("*")) {
					numbers.push(number1 * number2);
				}
				if (token.equals("/")) {
					numbers.push(number1 / number2);
				}
			} else {
				numbers.push(Integer.valueOf(token));
			}
		}
		return numbers.pop();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
