package lzq.leetcode.initial.dfs;

public class SymmetricTree {
	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric:
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 But the following is not: 1 / \ 2 2 \ \ 3 3
	 * Note: Bonus points if you could solve it both recursively and
	 * iteratively.
	 * 
	 * confused what "{1,#,2,3}" means?
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return true;
		}
		return dfs(root.left, root.right);
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
		boolean leftResult = dfs(left.left, right.right);
		boolean rightResult = dfs(left.right, right.left);

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
