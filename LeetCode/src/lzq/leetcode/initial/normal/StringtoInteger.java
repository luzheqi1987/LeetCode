package lzq.leetcode.initial.normal;

public class StringtoInteger {
	/**
	 * Implement atoi to convert a string to an integer.
	 * 
	 * Hint: Carefully consider all possible input cases. If you want a
	 * challenge, please do not see below and ask yourself what are the possible
	 * input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no
	 * given input specs). You are responsible to gather all the input
	 * requirements up front.
	 * 
	 * spoilers alert... click to show requirements for atoi.
	 * 
	 * @param str
	 * @return
	 */
	public int atoi(String str) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == str || "".equals(str)) {
			return 0;
		}
		char[] strs = str.toCharArray();
		int begin = 0;
		boolean ism = false;
		while (begin < strs.length && strs[begin] == ' ') {
			begin++;
		}
		if (begin >= strs.length) {
			return 0;
		}
		if (strs[begin] == '+') {
			begin++;
		} else if (strs[begin] == '-') {
			ism = true;
			begin++;
		}
		long number = 0;
		for (int i = begin; i < strs.length; i++) {
			if (strs[i] < '0' || strs[i] > '9') {
				if (i == begin) {
					return 0;
				} else {
					break;
				}
			} else {
				number = Character.digit(strs[i], 10) + 10 * number;
				if (!ism && number > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (ism && number - 1 > Integer.MAX_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
		}
		if (ism) {
			number = -number;
		}
		return (int) number;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringtoInteger().atoi("     -2131+412"));
	}

}
