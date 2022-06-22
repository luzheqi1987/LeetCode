package lzq.leetcode.initial.normal;

public class MinimumTotalSpaceWastedWithKResizingOperations {
    int n, INF = (int) (200 * 1e6);
    Integer[][] memo = new Integer[200][200];

    /**
     * https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/discuss/1389247/C%2B%2BJavaPython-The-stupid-guy-who-is-downvoting-my-posts-please-tell-me-WHY
     * @param nums
     * @param k
     * @return
     */
    public int minSpaceWastedKResizing(int[] nums, int k) {
        n = nums.length;
        return dp(nums, 0, k);
    }

    int dp(int[] nums, int i, int k) {
        if (i == n) return 0;
        if (k == -1) return INF;
        if (memo[i][k] != null) return memo[i][k];
        int ans = INF, maxNum = nums[i], totalSum = 0;
        for (int j = i; j < n; ++j) {
            maxNum = Math.max(maxNum, nums[j]);
            totalSum += nums[j];
            int wasted = maxNum * (j - i + 1) - totalSum;
            ans = Math.min(ans, dp(nums, j + 1, k - 1) + wasted);
        }
        return memo[i][k] = ans;
    }


    public static void main(String[] args) {

    }
}
