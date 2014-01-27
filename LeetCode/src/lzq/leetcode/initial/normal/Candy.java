package lzq.leetcode.initial.normal;

public class Candy {
	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 * 
	 * Discuss
	 * 
	 * 
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		int min = 0;

		for (int i = 0; i < ratings.length; i++) {
			if (0 == i) {
				left[i] = 0;
				continue;
			}
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			} else if (ratings[i] <= ratings[i - 1]) {
				left[i] = 0;
			}
		}

		for (int i = ratings.length - 1; i >= 0; i--) {
			if (ratings.length - 1 == i) {
				right[i] = 0;
				continue;
			}
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			} else if (ratings[i] <= ratings[i + 1]) {
				right[i] = 0;
			}
		}

		for (int i = 0; i < ratings.length; i++) {
			min += left[i] > right[i] ? left[i] + 1 : right[i] + 1;
		}

		return min;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Candy().candy(new int[] { 5, 3, 1 }));
	}
}
