package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * PartitionArrayforMaximumSum
 *
 * @author luzheqi
 * @date 2019-05-15
 * @time 19:23
 */
public class PartitionArrayforMaximumSum {
    private Map<Integer, Integer> maxMap = new HashMap<>();

    public int maxSumAfterPartitioning1(int[] A, int K) {
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        int sum = calc(0, A, K);
        return sum;
    }

    private int calc(int index, int[] A, int K){
        int sum = 0;
        if(index >= A.length){
            return sum;
        }
        if(maxMap.containsKey(index)){
            return maxMap.get(index);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < K; i++){
            if(index + i >= A.length){
                break;
            }else{
                max = Math.max(max, A[index + i]);
                sum = Math.max(sum, max * (i + 1) + calc(index + i + 1, A, K));
            }
        }
        maxMap.put(index, sum);
        return sum;
    }

    public static void main(String[] args) {
        PartitionArrayforMaximumSum p = new PartitionArrayforMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }
}
