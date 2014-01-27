package lzq.leetcode.initial.qs;

import java.util.ArrayList;
import java.util.Stack;

import lzq.leetcode.model.TreeNode;

public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == root) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || null != root) {
			if (null != root) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.peek();
				if (null != root.right) {
					TreeNode right = root.right;
					stack.peek().left = null;
					stack.peek().right = null;
					stack.push(right);
					root = right.left;
				} else {
					stack.pop();
					result.add(root.val);
					root = null;
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.right = n2;
		
		new BinaryTreePostorderTraversal().postorderTraversal(n1);

	}

}
