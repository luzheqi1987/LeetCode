package lzq.leetcode.initial.normal;

import java.util.ArrayList;

public class Triangle {
	/**
	 * Given a triangle, find the minimum path sum from top to bottom. Each step
	 * you may move to adjacent numbers on the row below.
	 * 
	 * For example, given the following triangle [ [2], [3,4], [6,5,7],
	 * [4,1,8,3] ] The minimum path sum from top to bottom is 11 (i.e., 2 + 3 +
	 * 5 + 1 = 11).
	 * 
	 * Note: Bonus point if you are able to do this using only O(n) extra space,
	 * where n is the total number of rows in the triangle.
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == triangle || 0 == triangle.size()) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int[] mins = new int[triangle.size() + 1];
		for (int i = 0; i < mins.length; i++) {
			mins[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < mins.length; i++) {
			for (int j = i; j >= 1; j--) {
				if (i == 1 && j == 1) {
					mins[j] = triangle.get(i - 1).get(j - 1);
				} else {
					mins[j] = Math.min(mins[j], mins[j - 1])
							+ triangle.get(i - 1).get(j - 1);
				}
			}
		}
		for (int i = 1; i < mins.length; i++) {
			min = Math.min(min, mins[i]);
		}
		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(2);
		ArrayList<Integer> two = new ArrayList<Integer>();
		two.add(3);
		two.add(4);
		ArrayList<Integer> thr = new ArrayList<Integer>();
		thr.add(6);
		thr.add(5);
		thr.add(7);
		ArrayList<Integer> fou = new ArrayList<Integer>();
		fou.add(4);
		fou.add(1);
		fou.add(8);
		fou.add(3);

		ArrayList<ArrayList<Integer>> layer = new ArrayList<ArrayList<Integer>>();
		layer.add(one);
		layer.add(two);
		layer.add(thr);
		layer.add(fou);

		int min = new Triangle().minimumTotal(layer);
		System.out.println(min);

	}

}
