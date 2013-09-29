package lzq.leetcode;

import java.util.Stack;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = new TreeNode(Integer.MIN_VALUE);
		TreeNode now = root;
		while (!stack.isEmpty() || null != now) {
			if (null == now) {
				now = stack.pop();
				if (pre.val >= now.val) {
					return false;
				}
				pre = now;
				now = now.right;
			} else {
				stack.push(now);
				now = now.left;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		TreeNode t1_1 = v.new TreeNode(1);
		TreeNode t1_2 = v.new TreeNode(1);
		t1_1.right = t1_2;

		boolean is = v.isValidBST(t1_1);

		System.out.println(is);
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
