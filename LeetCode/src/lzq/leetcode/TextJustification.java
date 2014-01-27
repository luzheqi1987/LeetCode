package lzq.leetcode;

import java.util.ArrayList;

public class TextJustification {
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
