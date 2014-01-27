package lzq.leetcode.better.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
	/**
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, [1,1,2] have the following unique permutations: [1,1,2],
	 * [1,2,1], and [2,1,1].
	 * 
	 * 
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		permuteUtil(num, used, path, allPath);
		return allPath;
	}

	void permuteUtil(int[] num, boolean[] used, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> allPath) {
		if (path.size() == num.length) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(path);
			allPath.add(tmp);
			return;
		}
		for (int i = 0; i < num.length; ++i) {
			if (i >= 1 && num[i] == num[i - 1] && used[i - 1] == false) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				path.add((Integer) num[i]);
				permuteUtil(num, used, path, allPath);
				path.remove(path.size() - 1);
				used[i] = false;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 2, 2, 1, 1 };
		ArrayList<ArrayList<Integer>> results = new PermutationsII()
				.permuteUnique(num);
		System.out.println(results);
	}
}
