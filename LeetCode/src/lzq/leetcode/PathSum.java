package lzq.leetcode;


public class PathSum {
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
