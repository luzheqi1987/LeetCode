package lzq.leetcode;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return;
		}
		TreeNode newRoot = new TreeNode(0);
		TreeNode cpyRoot = newRoot;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			cpyRoot.right = stack.pop();
			cpyRoot.left = null;
			cpyRoot = cpyRoot.right;
			while (cpyRoot.left != null) {
				if (cpyRoot.right != null) {
					stack.push(cpyRoot.right);
				}
				cpyRoot.right = cpyRoot.left;
				cpyRoot.left = null;
				cpyRoot = cpyRoot.right;
			}
			if (cpyRoot.right != null) {
				stack.push(cpyRoot.right);
			}
		}
		root = newRoot.right;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenBinaryTreetoLinkedList sl = new FlattenBinaryTreetoLinkedList();
		TreeNode tn1 = sl.new TreeNode(1);
		TreeNode tn2 = sl.new TreeNode(2);
		TreeNode tn3 = sl.new TreeNode(3);
		TreeNode tn4 = sl.new TreeNode(4);
		TreeNode tn5 = sl.new TreeNode(5);
		TreeNode tn6 = sl.new TreeNode(6);
		tn1.left = tn2;
		tn1.right = tn5;
		tn2.left = tn3;
		tn2.right = tn4;
		tn5.right = tn6;
		sl.flatten(tn1);

		System.out.println(tn1);
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
