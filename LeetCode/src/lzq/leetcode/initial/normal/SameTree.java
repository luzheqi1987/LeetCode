package lzq.leetcode.initial.normal;

public class SameTree {
	/**
	 * Given two binary trees, write a function to check if they are equal or
	 * not.
	 * 
	 * Two binary trees are considered equal if they are structurally identical
	 * and the nodes have the same value.
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return dfs(p, q);
	}

	boolean dfs(TreeNode left, TreeNode right) {
		if ((null != left && null == right) || (null == left)
				&& (null != right)) {
			return false;
		} else if (left == null && right == null) {
			return true;
		} else if (left.val != right.val) {
			return false;
		}
		boolean leftResult = dfs(left.left, right.left);
		boolean rightResult = dfs(left.right, right.right);

		return (leftResult && rightResult) ? true : false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
