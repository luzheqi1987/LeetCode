package lzq.leetcode.initial.dfs;

public class SumRoot2LeafNumbers {
	private int sum;

	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf
	 * path could represent a number.
	 * 
	 * An example is the root-to-leaf path 1->2->3 which represents the number
	 * 123.
	 * 
	 * Find the total sum of all root-to-leaf numbers.
	 * 
	 * For example,
	 * 
	 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
	 * root-to-leaf path 1->3 represents the number 13.
	 * 
	 * Return the sum = 12 + 13 = 25.
	 * 
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		this.sum = 0;
		dfs(root, 0);
		return this.sum;
	}

	private void dfs(TreeNode root, int val) {
		if (null == root) {
			return;
		}
		if (null == root.left && null == root.right) {
			this.sum += root.val + val * 10;
		}
		if (null != root.left) {
			dfs(root.left, val * 10 + root.val);
		}
		if (null != root.right) {
			dfs(root.right, val * 10 + root.val);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumRoot2LeafNumbers sl = new SumRoot2LeafNumbers();
		TreeNode tn2 = sl.new TreeNode(2);
		tn2.left = null;
		tn2.right = null;
		TreeNode tn3 = sl.new TreeNode(3);
		tn3.left = null;
		tn3.right = null;
		TreeNode tn1 = sl.new TreeNode(1);
		tn1.left = tn2;
		tn1.right = tn3;
		int sum = sl.sumNumbers(tn1);

		System.out.println(sum);
	}

	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
