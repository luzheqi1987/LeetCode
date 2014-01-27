package lzq.leetcode.initial.normal;

public class LengthofLastWord {
	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, Given s = "Hello World", return 5.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		char[] cs = s.toCharArray();
		int lastLength = 0;
		int length = 0;
		for (int i = 0; i < cs.length; i++) {
			if ((cs[i] >= 'A' && cs[i] <= 'Z')
					|| (cs[i] >= 'a' && cs[i] <= 'z')) {
				length++;
			} else {
				if (length != 0) {
					lastLength = length;
				}
				length = 0;
			}
		}
		if (length != 0) {
			lastLength = length;
		}
		return lastLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "b a    ";
		System.out.println(new LengthofLastWord().lengthOfLastWord(s));
	}

}
