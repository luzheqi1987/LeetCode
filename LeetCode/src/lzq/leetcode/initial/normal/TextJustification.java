package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class TextJustification {
	/**
	 * Given an array of words and a length L, format the text such that each
	 * line has exactly L characters and is fully (left and right) justified.
	 * 
	 * You should pack your words in a greedy approach; that is, pack as many
	 * words as you can in each line. Pad extra spaces ' ' when necessary so
	 * that each line has exactly L characters.
	 * 
	 * Extra spaces between words should be distributed as evenly as possible.
	 * If the number of spaces on a line do not divide evenly between words, the
	 * empty slots on the left will be assigned more spaces than the slots on
	 * the right.
	 * 
	 * For the last line of text, it should be left justified and no extra space
	 * is inserted between words.
	 * 
	 * For example, words: ["This", "is", "an", "example", "of", "text",
	 * "justification."] L: 16.
	 * 
	 * Return the formatted lines as: [ "This    is    an", "example  of text",
	 * "justification.  " ] Note: Each word is guaranteed not to exceed L in
	 * length.
	 * 
	 * @param words
	 * @param L
	 * @return
	 */
	public ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == words || words.length <= 0) {
			ArrayList<String> result = new ArrayList<String>();
			result.add("");
			return result;
		} else if (words.length == 1 && words[0].equals("") && L > 0) {
			ArrayList<String> result = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < L; i++) {
				sb.append(" ");
			}
			result.add(sb.toString());
			return result;
		}
		ArrayList<String> result = new ArrayList<String>();
		int groupNumber = 0;
		int groupLength = 0;
		int startWord = 0;
		for (int i = 0; i < words.length; i++) {
			if (groupLength + words[i].length() <= L) {
				groupLength += words[i].length() + 1;
				groupNumber++;
			} else {
				StringBuilder sb = new StringBuilder();
				int[] spaceNumber = new int[groupNumber - 1];
				if (groupNumber == 1) {
					sb.append(words[startWord]);
					for (int m = 0; m < L - words[startWord].length(); m++)
						sb.append(" ");
				} else {
					if (groupLength - 1 == L) {
						for (int j = 0; j < groupNumber - 1; j++) {
							spaceNumber[j] = 1;
						}
					} else {
						for (int j = 0; j < groupNumber - 1; j++) {
							spaceNumber[j] = (L - (groupLength - groupNumber))
									/ (groupNumber - 1);
						}
						for (int j = 0; j < (L - (groupLength - groupNumber))
								% (groupNumber - 1); j++) {
							spaceNumber[j] += 1;
						}
					}
					for (int j = startWord; j < startWord + groupNumber; j++) {
						sb.append(words[j]);
						if (startWord + groupNumber - 1 != j) {
							for (int m = 0; m < spaceNumber[j - startWord]; m++)
								sb.append(" ");
						}
					}
				}
				result.add(sb.toString());

				groupNumber = 0;
				groupLength = 0;
				startWord = i;
				i--;
			}
		}
		if (groupNumber != 0) {
			StringBuilder sb = new StringBuilder();
			for (int j = startWord; j < startWord + groupNumber; j++) {
				sb.append(words[j]);
				if (startWord + groupNumber - 1 != j) {
					sb.append(" ");
				}
			}
			if (sb.length() < L) {
				for (int m = sb.length(); m < L; m++) {
					sb.append(" ");
				}
			}
			result.add(sb.toString());
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TextJustification().fullJustify(
				new String[] { "a" }, 2));
	}

}
