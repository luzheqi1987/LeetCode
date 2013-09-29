package lzq.leetcode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return true;
		}
		return checkBalanced(root) != -1;
	}

	public int checkBalanced(TreeNode root) {
		if (null == root) {
			return 0;
		}
		int left = checkBalanced(root.left);
		int right = checkBalanced(root.right);

		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBinaryTree sl = new BalancedBinaryTree();
		TreeNode tn2 = sl.new TreeNode(2);
		TreeNode tn3 = sl.new TreeNode(3);
		TreeNode tn1 = sl.new TreeNode(1);
		tn2.left = tn1;
		tn2.right = tn3;
		boolean b = sl.isBalanced(tn2);

		System.out.println(b);
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
