package lzq.leetcode;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == prices || prices.length <= 1) {
			return 0;
		}
		int currentMin = prices[0];
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < currentMin) {
				currentMin = prices[i];
			}
			int tmpMax = prices[i] - currentMin;
			if (tmpMax > max) {
				max = tmpMax;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
