package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class KSum {
    int count = 0;
    public int kSum(int[] nums, int k, int target) {
        count = 0;
        dfs(nums, k, target, 0);
        return count;
    }

    private void dfs(int[] nums, int k, int target, int index) {
        if(target == 0 && k == 0) {
            count++;
            return;
        }else if(k <= 0 || target < 0) {
            return;
        }

        for(int i = index; i < nums.length - k + 1; i++) {
            for(int j = i + 1; j <= nums.length - k + 1; j++) {
                dfs(nums, k - 1, target - nums[i], j);
            }
        }
    }

    private void dfs1(int[] nums, int k, int target, int index) {
        if(target == 0 && k == 0) {
            count++;
            return;
        }else if(k <= 0 || target < 0 || index >= nums.length) {
            return;
        }

        dfs1(nums, k, target, index + 1);
        dfs1(nums, k - 1, target - nums[index], index + 1);
    }

    public static void main(String[] args) {
        KSum kSum = new KSum();
        System.out.println(kSum.kSum(new int[]{1,2,4}, 2, 5));

        String str[] = {"","","","",""};
        int ddd[] = {1,2,3,4,5};
        System.out.println(Arrays.stream(str).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(ddd).boxed().map(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(-0.0==0.0);
    }
}
