package lzq.leetcode.initial.normal;

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
		boolean ism = x < 0;
		if (ism) {
			x = -x;
		}
		long lx = (long) x;
		int length = 0;
		while (lx > 0) {
			length++;
			lx = lx / 10;
		}
		lx = (long) x;
		for (int i = 0; i <= (length + 1) / 2 - 1; i++) {
			int first = x / (int) Math.pow(10, i) % 10;
			int second = x / (int) Math.pow(10, length - 1 - i) % 10;
			lx = lx - (long) first * (int) Math.pow(10, i);
			lx = lx - (long) second * (int) Math.pow(10, length - 1 - i);
			lx = lx + (long) first * (int) Math.pow(10, length - 1 - i);
			lx = lx + (long) second * (int) Math.pow(10, i);
			if (!ism && lx > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if (ism && lx - 1 > Integer.MAX_VALUE) {
				return Integer.MIN_VALUE;
			}
		}
		return (int) (ism ? -lx : lx);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseInteger().reverse(1000000003));
	}

}
