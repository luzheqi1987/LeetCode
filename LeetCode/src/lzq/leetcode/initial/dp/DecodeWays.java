package lzq.leetcode.initial.dp;

public class DecodeWays {
	/**
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
	 * digits, determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 * 
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s || "".equals(s)) {
			return 0;
		}
		int[] num = new int[s.length() + 1];
		char[] cs = s.toCharArray();
		num[0] = 1;
		if (cs[0] > '0') {
			num[1] = 1;
		} else {
			num[1] = 0;
		}
		for (int i = 2; i < s.length() + 1; i++) {
			int num1 = 0;
			int num2 = 0;
			if (cs[i - 1] != '0') {
				num1 = num[i - 1];
			}
			if (cs[i - 2] == '1') {
				num2 = num[i - 2];
			} else if (cs[i - 2] == '2'
					&& (cs[i - 1] >= '0' && cs[i - 1] <= '6')) {
				num2 = num[i - 2];
			}
			num[i] = num1 + num2;
		}
		return num[s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "301";
		int num = new DecodeWays().numDecodings(s);

		System.out.println(num);
	}

}
