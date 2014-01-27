package lzq.leetcode.initial.dp;

import java.util.Stack;

public class LargestRectangleinHistogram {
	/**
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3].
	 * 
	 * 
	 * The largest rectangle is shown in the shaded area, which has area = 10
	 * unit.
	 * 
	 * For example, Given height = [2,1,5,6,2,3], return 10.
	 * 
	 * @param height
	 * @return
	 */
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == height || height.length <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		Stack<Integer> indexHeight = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (index.isEmpty() || height[i] > indexHeight.peek()) {
				indexHeight.push(height[i]);
				index.push(i);
			} else if (height[i] < indexHeight.peek()) {
				int indexTmp = 0;
				while (!index.isEmpty() && height[i] < indexHeight.peek()) {
					indexTmp = index.pop();
					int indexHeightTmp = indexHeight.pop();
					int tmp = (i - indexTmp) * indexHeightTmp;
					if (max < tmp) {
						max = tmp;
					}
				}
				if (index.isEmpty() || height[i] > indexHeight.peek()) {
					indexHeight.push(height[i]);
					index.push(indexTmp);
				}
			}
		}
		while (!indexHeight.isEmpty()) {
			int tmp = indexHeight.pop() * (height.length - index.pop());
			if (tmp > max) {
				max = tmp;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] h = { 1, 5, 5, 2 };
		int l = new LargestRectangleinHistogram().largestRectangleArea(h);

		System.out.println(l);
	}

}
