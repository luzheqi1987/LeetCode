package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZeroOne {
    public void sort(int[] nums){
        int i = 0,  j = 0;
        while(j < nums.length) {
            if(nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            }else{
                j++;
            }
        }
    }

    public void sort1(int[] nums){
        int i = nums.length-1,  j = nums.length-1;
        while(j >=0) {
            if(nums[j] != 0) {
                swap(nums, i, j);
                i--;
                j--;
            }else{
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,0,2,4,3,0};
        ZeroOne z = new ZeroOne();
        z.sort1(nums);
        System.out.println(Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
