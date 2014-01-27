package lzq.leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String regExp = "[ ]*[+|-]{0,1}([0-9]+\\.{0,1}|([0-9]*\\.[0-9]+))(e[+|-]{0,1}[0-9]+){0,1}[ ]*";
		return s.matches(regExp);
		// if (null == s || "".equals(s)) {
		// return true;
		// }
		// char[] cs = s.toCharArray();
		// int dot = 0;
		// int e = 0;
		// int i = 0;
		// boolean hasNumber = false;
		// while (i < cs.length && cs[i] == ' ') {
		// i++;
		// }
		//
		// if (i > cs.length - 1) {
		// return false;
		// }
		//
		// if (cs[i] == '-' || cs[i] == '+') {
		// i++;
		// }
		// for (; i < cs.length; i++) {
		// if (cs[i] == '.') {
		// dot++;
		// if (dot > 1 || e >= 1) {
		// return false;
		// } else if (i == cs.length - 1 && !hasNumber) {
		// return false;
		// }
		// } else if (cs[i] == ' ') {
		// if (i > 0 && (cs[i - 1] < '0' || cs[i - 1] > '9')
		// && cs[i - 1] != '.') {
		// return false;
		// }
		// while (i < cs.length && cs[i] == ' ') {
		// i++;
		// }
		// if (i > cs.length - 1 && hasNumber) {
		// return true;
		// } else {
		// return false;
		// }
		// } else if (cs[i] == 'e' || cs[i] == 'E') {
		// e++;
		// if (e > 1) {
		// return false;
		// } else if (i == cs.length - 1 || !hasNumber) {
		// return false;
		// }
		// if (i + 1 < cs.length && (cs[i + 1] == '-' || cs[i + 1] == '+')) {
		// if (i + 1 == cs.length - 1) {
		// return false;
		// }
		// i++;
		// }
		// } else if (cs[i] < '0' || cs[i] > '9') {
		// return false;
		// } else {
		// hasNumber = true;
		// }
		// }
		// return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidNumber().isNumber("."));
	}

}
