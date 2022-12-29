package lzq.leetcode.initial.normal;

public class FindGuaiDian {
    public int find(int[] nums) {
        int len = nums.length;
        if (nums.length < 3 || !hasGuaiDian(nums, 0, len - 1)) {
            return -1;
        }
        boolean findTop = true;
        if (nums[1] < nums[0] && nums[len - 1] > nums[len - 2]) {
            findTop = false;
        }
        return binarySearch(nums, 0, len - 1, findTop);
    }

    private int binarySearch(int[] nums, int start, int end, boolean findTop) {
        if (!hasGuaiDian(nums, start, end)) {
            if (findTop) {
                return Math.max(nums[start], nums[end]);
            } else {
                return Math.min(nums[start], nums[end]);
            }
        }
        int mid = start + (end - start) / 2;
        if (hasGuaiDian(nums, start, mid)) {
            return binarySearch(nums, start, mid, findTop);
        } else {
            return binarySearch(nums, mid, end, findTop);
        }
    }

    private boolean hasGuaiDian(int[] nums, int left, int right) {
        if (right - left <= 1) {
            return false;
        }

        return (nums[left + 1] < nums[left] && nums[right] > nums[right - 1]) ||
                (nums[left + 1] > nums[left] && nums[right] < nums[right - 1]);
    }

    public static void main(String[] args) {
        int[] aa = new int[]{3,2,1,2,3};
        FindGuaiDian findGuaiDian = new FindGuaiDian();
        System.out.println(findGuaiDian.find(aa));
    }
}
