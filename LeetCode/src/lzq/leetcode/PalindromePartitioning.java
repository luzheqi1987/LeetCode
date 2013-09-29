package lzq.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		if (s == null || s.length() == 0)
			return new ArrayList<ArrayList<String>>();
		boolean[][] isPalindromes = new boolean[s.length()][s.length()];
		int[] pa = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			isPalindromes[i][i] = true;
			pa[i] = 0;
		}
		for (int i = s.length() - 2; i >= 0; i--) {
			isPalindromes[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			for (int j = i + 2; j < s.length(); j++)
				isPalindromes[i][j] = (s.charAt(i) == s.charAt(j))
						&& isPalindromes[i + 1][j - 1];
		}
		return getPalindromes(s, isPalindromes, 0);
	}

	private ArrayList<ArrayList<String>> getPalindromes(String s,
			boolean[][] isPalindromes, int start) {
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		if (start > s.length() - 1) {
			results.add(new ArrayList<String>());
			return results;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindromes[start][i]) {
				for (ArrayList<String> subPa : getPalindromes(s, isPalindromes,
						i + 1)) {
					subPa.add(0, s.substring(start, i + 1));
					results.add(subPa);
				}

			}
		}
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aab";
		ArrayList<ArrayList<String>> results = new PalindromePartitioning()
				.partition(str);
		System.out.println(results);
	}

}
