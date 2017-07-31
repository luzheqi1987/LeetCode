package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public int findMaxLength(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}
		Map<Integer, Integer> zeroMap = new HashMap<>();
		zeroMap.put(0, -1);
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (zeroMap.containsKey(sum)) {
				max = Math.max(max, i - zeroMap.get(sum));
			} else
				zeroMap.put(sum, i);
		}
		return max;
	}

	public static void main(String[] args) {
		ContiguousArray c = new ContiguousArray();
		System.out.println(c
				.findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0 }));
	}

}
