package lzq.leetcode.initial.normal;

public class AddBinary {

	/**
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * For example, a = "11" b = "1" Return "100".
	 */
	public String addBinary(String a, String b) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		char[] as = a.toCharArray();
		char[] bs = b.toCharArray();
		int i = as.length - 1;
		int j = bs.length - 1;
		int c = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >= 0) {
			if (0 == c) {
				if ((as[i] == '0' && bs[j] == '1')
						|| (as[i] == '1' && bs[j] == '0')) {
					sb = sb.insert(0, '1');
					c = 0;
				} else if ((as[i] == '0' && bs[j] == '0')) {
					sb = sb.insert(0, '0');
					c = 0;
				} else {
					sb = sb.insert(0, '0');
					c = 1;
				}
			} else if (1 == c) {
				if ((as[i] == '0' && bs[j] == '1')
						|| (as[i] == '1' && bs[j] == '0')) {
					sb = sb.insert(0, '0');
					c = 1;
				} else if ((as[i] == '0' && bs[j] == '0')) {
					sb = sb.insert(0, '1');
					c = 0;
				} else {
					sb = sb.insert(0, '1');
					c = 1;
				}
			}
			i--;
			j--;
		}
		while (i >= 0) {
			if (0 == c) {
				sb = sb.insert(0, as[i]);
				c = 0;

			} else if (1 == c) {
				if (as[i] == '0') {
					sb = sb.insert(0, '1');
					c = 0;
				} else {
					sb = sb.insert(0, '0');
					c = 1;
				}
			}
			i--;
		}
		while (j >= 0) {
			if (0 == c) {
				sb = sb.insert(0, bs[i]);
				c = 0;

			} else if (1 == c) {
				if (bs[j] == '0') {
					sb = sb.insert(0, '1');
					c = 0;
				} else {
					sb = sb.insert(0, '0');
					c = 1;
				}
			}
			j--;
		}
		if (1 == c) {
			sb = sb.insert(0, '1');
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new AddBinary().addBinary("1", "111"));
	}

}
