package lzq.leetcode.initial.dfs;

import lzq.leetcode.model.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 * 
	 * @param num
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length <= 0) {
			return null;
		}
		return dfs(num, 0, num.length - 1);
	}

	TreeNode dfs(int[] num, int min, int max) {
		TreeNode node = null;

		if (min <= max) {
			int mid = (max + min) / 2;
			node = new TreeNode(num[mid]);
			TreeNode left = dfs(num, min, mid - 1);
			TreeNode right = dfs(num, mid + 1, max);
			node.left = left;
			node.right = right;
		}
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 0, 1, 2, 3, 4 };
		TreeNode node = new ConvertSortedArraytoBinarySearchTree()
				.sortedArrayToBST(num);

		System.out.println(node);
	}
}
