package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

public class FreedomTrail {
	Map<String, Map<Integer, Integer>> cache = new HashMap<>();

	public int findRotateSteps1(String ring, String key) {
		int n = ring.length();
		int m = key.length();
		int[][] dp = new int[m + 1][n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					if (ring.charAt(k) == key.charAt(i)) {
						int diff = Math.abs(j - k);
						int step = Math.min(diff, n - diff);
						dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
					}
				}
			}
		}

		return dp[0][0] + m;
	}

	public int findRotateSteps(String ring, String key) {
		if (ring == null || ring.length() <= 0 || key == null
				|| key.length() <= 0) {
			return 0;
		}

		return findRotateSteps(ring, key, 0);
	}

	public int findRotateSteps(String ring, String key, int index) {
		if (index == key.length()) {
			return 0;
		}
		String curRing = ring;
		char c = key.charAt(index);
		if (cache.containsKey(ring) && cache.get(ring).containsKey(index)) {
			return cache.get(ring).get(index);
		}
		int first = curRing.indexOf(c);
		int last = curRing.lastIndexOf(c);
		int firstStep = 1 + first
				+ findRotateSteps(rollString(curRing, first), key, index + 1);
		int lastStep = 1 + ring.length() - last
				+ findRotateSteps(rollString(curRing, last), key, index + 1);

		int step = Math.min(firstStep, lastStep);
		Map<Integer, Integer> indexStep = cache.getOrDefault(ring,
				new HashMap<Integer, Integer>());
		indexStep.put(index, step);
		cache.put(ring, indexStep);
		return step;
	}

	private String revertString(String str) {
		char[] strArray = str.toCharArray();
		int len = strArray.length;
		char temp;
		for (int i = 0; i < len / 2; i++) {
			temp = strArray[i];
			strArray[i] = strArray[len - i - 1];
			strArray[len - i - 1] = temp;
		}
		return String.valueOf(strArray);
	}

	private String rollString(String str, int index) {
		String first = revertString(str.substring(0, index));
		String second = revertString(str.substring(index));
		return revertString(first + second);
	}

	public static void main(String[] args) {
		// String ring = "nyngl";
		// String key = "yyynnnnnnlllggg";

		String ring = "caotmcaataijjxi";
		String key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";

		FreedomTrail ft = new FreedomTrail();
		System.out.println(ft.findRotateSteps(ring, key));
	}

}
