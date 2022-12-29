package lzq.leetcode.initial.normal;

import java.util.Arrays;

public class MaxKByQuickSort {
    public int maxK(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start == end && start == k - 1) {
            return nums[start];
        }
        int st = start;
        int ed = end;
        int midIndex = end;
        end -= 1;
        while (start <= end) {
            while (start <= end && nums[start] >= nums[midIndex]) {
                start++;
            }
            if (start <= end) {
                int tmp = nums[start];
                nums[start] = nums[midIndex];
                nums[midIndex] = tmp;
                midIndex = start;
            }
            while (start <= end && nums[end] <= nums[midIndex]) {
                end--;
            }
            if (start <= end) {
                int tmp = nums[end];
                nums[end] = nums[midIndex];
                nums[midIndex] = tmp;
                midIndex = end;
            }
        }
        if (midIndex == k - 1) {
            return nums[midIndex];
        } else if (midIndex > k - 1) {
            return partition(nums, st, midIndex-1, k);
        } else {
            return partition(nums, midIndex + 1, ed, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Integer(200) == new Integer(200));
        System.out.println(new Integer(10) == new Integer(10));
        MaxKByQuickSort s = new MaxKByQuickSort();
        // System.out.println(s.maxK(new int[]{2, 3, 4, 5, 6, 45, 32}, 4));
        int[] ttt = new int[]{3,2,1,5,6,4};
        System.out.println(s.maxK(ttt, 2));
        Arrays.sort(ttt);
        System.out.println(ttt[2]);

    }
}
