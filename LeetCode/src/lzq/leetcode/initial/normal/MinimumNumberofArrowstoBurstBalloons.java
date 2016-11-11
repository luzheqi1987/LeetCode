package lzq.leetcode.initial.normal;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {

	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0) {
			return 0;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		long lastEnd = Long.MIN_VALUE;
		int minArrows = 0;
		for (int i = 0; i < points.length; i++) {
			if (lastEnd < points[i][0]) {
				lastEnd = points[i][1];
				minArrows++;
			}
		}
		return minArrows;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
