package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
    public void quickSort(int[] nums) {
        part(nums, 0, nums.length - 1);
    }

    private void part(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int idx = end;
        int l = start;
        int r = end - 1;
        while (l <= r) {
            while (l <= r && nums[l] <= nums[idx]) {
                l++;
            }
            if (l <= r) {
                int tmp = nums[idx];
                nums[idx] = nums[l];
                nums[l] = tmp;
                idx = l;
            }
            while (l <= r && nums[r] >= nums[idx]) {
                r--;
            }
            if (l <= r) {
                int tmp = nums[idx];
                nums[idx] = nums[r];
                nums[r] = tmp;
                idx = r;
            }
        }
        part(nums, start, idx - 1);
        part(nums, idx + 1, end);
    }

    public static void main(String[] args) {
        int[] ttt = new int[]{32, 23, 41, 3, 25, 435, 312, 432, 55, 322, 52, 54, 98};
        QuickSort s = new QuickSort();
        s.quickSort(ttt);
        System.out.println(Arrays.stream(ttt).boxed().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
