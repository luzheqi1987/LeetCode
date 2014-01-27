package lzq.leetcode.initial.normal;

public class ContainerWithMostWater {
	/**
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 * 
	 * Note: You may not slant the container.
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == height || height.length <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j < i; j++) {
				if (height[j] >= height[i]) {
					int tmp = (i - j) * height[i];
					if (tmp > max) {
						max = tmp;
					}
					break;
				}
			}
			for (int j = height.length - 1; j > i; j--) {
				if (height[j] >= height[i]) {
					int tmp = (j - i) * height[i];
					if (tmp > max) {
						max = tmp;
					}
					break;
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ContainerWithMostWater().maxArea(new int[] { 1,
				1 }));
	}

}
