package lzq.leetcode.better.normal;

import java.util.HashSet;
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
		int max = Integer.MIN_VALUE;
		Set<Integer> results = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			results.add(num[i]);
		}
		for (int i = 0; i < num.length; i++) {
			if (results.contains(num[i])) {
				results.remove((Integer) num[i]);
				max = Math.max(max, getCount(results, num[i]) + 1);
			}
		}
		return max;
	}

	int getCount(Set<Integer> results, int i) {
		int count = 0;
		int tmp = i - 1;
		while (results.contains(tmp)) {
			results.remove((Integer) (tmp));
			count++;
			tmp--;
		}
		tmp = i + 1;
		while (results.contains(tmp)) {
			results.remove((Integer) (tmp));
			count++;
			tmp++;
		}
		return count;
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
