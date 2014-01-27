package lzq.leetcode.initial.dcc;

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
		if (divisor == 1) {
			return dividend;
		} else if (divisor == -1) {
			return -dividend;
		} else if (Math.abs(divisor) == 2) {
			int number = dividend >> 1;
			if (divisor < 0) {
				return -number;
			}
			return number;
		}
		long ldividend = 0L;
		long ldivisor = 0L;
		boolean isDividendFuShu = false;
		boolean isDivisorFuShu = false;
		if (divisor < 0) {
			isDivisorFuShu = true;
			ldivisor = Math.abs((long) divisor);
		} else {
			ldivisor = divisor;
		}
		if (dividend < 0) {
			isDividendFuShu = true;
			ldividend = Math.abs((long) dividend);
		} else {
			ldividend = dividend;
		}
		long start = 0l;
		long end = ldividend;
		while (start < end - 1) {
			long mid = start + (end - start) / 2;
			long tmpNumber = add(mid, ldivisor);
			if (tmpNumber < ldividend) {
				start = mid;
			} else if (tmpNumber > ldividend) {
				end = mid;
			} else {
				if ((isDividendFuShu && !isDivisorFuShu)
						|| (!isDividendFuShu && isDivisorFuShu)) {
					return -(int) mid;
				} else {
					return (int) mid;
				}
			}
		}

		if ((isDividendFuShu && !isDivisorFuShu)
				|| (!isDividendFuShu && isDivisorFuShu)) {
			return -(int) start;
		} else {
			return (int) start;
		}
	}

	long add(long p, long num) {
		if (0 == p) {
			return 0;
		}
		long tmp = add(p >> 1, num) << 1;
		if ((p & 1) != 0) {
			tmp += num;
		}
		return tmp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DivideTwoIntegers().divide(-2147483648, -3));
	}

}
