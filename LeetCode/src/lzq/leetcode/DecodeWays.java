package lzq.leetcode;

public class DecodeWays {
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
