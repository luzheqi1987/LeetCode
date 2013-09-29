package lzq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> layerVals = new ArrayList<Integer>();
		queue.offer(root);
		int layerNumber = 1;
		int layer = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			layerVals.add(node.val);
			layerNumber--;
			if (null != node.left) {
				queue.offer(node.left);
			}
			if (null != node.right) {
				queue.offer(node.right);
			}

			if (layerNumber == 0) {
				layerNumber = queue.size();
				ArrayList<Integer> layerValsCpy = new ArrayList<Integer>();
				if (layer % 2 == 0) {
					for (int i = layerVals.size() - 1; i >= 0; i--) {
						layerValsCpy.add(layerVals.get(i));
					}
				} else {
					layerValsCpy.addAll(layerVals);
				}
				results.add(layerValsCpy);
				layerVals.clear();
				layer++;
			}
		}
		return results;
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
