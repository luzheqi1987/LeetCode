package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.Comparator;

public class OnesandZeroes {

	public int findMaxForm(String[] strs, int m, int n) {
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int o1ones = 0;
				int o2ones = 0;

				for (char c : o1.toCharArray()) {
					if (c == '1') {
						o1ones++;
					}
				}
				for (char c : o2.toCharArray()) {
					if (c == '1') {
						o2ones++;
					}
				}
				return o1ones - o2ones == 0 ? o1.length() - o2.length()
						: o1ones - o2ones;
			}

		});
		int sum1 = 0;
		int m1 = m;
		int n1 = n;
		for (String str : strs) {
			if (m1 + n1 < str.length()) {
				break;
			}
			int ones = 0;
			int zeros = 0;
			for (char c : str.toCharArray()) {
				if (c == '1') {
					ones++;
				}
			}
			zeros = str.length() - ones;
			if (ones <= n1 && zeros <= m1) {
				sum1++;
				n1 -= ones;
				m1 -= zeros;
			}
		}
		
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int o1ones = 0;
				int o2ones = 0;

				for (char c : o1.toCharArray()) {
					if (c == '0') {
						o1ones++;
					}
				}
				for (char c : o2.toCharArray()) {
					if (c == '0') {
						o2ones++;
					}
				}
				return o1ones - o2ones == 0 ? o1.length() - o2.length()
						: o1ones - o2ones;
			}

		});
		int sum2 = 0;
		for (String str : strs) {
			if (m + n < str.length()) {
				break;
			}
			int ones = 0;
			int zeros = 0;
			for (char c : str.toCharArray()) {
				if (c == '1') {
					ones++;
				}
			}
			zeros = str.length() - ones;
			if (ones <= n && zeros <= m) {
				sum2++;
				n -= ones;
				m -= zeros;
			}
		}
		return Math.max(sum1, sum2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrays1 = new String[] { "10", "0001", "111001", "1", "0" };
		String[] arrays2 = new String[] { "111", "1000", "1000", "1000"};
		OnesandZeroes onesandZeroes = new OnesandZeroes();
		System.out.println(onesandZeroes.findMaxForm(arrays2, 9, 3));
	}

}
