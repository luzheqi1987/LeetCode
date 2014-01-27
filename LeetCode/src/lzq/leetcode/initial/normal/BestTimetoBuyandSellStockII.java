package lzq.leetcode.initial.normal;

public class BestTimetoBuyandSellStockII {
	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == prices || prices.length <= 1) {
			return 0;
		}
		int[] diff = new int[prices.length];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			diff[i] = prices[i] - prices[i - 1];
		}
		for (int i = 1; i < diff.length; i++) {
			if (diff[i] > 0) {
				max += diff[i];
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
