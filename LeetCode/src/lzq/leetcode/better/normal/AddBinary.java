package lzq.leetcode.better.normal;

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
		StringBuilder sb = new StringBuilder("");
		// include all cases
		while (i >= 0 || j >= 0 || c > 0) {
			int v = c;
			if (i >= 0) {
				// better than Character.Fordigit
				v += as[i] - '0';
			}
			if (j >= 0) {
				v += bs[j] - '0';
			}
			// calculate carry
			c = v >> 1;
			
			// insert to head
			sb.insert(0, '0' + v & 1);
			i--;
			j--;
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
