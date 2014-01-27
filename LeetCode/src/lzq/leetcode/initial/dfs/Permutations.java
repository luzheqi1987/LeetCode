package lzq.leetcode.initial.dfs;

import java.util.ArrayList;

public class Permutations {
	/**
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
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
		return dfs(numbers);
	}

	ArrayList<ArrayList<Integer>> dfs(ArrayList<Integer> numbers) {
		if (numbers.size() <= 1) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> result = new ArrayList<Integer>(numbers);
			results.add(result);
			return results;
		}
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> newNumbers = new ArrayList<Integer>(numbers);
		for (int i = 0; i < numbers.size(); i++) {
			Integer number = numbers.get(i);
			newNumbers.remove(number);
			ArrayList<ArrayList<Integer>> res = dfs(newNumbers);
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
		int[] num = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> results = new Permutations().permute(num);
		System.out.println(results);
	}
}
