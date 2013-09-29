package lzq.leetcode;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0) {
			ArrayList<TreeNode> node = new ArrayList<TreeNode>();
			node.add(null);
			return node;
		}
		return dfs(1, n);
	}

	ArrayList<TreeNode> dfs(int start, int end) {
		if (end - start < 0) {
			return null;
		} else if (end - start == 0) {
			ArrayList<TreeNode> node = new ArrayList<TreeNode>();
			node.add(new TreeNode(start));
			return node;
		}
		ArrayList<TreeNode> node = new ArrayList<TreeNode>();
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> leftNodes = dfs(start, i - 1);
			ArrayList<TreeNode> rightNodes = dfs(i + 1, end);
			if (null != leftNodes || null != rightNodes) {
				if (null == leftNodes) {
					for (TreeNode rightNode : rightNodes) {
						TreeNode newNode = new TreeNode(i);
						newNode.right = rightNode;
						node.add(newNode);
					}
				} else if (null == rightNodes) {
					for (TreeNode leftNode : leftNodes) {
						TreeNode newNode = new TreeNode(i);
						newNode.left = leftNode;
						node.add(newNode);
					}
				} else {
					for (TreeNode leftNode : leftNodes) {
						for (TreeNode rightNode : rightNodes) {
							TreeNode newNode = new TreeNode(i);
							newNode.left = leftNode;
							newNode.right = rightNode;
							node.add(newNode);
						}
					}
				}
			} else {
				TreeNode newNode = new TreeNode(i);
				node.add(newNode);
			}

		}
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> nodes = new UniqueBinarySearchTreesII()
				.generateTrees(3);

		System.out.println(nodes);
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
}
