package lzq.leetcode.initial.normal;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 <= nums.length - 1 && nums[start + 1] >= nums[start]) {
            start++;
        }
        if (start == nums.length - 1) {
            return 0;
        }
        while (end - 1 >= 0 && nums[end - 1] <= nums[end]) {
            end--;
        }

        int min = Math.min(nums[start + 1], nums[end]);
        int max = Math.max(nums[end - 1], nums[start]);
        for (int i = start + 1; i <= end - 1; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        while (start >= 0 && nums[start] > min) {
            start--;
        }
        while (end <= nums.length - 1 && nums[end] < max) {
            end++;
        }
        return end - start - 1;
    }

    public void change(int a){
        a = 10;
    }


    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        System.out.println(s.findUnsortedSubarray(new int[]{1, 3, 5, 4, 2}));

        int a = 1;
        s.change(a);
        System.out.println(a);
    }
}
