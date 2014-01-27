package lzq.leetcode.initial.qs;

import java.util.ArrayList;
import java.util.Stack;

import lzq.leetcode.model.TreeNode;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == root) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || null != root) {
			if (null != root) {
				result.add(root.val);
				if (null != root.right) {
					stack.push(root);
				}
				root = root.left;
			} else {
				TreeNode node = stack.pop().right;
				result.add(node.val);
				if (null != node.right) {
					stack.push(node);
				}
				root = node.left;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
