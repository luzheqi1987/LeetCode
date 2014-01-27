package lzq.leetcode.initial.dp;

public class GasStation {
	/**
	 * There are N gas stations along a circular route, where the amount of gas
	 * at station i is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * 
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == gas || gas.length <= 0) {
			return -1;
		}
		for (int i = 0; i < gas.length; i++) {
			gas[i] -= cost[i];
		}
		int i = 0;
		int j = 0;
		int sum = 0;
		for (; i < gas.length; i++) {
			if (gas[i] < 0) {
				continue;
			}
			sum = gas[i];
			j = (i + 1) % gas.length;

			while (sum >= 0 && j != i) {
				sum += gas[j];
				j = (j + 1) % gas.length;
			}
			if (j == i) {
				break;
			}
			if (j > i) {
				i = j;
			}
		}

		if (i < gas.length && j == i && sum > 0) {
			return i;
		} else {
			return -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GasStation().canCompleteCircuit(
				new int[] { 2, 4 }, new int[] { 3, 4 }));
	}
}
