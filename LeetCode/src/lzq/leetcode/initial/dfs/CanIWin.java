package lzq.leetcode.initial.dfs;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
	Map<Integer, Boolean> cache = new HashMap<>();
	boolean[] usage;

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		usage = new boolean[maxChoosableInteger + 1];

		if (maxChoosableInteger >= desiredTotal) {
			return true;
		}
		if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
			return false;
		}
		return winAble(0, 0, desiredTotal);
	}

	public boolean winAble(int used, int currentSum, int desiredTotal) {
		if (currentSum >= desiredTotal) {
			return false;
		}
		int key = used;
		if (!cache.containsKey(key)) {
			for (int i = 1; i < usage.length; i++) {
				if (!usage[i]) {
					usage[i] = true;
					used |= 1 << i;
					if (!winAble(used, currentSum + i, desiredTotal)) {
						cache.put(key, true);
						usage[i] = false;
						return true;
					}
					usage[i] = false;
					used ^= 1 << i;
				}
			}
			cache.put(key, false);
		}
		return cache.get(key);
	}

	public static void main(String[] args) {
		CanIWin canIWin = new CanIWin();
		System.out.println(canIWin.canIWin(10, 40));
	}

}
