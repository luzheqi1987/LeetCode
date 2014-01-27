package lzq.leetcode.initial.normal;

public class PathSum {
	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11
	 * 13 4 / \ \ 7 2 1 return true, as there exist a root-to-leaf path
	 * 5->4->11->2 which sum is 22.
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return false;
		}
		return dfs(root, 0, sum);
	}

	private boolean dfs(TreeNode root, int current, int sum) {
		if (root.left == null && root.right == null) {
			if (current + root.val == sum) {
				return true;
			} else {
				return false;
			}
		}
		boolean is = false;
		if (root.left != null) {
			is = dfs(root.left, current + root.val, sum);
		}
		if (is) {
			return is;
		}
		if (root.right != null) {
			is = dfs(root.right, current + root.val, sum);
		}
		return is;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum sl = new PathSum();
		TreeNode tn1 = sl.new TreeNode(1);
		TreeNode tn2 = sl.new TreeNode(-2);
		TreeNode tn3 = sl.new TreeNode(-3);
		TreeNode tn4 = sl.new TreeNode(1);
		TreeNode tn5 = sl.new TreeNode(3);
		TreeNode tn6 = sl.new TreeNode(-2);
		TreeNode tn7 = sl.new TreeNode(-1);
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.left = tn6;
		tn4.left = tn7;

		boolean is = sl.hasPathSum(tn1, -4);
		System.out.println(is);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
