package lzq.leetcode.better.dp;

public class BestTimetoBuyandSellStockIII {
	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 * 
	 * @param prices
	 * @return
	 */
	// Let f[i][j] to be the maximum sum of j segments from the first i numbers,
	// where the last element we choose is a[i].
	// We have two strategies to achieve it:
	//
	// 1.Choosing the optimal j-1 segments from the first k numbers, and
	// starting a new segment with a[i]:
	// f[i][j] = f[k][j-1] + a[i], where j-1 <= k <= i-1.
	// let g[j-1] = max(f[k][j-1])
	// 2.Appending a[i] to the last segment in the first i-1 numbers
	// f[i][j] = f[i-1][j] + a[i].
	public int maxProfit(int[] prices) {
		return getMaxProfitDP(prices, 2);
	}

	int getMaxProfitDP(int[] prices, int transNum) {
		int[] f = new int[transNum + 1];
		int[] g = new int[transNum + 1];
		for (int i = 1; i < prices.length; ++i) {
			int diff = prices[i] - prices[i - 1];
			int m = Math.min(i, transNum);// if not enough to complete transNum
											// transactions
			for (int j = m; j >= 1; --j) {// why scan m->1, because we can not
											// let cur diff accumulate, note:
											// g[j-1]
				f[j] = Math.max(f[j], g[j - 1]) + diff;// 1.g[j-1] starting a
														// new segment and
														// 2.f[j] Appending a[i]
														// to the last segment
				g[j] = Math.max(g[j], f[j]);// record
			}
		}
		int ans = 0;
		for (int i = 1; i <= transNum; ++i)
			ans = Math.max(ans, g[i]);
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ac = { 6, 1, 3, 2, 4, 7, 1, 26 };
		int max = new BestTimetoBuyandSellStockIII().maxProfit(ac);
		System.out.println(max);
	}

}
