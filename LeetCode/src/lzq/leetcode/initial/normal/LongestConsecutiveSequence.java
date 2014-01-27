package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	/**
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 * 
	 * @param num
	 * @return
	 */
	public int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == num || num.length < 0) {
			return 0;
		}
		Map<Integer, Integer> results = new HashMap<Integer, Integer>();
		Set<Integer> used = new HashSet<Integer>();
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if (used.contains(num[i])) {
				continue;
			} else {
				used.add(num[i]);
			}

			int left = num[i], right = num[i];

			if (results.containsKey(left - 1)
					&& results.get(left - 1) <= left - 1) {
				left = results.get(left - 1);
			}

			if (results.containsKey(right + 1)
					&& results.get(right + 1) >= right + 1) {
				right = results.get(right + 1);
			}
			results.put(left, right);
			results.put(right, left);

			max = max > (right - left + 1) ? max : (right - left + 1);
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] abs = { 2000, 1, 1000, 4, 3, 2 };
		int sba = new LongestConsecutiveSequence().longestConsecutive(abs);
		System.out.println(sba);
	}

}
