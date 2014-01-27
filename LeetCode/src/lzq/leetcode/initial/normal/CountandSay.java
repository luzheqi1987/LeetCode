package lzq.leetcode.initial.normal;

public class CountandSay {
	/**
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 1, 11, 21, 1211, 111221, ...
	 * 
	 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
	 * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
	 * nth sequence.
	 * 
	 * Note: The sequence of integers will be represented as a string.
	 * 
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (n <= 0) {
			return "";
		}
		String string = null;
		for (int i = 1; i <= n; i++) {
			if (1 == i) {
				string = "1";
			} else {
				char[] cs = string.toCharArray();
				char tmp = cs[0];
				int tmpnum = 1;
				StringBuilder sb = new StringBuilder();
				for (int j = 1; j < cs.length; j++) {
					if (cs[j] == tmp) {
						tmpnum++;
					} else {
						sb.append(tmpnum);
						sb.append(tmp);
						tmp = cs[j];
						tmpnum = 1;
					}
				}
				sb.append(tmpnum);
				sb.append(tmp);
				string = null;
				string = sb.toString();
			}
		}
		return string;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountandSay().countAndSay(7));
	}

}
