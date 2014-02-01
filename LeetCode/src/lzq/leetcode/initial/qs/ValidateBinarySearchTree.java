package lzq.leetcode.initial.qs;

import java.util.Stack;

import lzq.leetcode.model.TreeNode;

public class ValidateBinarySearchTree {
	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 * 
	 * @param root
	 * @return
	 */
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
		TreeNode t1_1 = new TreeNode(1);
		TreeNode t1_2 = new TreeNode(1);
		t1_1.right = t1_2;

		boolean is = v.isValidBST(t1_1);

		System.out.println(is);
	}
}
