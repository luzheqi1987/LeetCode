package lzq.leetcode.initial.normal;

import java.util.Stack;

public class SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        long count = 0L;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                dp[i] += arr[i] * (i + 1);
                count += dp[i];
            } else {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    dp[i] += arr[i] * (i + 1);
                    count += dp[i];
                } else {
                    dp[i] += arr[i] * (i - stack.peek()) + dp[stack.peek()];
                    count += dp[i];
                }
            }
            stack.push(i);
        }
        return (int)count;
    }

    public static void main(String[] args) {
        System.out.println(new SumofSubarrayMinimums().sumSubarrayMins(new int[]{3,1,2}));
    }
}
