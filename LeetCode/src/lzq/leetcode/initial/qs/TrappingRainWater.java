package lzq.leetcode.initial.qs;

import java.util.Stack;

public class TrappingRainWater {
	@SuppressWarnings("unused")
	/**
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
	 *
	 *For example, 
	 *	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 *
	 *
	 *	The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
	 * @param A
	 * @return
	 */
	public int trap(int[] A) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (A.length <= 2) {
			return 0;
		}
		Stack<Integer> hights = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		hights.push(A[0]);
		index.push(0);
		int sum = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > hights.peek()) {
				if (hights.size() <= 1) {
					hights.pop();
					index.pop();
					hights.push(A[i]);
					index.push(i);
				} else {
					while (A[i] > hights.peek() && hights.size() >= 2) {
						int before = hights.pop();
						int beforeIndex = index.pop();
						int bbefore = hights.pop();
						int bbeforeIndex = index.pop();
						int minBorad = Math.min(A[i], bbefore);
						sum += (i - bbeforeIndex - 1) * (minBorad - before);
						hights.push(bbefore);
						index.push(bbeforeIndex);
					}
					if (hights.size() <= 1 && A[i] > hights.peek()) {
						hights.pop();
						index.pop();
						hights.push(A[i]);
						index.push(i);
					} else if (A[i] < hights.peek()) {
						hights.push(A[i]);
						index.push(i);
					} else if (A[i] == hights.peek()) {
						index.pop();
						index.push(i);
					}
				}
			} else if (A[i] < hights.peek()) {
				hights.push(A[i]);
				index.push(i);
			} else {
				index.pop();
				index.push(i);
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TrappingRainWater().trap(new int[] { 5, 5, 1, 7,
				1, 1, 5, 2, 7, 6 }));
	}

}
