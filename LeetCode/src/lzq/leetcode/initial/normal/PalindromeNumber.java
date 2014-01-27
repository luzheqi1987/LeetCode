package lzq.leetcode.initial.normal;

public class PalindromeNumber {
	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0) {
			return false;
		} else if (x >= 0 && x <= 9) {
			return true;
		}
		int num = x;
		int length = 0;
		while (num > 0) {
			length++;
			num = num / 10;
		}
		for (int i = 0; i <= (length + 1) / 2 - 1; i++) {
			if ((x / (int) Math.pow(10, i) % 10) != (x
					/ (int) Math.pow(10, length - 1 - i) % 10)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromeNumber().isPalindrome(1234454321));
	}

}
