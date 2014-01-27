package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class FirstMissingPositive {
	/**
	 * Given an unsorted integer array, find the first missing positive integer.
	 * 
	 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
	 * 
	 * Your algorithm should run in O(n) time and uses constant space.
	 * 
	 * @param A
	 * @return
	 */
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			numbers.add(i + 1);
		}
		for (int i = 0; i < A.length; i++) {
			if (numbers.contains((Integer) A[i])) {
				numbers.remove((Integer) A[i]);
			}
		}
		if (numbers.isEmpty()) {
			return A.length + 1;
		} else {
			return numbers.get(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FirstMissingPositive()
				.firstMissingPositive(new int[] { 1, 2, 0 }));
	}

}
