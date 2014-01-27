package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
	/**
	 * Given two numbers represented as strings, return multiplication of the
	 * numbers as a string.
	 * 
	 * Note: The numbers can be arbitrarily large and are non-negative.
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		char[] num1s = num1.toCharArray();
		char[] num2s = num2.toCharArray();
		List<Character> result = new ArrayList<Character>();

		for (int i = num2s.length - 1; i >= 0; i--) {
			int num = 0;
			ArrayList<Character> line = new ArrayList<Character>();
			for (int j = num1s.length - 1; j >= 0; j--) {
				int tmp = Character.digit(num1s[j], 10)
						* Character.digit(num2s[i], 10) + num;
				int ge = tmp % 10;
				num = tmp / 10;
				line.add(0, Character.forDigit(ge, 10));
			}
			if (num > 0) {
				line.add(0, Character.forDigit(num, 10));
			}
			if (num2s.length - 1 == i) {
				result.addAll(line);
			} else {
				int nu = 0;
				int n = 0;
				int m = 0;
				for (m = result.size() - 1 - (num2s.length - 1 - i), n = line
						.size() - 1; m >= 0 && n >= 0; m--, n--) {
					int tmp = Character.digit(result.get(m), 10)
							+ Character.digit(line.get(n), 10) + nu;
					int ge = tmp % 10;
					result.set(m, Character.forDigit(ge, 10));
					nu = tmp / 10;
				}
				if (n >= 0 || nu > 0) {
					for (; n >= 0; n--) {
						int tmp = Character.digit(line.get(n), 10) + nu;
						int ge = tmp % 10;
						result.add(0, Character.forDigit(ge, 10));
						nu = tmp / 10;
					}
					if (nu > 0) {
						result.add(0, Character.forDigit(nu, 10));
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MultiplyStrings().multiply("3", "38"));
	}

}
