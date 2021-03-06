package lzq.leetcode.initial.normal;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
	/**
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
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

			if (null == node.left && null == node.right) {
				break;
			}
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
