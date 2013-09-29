package lzq.leetcode;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0) {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			nums.add(0);
			return nums;
		}
		ArrayList<Integer> nums = new ArrayList<Integer>();
		char[] cs = new char[n];
		int max = (int) (Math.pow(2, n) - 1);
		for (int i = 0; i <= max; i++) {
			for (int j = 0; j < n; j++) {
				int yushu = (int) (i % Math.pow(2, 2 + j));
				if (yushu < Math.pow(2, 1 + j)) {
					if (yushu < Math.pow(2, j)) {
						cs[n - j - 1] = '0';
					} else {
						cs[n - j - 1] = '1';
					}
				} else {
					if ((yushu - Math.pow(2, 1 + j)) < Math.pow(2, j)) {
						cs[n - j - 1] = '1';
					} else {
						cs[n - j - 1] = '0';
					}
				}
			}
			int num = Integer.valueOf(String.valueOf(cs), 2);
			nums.add(num);
		}
		return nums;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new GrayCode().grayCode(1);
		System.out.println(nums);
	}

}
