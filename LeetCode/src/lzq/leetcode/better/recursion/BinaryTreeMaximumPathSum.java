package lzq.leetcode.better.recursion;

import lzq.leetcode.model.TreeNode;

public class BinaryTreeMaximumPathSum {
	int max;

	/**
	 * Given a binary tree, find the maximum path sum.
	 * 
	 * The path may start and end at any node in the tree.
	 * 
	 * For example: Given the below binary tree,
	 * 
	 * 1 / \ 2 3 Return 6.
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return 0;
		}
		if (null == root.left && null == root.right) {
			return root.val;
		}
		this.max = Integer.MIN_VALUE;
		calcMax(root);
		return this.max;
	}

	private int calcMax(TreeNode root) {
		if (null == root) {
			return 0;
		}
		if (null == root.left && null == root.right) {
			this.max = this.max > root.val ? this.max : root.val;
			return root.val;
		}
		int left = 0;
		int right = 0;
		if (null != root.left) {
			left = calcMax(root.left);
		}
		if (null != root.right) {
			right = calcMax(root.right);
		}
		int localMax = root.val;
		if (left > 0) {
			localMax += left;
		}
		if (right > 0) {
			localMax += right;
		}

		this.max = Math.max(this.max, localMax);
		return Math.max(root.val, Math.max(left, right) + root.val);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum sl = new BinaryTreeMaximumPathSum();
		TreeNode tn2 = new TreeNode(1);
		tn2.left = null;
		tn2.right = null;
		TreeNode tn3 = new TreeNode(3);
		tn3.left = null;
		tn3.right = null;
		TreeNode tn1 = new TreeNode(-2);
		tn1.left = tn2;
		tn1.right = null;
		int sum = sl.maxPathSum(tn1);

		System.out.println(sum);
	}

}
