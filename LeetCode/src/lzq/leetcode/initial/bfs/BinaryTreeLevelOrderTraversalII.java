package lzq.leetcode.initial.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	/**
	 * 
	 For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
	 * return its bottom-up level order traversal as: [ [15,7] [9,20], [3], ]
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
				layerValsCpy.addAll(layerVals);
				results.add(0, layerValsCpy);
				layerVals.clear();
			}
		}
		return results;
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
