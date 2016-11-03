package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		List<IntegerShadow> integerShadows = new ArrayList<IntegerShadow>();
		for (int num : nums) {
			if (num == 0) {
				integerShadows.add(new IntegerShadow(0, "0"));
				continue;
			}
			integerShadows.add(new IntegerShadow(num, String.valueOf(num)));
		}
		IntegerShadow[] integerShadows2 = new IntegerShadow[integerShadows
				.size()];
		integerShadows.toArray(integerShadows2);
		Arrays.sort(integerShadows2);
		StringBuilder sb = new StringBuilder();
		for (int i = integerShadows2.length - 1; i >= 0; i--) {
			sb.append(integerShadows2[i].ori);
		}
		if (sb.toString().matches("0+")) {
			return "0";
		} else {
			return sb.toString();
		}
	}

	class IntegerShadow implements Comparable<IntegerShadow> {
		public int ori;
		public String oriStr;

		public IntegerShadow(int o, String s) {
			this.ori = o;
			this.oriStr = s;
		}

		@Override
		public int compareTo(IntegerShadow o) {
			return (this.oriStr + o.oriStr).compareTo(o.oriStr + this.oriStr);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber largestNumber = new LargestNumber();
		// int[] arrays = new int[]{3, 30, 34, 5, 9};
		// int[] arrays = new int[]{12,121};
		// int[] arrays = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		int[] arrays = new int[] { 0, 0, 0 };
		System.out.println(largestNumber.largestNumber(arrays));
	}
}
