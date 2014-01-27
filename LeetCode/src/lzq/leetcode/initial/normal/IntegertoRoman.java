package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.List;

public class IntegertoRoman {
	static List<R2A> r2a = new ArrayList<R2A>();

	static {
		r2a.add(new R2A(1000, 'M'));
		r2a.add(new R2A(500, 'D'));
		r2a.add(new R2A(100, 'C'));
		r2a.add(new R2A(50, 'L'));
		r2a.add(new R2A(10, 'X'));
		r2a.add(new R2A(5, 'V'));
		r2a.add(new R2A(1, 'I'));
	}

	/**
	 * Given an integer, convert it to a roman numeral.
	 * 
	 * Input is guaranteed to be within the range from 1 to 3999.
	 * 
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int number = num;
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			for (int i = 0; i < r2a.size(); i++) {
				int jieguo = number / r2a.get(i).number;
				if (jieguo <= 0) {
					continue;
				} else {
					if (jieguo == 4) {
						sb.append(r2a.get(i).roman);
						sb.append(r2a.get(i - 1).roman);
						number = number % r2a.get(i).number;

					} else {
						if (i % 2 == 1
								&& jieguo == 1
								&& i < r2a.size() - 1
								&& number % r2a.get(i).number
										/ r2a.get(i + 1).number == 4) {
							sb.append(r2a.get(i + 1).roman);
							sb.append(r2a.get(i - 1).roman);
							number = number % r2a.get(i + 1).number;
						} else {
							for (int j = 0; j < jieguo; j++) {
								sb.append(r2a.get(i).roman);
							}
							number = number % r2a.get(i).number;
						}
					}
					break;
				}
			}
		}
		return sb.toString();
	}

	static class R2A {
		public int number;
		public char roman;

		R2A(int n, char r) {
			number = n;
			roman = r;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IntegertoRoman().intToRoman(465));
	}
}
