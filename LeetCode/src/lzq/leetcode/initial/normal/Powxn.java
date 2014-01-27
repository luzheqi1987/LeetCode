package lzq.leetcode.initial.normal;

public class Powxn {
	public double pow(double x, int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		boolean minus = false;
		double result = x;
		if (Math.abs(n - 0.0) < 1.0E-50) {
			return 1.0;
		} else if (Math.abs(x - 1.0) < 1.0E-50) {
			return 1.0;
		} else if (Math.abs(x + 1.0) < 1.0E-50) {
			if (n % 2 == 0) {
				return 1.0;
			} else {
				return -1.0;
			}
		}
		if (n < 0) {
			minus = true;
			n = -n;
		}
		for (int i = 1; i < n; i++) {
			result *= x;
			if (Math.abs(result) < 1.0E-50) {
				break;
			}
		}
		// result = cheng(1, n, x);
		if (minus) {
			return 1 / result;
		} else {
			return result;
		}
	}

	double cheng(int start, int end, double x) {
		if (start == end) {
			return x;
		}
		int mid = (end + start) / 2;
		double left = cheng(start, mid, x);
		double right = cheng(mid + 1, end, x);
		return left * right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Powxn().pow(-3.39758, 5));
	}

}
