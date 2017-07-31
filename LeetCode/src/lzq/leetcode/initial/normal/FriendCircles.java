package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FriendCircles {
	Map<Integer, Set<Integer>> circles = new HashMap<>();
	Set<Set<Integer>> circleSet = new HashSet<>();
	Set<Integer> calced = new HashSet<>();

	public int findCircleNum(int[][] M) {
		int sum = 0;
		for (int i = 0; i < M.length; i++) {
			if (calced.contains(i)) {
				continue;
			} else {
				find(i, M);
			}
			sum++;
		}
		return sum;
	}

	private void find(int i, int[][] M) {
		calced.add(i);
		for (int j = 0; j < M.length; j++) {
			if (i != j) {
				if (M[i][j] == 1 && !calced.contains(j)) {
					find(j, M);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] numbers = new int[][] {
				{ 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 } };
		System.out.println(new FriendCircles().findCircleNum(numbers));
	}
}
