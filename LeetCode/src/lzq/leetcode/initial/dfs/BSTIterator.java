package lzq.leetcode.initial.dfs;

import java.util.Stack;

import lzq.leetcode.model.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		TreeNode temp = root;
		while (null != temp) {
			stack.push(temp);
			temp = temp.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (!stack.empty()) {
			return true;
		}
		return false;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode temp = stack.pop();
		if (null != temp.right) {
			TreeNode newTemp = temp.right;
			while (null != newTemp) {
				stack.push(newTemp);
				newTemp = newTemp.left;
			}
		}
		return temp.val;
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
