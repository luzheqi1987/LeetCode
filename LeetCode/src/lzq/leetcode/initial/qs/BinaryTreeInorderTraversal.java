package lzq.leetcode.initial.qs;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	/**
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree {1,#,2,3},
	 * 
	 * 1 \ 2 / 3 return [1,3,2].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * confused what "{1,#,2,3}" means? > read more on how binary tree is
	 * serialized on OJ.
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (!stack.isEmpty() || null != node) {
			if (null == node) {
				node = stack.pop();
				inorder.add(node.val);
				node = node.right;
			} else {
				stack.push(node);
				node = node.left;
			}
		}
		return inorder;
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
