package lzq.leetcode.initial.knack;

public class Sqrt {
	/**
	 * Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 * 
	 * @param x
	 * @return
	 */
	public int sqrt(int x) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (x <= 0) {
			return 0;
		}
		double pre = -1.0;
		double cur = 1.0;
		while (Math.abs(pre - cur) > 0.00001) {
			pre = cur;
			cur = (cur + x / cur) / 2;
		}
		return (int) cur;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Sqrt().sqrt(3));
	}

}
