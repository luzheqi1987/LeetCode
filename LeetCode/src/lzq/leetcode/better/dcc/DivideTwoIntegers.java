package lzq.leetcode.better.dcc;

public class DivideTwoIntegers {
	/**
	 * Divide two integers without using multiplication, division and mod
	 * operator.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (0 == dividend || 0 == divisor) {
			return 0;
		}
		boolean negative = (dividend > 0 && divisor < 0)
				|| (dividend < 0 && divisor > 0);

		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		long count = 0;

		while (ldividend >= ldivisor) {
			long tmpCount = 1;
			long tmpSum = ldivisor;
			while ((tmpSum << 1) < ldividend) {
				tmpCount <<= 1;
				tmpSum <<= 1;
			}
			count += tmpCount;
			ldividend -= tmpSum;
		}
		if (negative) {
			return (int) -count;
		} else {
			return (int) count;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DivideTwoIntegers().divide(-2147483648, -3));
	}

}
