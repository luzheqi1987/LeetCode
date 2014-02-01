package lzq.leetcode.better.knack;

public class UniqueBinarySearchTrees {
	/**
	 * Given n, how many structurally unique BST's (binary search trees) that
	 * store values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 * 
	 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
	 * 
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0) {
			return 0;
		}
		if (n <= 1)
			return 1;
		int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int size = 2; size <= n; ++size) {
			for (int i = 1; i <= size; ++i) {
				f[size] += f[i - 1] * f[size - i];
			}
		}
		return f[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = new UniqueBinarySearchTrees().numTrees(4);

		System.out.println(sum);
	}
}
