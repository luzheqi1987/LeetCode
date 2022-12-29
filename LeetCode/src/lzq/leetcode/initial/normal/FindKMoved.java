package lzq.leetcode.initial.normal;

public class FindKMoved {
    public int find(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (right - left == 1) {
                return nums[left] > nums[right] ? len - right : len - left;
            } else if (nums[left] < nums[right]) {
                return len - left;
            }
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return len - nums[left];
    }

    public static void main(String[] args) {
        FindKMoved f = new FindKMoved();
        System.out.println(f.find(new int[]{ 4, 5, 6, 7, 8, 9, 1, 2,3}));
    }
}
