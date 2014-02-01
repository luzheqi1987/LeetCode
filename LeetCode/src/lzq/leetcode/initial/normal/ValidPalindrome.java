package lzq.leetcode.initial.normal;

public class ValidPalindrome {
	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 * 
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == s) {
			return false;
		}
		if (s.length() <= 1) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char a = s.charAt(i);
			char b = s.charAt(j);
			if (a < '0' || (a > '9' && a < 'A') || (a > 'Z' && a < 'a')
					|| a > 'z') {
				i++;
				continue;
			}
			if (b < '0' || (b > '9' && b < 'A') || (b > 'Z' && b < 'a')
					|| b > 'z') {
				j--;
				continue;
			}
			if (a == b || ((a < b) && (a + 32 == b))
					|| ((a > b) && (a - 32 == b))) {
				i++;
				j--;
			} else {
				break;
			}
		}
		if (i < j) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('a' - 'A');
		System.out.println(new ValidPalindrome().isPalindrome("1a2"));
	}

}
