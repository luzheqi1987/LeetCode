package lzq.leetcode;


public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0) {
			return 0;
		}
		return dfs(1, n);
	}

	int dfs(int start, int end) {
		if (end - start <= 0) {
			return 1;
		} else if (end - start == 1) {
			return 2;
		} else if (end - start == 2) {
			return 5;
		}
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += dfs(start, i - 1) * dfs(i + 1, end);
		}
		return sum;
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
