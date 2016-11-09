package lzq.leetcode.initial.normal;

/**
 * Rotate an array of n elements to the right by k steps.

 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * @author zq
 *
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(k < 0){
        	return;
        }
        k = k % nums.length;
        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }
    
    private void rotate(int[] nums, int start, int end){
    	if(start < 0 || start >= nums.length || end >= nums.length || end < 0){
    		return;
    	}
    	while(start < end){
    		int tmp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = tmp;
    		
    		start++;
    		end--;
    	}
    }
	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		int[] nums = new int[]{1,2,3,4,5,6,7};
		
		rotateArray.rotate(nums, 3);
		for(int num : nums){
			System.out.println(num);
		}

	}

}
