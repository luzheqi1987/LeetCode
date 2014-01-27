package lzq.leetcode.initial.recursion;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {
	static char[][] cdigits = { { ' ' }, {}, { 'a', 'b', 'c' },
			{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
			{ 'w', 'x', 'y', 'z' } };

	/**
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * 
	 * 
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
	 * "cd", "ce", "cf"]. Note: Although the above answer is in lexicographical
	 * order, your answer could be in any order you want.
	 * 
	 * @param digits
	 * @return
	 */
	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == digits || "".equals(digits)) {
			ArrayList<String> results = new ArrayList<String>();
			String str = "";
			results.add(str);
			return results;
		}
		return dfs(digits, 0);
	}

	ArrayList<String> dfs(String digits, int i) {
		if (i >= digits.length()) {
			return new ArrayList<String>();
		}
		int a = Character.digit(digits.charAt(i), 10);
		if (1 == a) {
			return dfs(digits, i + 1);
		}
		ArrayList<String> results = new ArrayList<String>();
		for (int j = 0; j < cdigits[a].length; j++) {
			char c = cdigits[a][j];
			ArrayList<String> tmps = dfs(digits, i + 1);
			if (tmps.isEmpty()) {
				results.add(new StringBuilder().append(c).toString());
			} else {
				for (String str : tmps) {
					str = c + str;
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
		System.out.println(new LetterCombinationsofaPhoneNumber()
				.letterCombinations("1203"));
	}

}
