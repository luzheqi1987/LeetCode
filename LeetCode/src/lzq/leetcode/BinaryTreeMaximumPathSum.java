package lzq.leetcode;


/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BinaryTreeMaximumPathSum {
	int max;

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
		int tmpMax = left + right + root.val > root.val ? left + right
				+ root.val : root.val;
		int tmpLRMax = right + root.val > left + root.val ? right + root.val
				: left + root.val;
		tmpMax = tmpMax > tmpLRMax ? tmpMax : tmpLRMax;
		this.max = this.max > tmpMax ? this.max : tmpMax;
		return tmpLRMax > root.val ? tmpLRMax : root.val;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum sl = new BinaryTreeMaximumPathSum();
		TreeNode tn2 = sl.new TreeNode(1);
		tn2.left = null;
		tn2.right = null;
		TreeNode tn3 = sl.new TreeNode(3);
		tn3.left = null;
		tn3.right = null;
		TreeNode tn1 = sl.new TreeNode(-2);
		tn1.left = tn2;
		tn1.right = null;
		int sum = sl.maxPathSum(tn1);

		System.out.println(sum);
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
