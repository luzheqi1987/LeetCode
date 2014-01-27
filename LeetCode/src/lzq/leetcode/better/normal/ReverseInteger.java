package lzq.leetcode.better.normal;

public class ReverseInteger {
	/**
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * click to show spoilers.
	 * 
	 * Have you thought about this? Here are some good questions to ask before
	 * coding. Bonus points for you if you have already thought through this!
	 * 
	 * If the integer's last digit is 0, what should the output be? ie, cases
	 * such as 10, 100.
	 * 
	 * Did you notice that the reversed integer might overflow? Assume the input
	 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should
	 * you handle such cases?
	 * 
	 * Throw an exception? Good, but what if throwing an exception is not an
	 * option? You would then have to re-design the function (ie, add an extra
	 * parameter).
	 * 
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x >= -9 && x <= 9) {
			return x;
		}
		int flag = (x > 0) ? 1 : -1;
		int result = 0;
		x = Math.abs(x);
		while (x > 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		return flag * result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseInteger().reverse(1000000003));
	}

}
