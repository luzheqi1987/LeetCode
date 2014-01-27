package lzq.leetcode.initial.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationsII {
	/**
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, [1,1,2] have the following unique permutations: [1,1,2],
	 * [1,2,1], and [2,1,1].
	 * 
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int n : num) {
			numbers.add(n);
		}
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>(
				dfs(numbers));
		return results;
	}

	Set<ArrayList<Integer>> dfs(ArrayList<Integer> numbers) {
		if (numbers.size() <= 1) {
			Set<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
			ArrayList<Integer> result = new ArrayList<Integer>(numbers);
			results.add(result);
			return results;
		}
		Set<ArrayList<Integer>> results = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> newNumbers = new ArrayList<Integer>(numbers);
		for (int i = 0; i < numbers.size(); i++) {
			Integer number = numbers.get(i);
			newNumbers.remove(number);
			Set<ArrayList<Integer>> res = dfs(newNumbers);
			for (ArrayList<Integer> re : res) {
				re.add(0, number);
				results.add(re);
			}
			newNumbers.add(number);
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1, 1, 0, 0, 1, -1, -1, 1 };
		ArrayList<ArrayList<Integer>> results = new PermutationsII()
				.permute(num);
		System.out.println(results);
	}
}
