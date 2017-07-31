package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

	public int findMinDifference(List<String> timePoints) {
		int[] timeRevert = new int[timePoints.size()];

		for (int i = 0; i < timePoints.size(); i++) {
			String timePoint = timePoints.get(i);
			String[] timeParts = timePoint.split(":");
			int hour = Integer.valueOf(timeParts[0].trim());
			int minute = Integer.valueOf(timeParts[1].trim());
			int revert = hour * 60 + minute;
			timeRevert[i] = revert;
		}
		Arrays.sort(timeRevert);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < timeRevert.length; i++) {
			if (i < timeRevert.length - 1) {
				if (timeRevert[i + 1] - timeRevert[i] < min) {
					min = timeRevert[i + 1] - timeRevert[i];
				}
			} else {
				if (timeRevert[0] + 24 * 60 - timeRevert[i] < min) {
					min = timeRevert[0] + 24 * 60 - timeRevert[i];
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		List<String> timePoints = new ArrayList<>();
		timePoints.add("23:59");
		timePoints.add("00:00");

		MinimumTimeDifference m = new MinimumTimeDifference();
		System.out.println(m.findMinDifference(timePoints));
	}

}
