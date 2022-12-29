package lzq.leetcode.initial.normal;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        Set<Integer> curSums = new HashSet<>();
        if (nums[0] == half) {
            return true;
        }
        curSums.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> newCurSums = new HashSet<>(curSums);
            if (nums[i] <= half) {
                newCurSums.add(nums[i]);
                for (int curSum : curSums) {
                    int cs = curSum + nums[i];
                    if (cs == half) {
                        return true;
                    } else if (cs < half) {
                        newCurSums.add(cs);
                    }
                }
            }
            curSums = newCurSums;
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[]{1, 1}));
    }
}
