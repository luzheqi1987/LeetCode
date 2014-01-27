package lzq.leetcode.initial.normal;

public class PlusOne {
	/**
	 * Given a number represented as an array of digits, plus one to the number.
	 * 
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int c = 1;
		int i;
		for (i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += c;
				break;
			} else if (digits[i] == 9) {
				digits[i] = 0;
			}
		}
		if (i < 0 && digits[0] == 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		} else {
			return digits;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = { 9 };
		System.out.println(new PlusOne().plusOne(digits));
	}

}
