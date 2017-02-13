package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlidingWindowMedian {
	public double[] medianSlidingWindow(int[] nums, int k) {
		if (k == 0 || k > nums.length) {
			return new double[] {};
		}
		if (k == 1) {
			double[] results = new double[nums.length];
			for (int i = 0; i < nums.length; i++) {
				results[i] = nums[i];
			}
			return results;
		}

		boolean isEven = k % 2 == 0;
		double[] results = new double[nums.length - k + 1];
		List<Integer> temps = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			temps.add(nums[i]);
		}
		Collections.sort(temps);
		if (isEven) {
			results[0] = (long) temps.get(k / 2 - 1)
					+ ((long) temps.get(k / 2) - (long) temps.get(k / 2 - 1))
					/ 2.0;
		} else {
			results[0] = temps.get(k / 2);
		}

		for (int i = 1; i < nums.length - k + 1; i++) {
			int index = temps.indexOf((Integer) nums[i - 1]);

			temps.set(index, nums[k + i - 1]);

			boolean isForward = index > 0
					&& (nums[k + i - 1] < temps.get(index - 1));

			if (isForward) {
				for (int j = index; j >= 1; j--) {
					int first = temps.get(j - 1);
					int second = temps.get(j);
					if (second < first) {
						temps.set(j - 1, second);
						temps.set(j, first);
					} else {
						break;
					}
				}
			} else {
				for (int j = index; j < temps.size() - 1; j++) {
					int first = temps.get(j);
					int second = temps.get(j + 1);
					if (second < first) {
						temps.set(j, second);
						temps.set(j + 1, first);
					} else {
						break;
					}
				}
			}

			if (isEven) {
				results[i] = (long) temps.get(k / 2 - 1)
						+ ((long) temps.get(k / 2) - (long) temps
								.get(k / 2 - 1)) / 2.0;
			} else {
				results[i] = temps.get(k / 2);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		int[] nums = new int[] { -2147483648, -2147483648, 2147483647,
				-2147483648, -2147483648, -2147483648, 2147483647, 2147483647,
				2147483647, 2147483647, -2147483648, 2147483647, -2147483648 };
		double[] results = slidingWindowMedian.medianSlidingWindow(nums, 2);
		for (double result : results) {
			System.out.print(result + " ");
		}
		System.out.println();
	}
}
