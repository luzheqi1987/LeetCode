package lzq.leetcode.better.normal;

import java.util.ArrayList;
import java.util.List;

public class IntegertoRoman {
	/**
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				result.append(numerals[i]);
			}
		}
		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IntegertoRoman().intToRoman(465));
	}
}
