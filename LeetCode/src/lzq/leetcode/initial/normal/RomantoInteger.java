package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
	static Map<Character, Integer> r2a = new HashMap<Character, Integer>();

	static {
		r2a.put('I', 1);
		r2a.put('V', 5);
		r2a.put('X', 10);
		r2a.put('L', 50);
		r2a.put('C', 100);
		r2a.put('D', 500);
		r2a.put('M', 1000);
	}

	/**
	 * Given a roman numeral, convert it to an integer.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] cs = s.toCharArray();
		int num = 0;
		int tmp = 0;
		int tmpStep = -1;
		for (char c : cs) {
			int ttmp = r2a.get(c);
			if (-1 == tmpStep) {
				tmpStep = ttmp;
				tmp = ttmp;
			} else if (ttmp == tmpStep) {
				tmp += ttmp;
			} else if (ttmp > tmpStep) {
				tmp = ttmp - tmp;
				num += tmp;
				tmp = 0;
				tmpStep = -1;
			} else if (ttmp < tmpStep) {
				num += tmp;
				tmpStep = ttmp;
				tmp = ttmp;
			}
		}
		num += tmp;
		return num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RomantoInteger().romanToInt("DCXXI"));
	}

}
