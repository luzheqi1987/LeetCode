package lzq.leetcode.initial.normal;

public class OptimalDivision {
	public String optimalDivision(int[] nums) {
		StringBuilder builder = new StringBuilder();
		builder.append(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (i == 1 && nums.length > 2) {
				builder.append("/(").append(nums[i]);
			} else {
				builder.append("/").append(nums[i]);
			}
		}

		return nums.length > 2 ? builder.append(")").toString() : builder
				.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
