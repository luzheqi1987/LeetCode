package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class ZigZagConversion {
	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	 *
	 * P   A   H   N
	 * A P L S I I G
	 * Y   I   R
	 * And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a number of rows:
	 *
	 * string convert(string text, int nRows);
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(nRows == 1){
			return s;
		}
		ArrayList<ArrayList<Character>> charLists = new ArrayList<ArrayList<Character>>();
		for (int i = 0; i < nRows; i++) {
			charLists.add(new ArrayList<Character>());
		}
		char[] cs = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (i % (nRows - 1) == 0) {
				int j = 0;
				for (j = i; j < cs.length && j < i + nRows; j++) {
					charLists.get(j - i).add(cs[j]);
				}
				i = j - 1;
			} else {
				int row = charLists.size() - 1 - i % (nRows - 1);
				charLists.get(row).add(cs[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Character> charList : charLists) {
			for (char c : charList) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
	}

}
