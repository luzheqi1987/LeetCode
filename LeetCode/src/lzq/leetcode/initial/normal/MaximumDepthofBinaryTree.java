package lzq.leetcode.initial.normal;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
	/**
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int layer = 1;
		int layerNumbers = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			layerNumbers--;

			if (null != node.left) {
				queue.offer(node.left);
			}
			if (null != node.right) {
				queue.offer(node.right);
			}
			if (layerNumbers == 0 && !queue.isEmpty()) {
				layerNumbers = queue.size();
				layer++;
			}
		}
		return layer;
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
