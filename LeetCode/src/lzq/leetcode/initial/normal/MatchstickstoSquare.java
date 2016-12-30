package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatchstickstoSquare {
	public boolean makesquare(int[] nums) {
		if (null == nums || nums.length <= 0) {
			return false;
		}

		long sum = 0l;
		Arrays.sort(nums);
		List<Integer> allNums = new ArrayList<Integer>();
		for (int num : nums) {
			sum += num;
			allNums.add(num);
		}
		if (sum % 4 != 0) {
			return false;
		}
		int average = (int) sum / 4;
		if (nums[nums.length - 1] > average) {
			return false;
		}

		return makeSquare(allNums, average, 0, 2);
	}

	private boolean makeSquare(List<Integer> allNums, int average, int step,
			int maxSteps) {
		Set<List<Integer>> numbersList = new HashSet<List<Integer>>();
		findFixNumbers(numbersList, new ArrayList<Integer>(), allNums, 0, 0,
				average);
		if (!numbersList.isEmpty()) {
			if (step == maxSteps) {
				return true;
			}
			for (List<Integer> numbers : numbersList) {
				for (int number : numbers) {
					allNums.remove((Integer) number);
				}
				boolean result = makeSquare(allNums, average, step + 1,
						maxSteps);
				if (result) {
					return true;
				}
				for (int number : numbers) {
					allNums.add((Integer) number);
				}
				Collections.sort(allNums);

			}
		}
		return false;
	}

	private boolean findFixNumbers(Set<List<Integer>> numbersList,
			List<Integer> numbers, List<Integer> nums, int index, int nowNum,
			int average) {
		if (nowNum == average) {
			return true;
		}
		if (nowNum < average) {
			for (int i = index; i < nums.size(); i++) {
				if (nowNum + nums.get(i) > average) {
					return false;
				}
				numbers.add(nums.get(i));
				if (findFixNumbers(numbersList, numbers, nums, i + 1, nowNum
						+ nums.get(i), average)) {
					numbersList.add(new ArrayList<Integer>(numbers));
				}
				numbers.remove((Integer) nums.get(i));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// int[] nums = new int[]{1,1,2,2,2};
		int[] nums = new int[] { 1, 1, 2, 2, 2 };
		MatchstickstoSquare matchstickstoSquare = new MatchstickstoSquare();
		System.out.println(matchstickstoSquare.makesquare(nums));
	}
}
