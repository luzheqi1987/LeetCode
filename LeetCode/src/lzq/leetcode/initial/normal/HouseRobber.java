package lzq.leetcode.initial.normal;

public class HouseRobber {
	public int rob(int[] nums) {
		int[] f = new int[nums.length];
		if (nums.length > 0) {
			f[0] = nums[0];
		} else {
			return 0;
		}

		if (nums.length > 1) {
			f[1] = Math.max(f[0], nums[1]);
		} else {
			return f[0];
		}

		if (nums.length > 2) {
			f[2] = Math.max(f[0] + nums[2], f[1]);
		} else {
			return f[1];
		}

		if (nums.length > 3) {
			f[3] = Math.max(Math.max(f[0] + nums[3], f[1] + nums[3]), f[2]);
		} else {
			return f[2];
		}

		for (int i = 4; i < nums.length; i++) {
			f[i] = Math.max(Math.max(f[i - 3] + nums[i], f[i - 2] + nums[i]),
					f[i - 1]);
		}
		return f[nums.length - 1];
	}

	public static void main(String[] args) {
		int[] houses = new int[] { 2, 1, 1, 2 };
		HouseRobber houseRobber = new HouseRobber();
		System.out.println(houseRobber.rob(houses));

	}

}
