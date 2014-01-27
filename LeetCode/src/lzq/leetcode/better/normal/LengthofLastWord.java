package lzq.leetcode.better.normal;

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
	// FIX why code seans better, but time worse!!
	public int lengthOfLastWord(String s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		char[] cs = s.toCharArray();
		int length = 0;
		for (int i = cs.length - 1; i >= 0; i--) {
			if (' ' == cs[i] && 0 == length) {
				continue;
			}
			if ((cs[i] >= 'A' && cs[i] <= 'Z')
					|| (cs[i] >= 'a' && cs[i] <= 'z')) {
				length++;
			} else {
				break;
			}
		}
		return length;
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
