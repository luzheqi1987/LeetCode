package lzq.leetcode.initial.normal;

public class TopK {
    public int topK(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        return part(nums, 0, nums.length - 1, k);
    }

    public int part(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, start, left);
        if (left == k - 1) {
            return nums[left];
        } else {
            if (left > k - 1) {
                return part(nums, start, left - 1, k);
            } else {
                return part(nums, left + 1, end, k);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        System.out.println(topK.topK(new int[] {1,10,3,4,5,6,7,8}, 4));
    }
}
