package lzq.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
