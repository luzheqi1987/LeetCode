package lzq.leetcode;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == prices || prices.length <= 1) {
			return 0;
		}
		int[] diff = new int[prices.length];
		for (int i = 1; i < prices.length; i++) {
			diff[i] = prices[i] - prices[i - 1];
		}
		int maxFinal = 0;
		for (int i = 1; i < diff.length; i++) {
			if (diff[i] <= 0) {
				continue;
			}
			int max1 = 0;
			int max2 = 0;
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				tmp += diff[j];
				if (tmp > max1) {
					max1 = tmp;
				}
				if (tmp < 0) {
					tmp = 0;
				}
			}
			tmp = 0;
			for (int j = i; j < diff.length; j++) {
				tmp += diff[j];
				if (tmp > max2) {
					max2 = tmp;
				}
				if (tmp < 0) {
					tmp = 0;
				}
			}
			if (maxFinal < max1 + max2) {
				maxFinal = max1 + max2;
			}
		}

		return maxFinal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ac = { 6, 1, 3, 2, 4, 7 };
		int max = new BestTimetoBuyandSellStockIII().maxProfit(ac);
		System.out.println(max);
	}

}
