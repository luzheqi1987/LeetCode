package lzq.leetcode;

import java.util.ArrayList;

public class ZigZagConversion {
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
		System.out.println(new ZigZagConversion().convert("A", 2));
	}

}
