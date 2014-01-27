package lzq.leetcode.better.knack;

import java.util.ArrayList;

public class GrayCode {
	/**
	 * The gray code is a binary numeral system where two successive values
	 * differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is
	 * not uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 * 
	 * @param n
	 * @return
	 */
	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0) {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			nums.add(0);
			return nums;
		}
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int max = 1 << n;
		for (int i = 0; i < max; i++) {
			/*
			 * for reference: http://en.wikipedia.org/wiki/Gray_code
			 */
			nums.add((i >> 1) ^ i);
		}
		return nums;
	}

	/**
	 * The following functions in Java convert between binary numbers and their
	 * associated Gray codes. While it may seem that gray-to-binary conversion
	 * requires each bit to be handled one at a time, faster algorithms exist.
	 * 
	 * Henry Gordon Dietz.
	 * "The Aggregate Magic Algorithms: Gray Code Conversion"
	 * 
	 */

	/*
	 * The purpose of this function is to convert an unsigned binary number to
	 * reflected binary Gray code.
	 * 
	 * The operator >> is shift right. The operator ^ is exclusive or.
	 */
	int binaryToGray(int num) {
		return (num >> 1) ^ num;
	}

	/*
	 * The purpose of this function is to convert a reflected binary Gray code
	 * number to a binary number.
	 */
	int grayToBinary(int num) {
		int mask;
		for (mask = num >> 1; mask != 0; mask = mask >> 1) {
			num = num ^ mask;
		}
		return num;
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
