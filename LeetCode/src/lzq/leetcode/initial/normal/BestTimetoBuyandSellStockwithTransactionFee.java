package lzq.leetcode.initial.normal;

/**
 * BestTimetoBuyandSellStockwithTransactionFee
 *
 * @author luzheqi
 * @date 2017/11/7
 * @time 下午5:44
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    /**
     * https://discuss.leetcode.com/topic/107998/most-consistent-ways-of-dealing-with-the-series-of-stock-problems
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            long T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return (int)T_ik0;
    }
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithTransactionFee b = new BestTimetoBuyandSellStockwithTransactionFee();
        System.out.println(b.maxProfit(new int[]{1,4,6,2,8,3,10,14}, 3));
    }
}
