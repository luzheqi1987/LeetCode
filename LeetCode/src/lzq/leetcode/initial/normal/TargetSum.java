package lzq.leetcode.initial.normal;

public class TargetSum {

	public int findTargetSumWays(int[] nums, int S) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		return findWays(nums, 0, S, 0);
	}

	private int findWays(int[] nums, int step, int S, int curSum) {
		if (step == nums.length) {
			if (curSum == S) {
				return 1;
			} else {
				return 0;
			}
		}

		int correctNumbers = 0;
		for (int i = 0; i < 2; i++) {
			if(i == 0){
				curSum += nums[step];
				correctNumbers += findWays(nums, step+1, S, curSum);
				curSum -= nums[step];				
			}else{
				curSum -= nums[step];
				correctNumbers += findWays(nums, step+1, S, curSum);
				curSum += nums[step];
			}
		}
		
		return correctNumbers;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 1, 1, 1};
		TargetSum t = new TargetSum();
		System.out.println(t.findTargetSumWays(nums, 3));
	}

}
