package lzq.leetcode;

import java.util.ArrayList;

import lzq.leetcode.SumRoot2LeafNumbers.TreeNode;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> list = inorder(root);
		TreeNode err1 = null;
		TreeNode err2 = null;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).val > list.get(i + 1).val) {
				if (null == err1) {
					err1 = list.get(i);
				} else {
					err2 = list.get(i + 1);
					break;
				}
			}
		}
		if (null != err1 && null != err2) {
			int tmp = err1.val;
			err1.val = err2.val;
			err2.val = tmp;
		} else if (null != err1) {
			int index = list.indexOf(err1);
			int tmp = list.get(index + 1).val;
			list.get(index + 1).val = err1.val;
			err1.val = tmp;
		}
	}

	ArrayList<TreeNode> inorder(TreeNode node) {
		if (null == node.left && null == node.right) {
			ArrayList<TreeNode> list = new ArrayList<TreeNode>();
			list.add(node);
			return list;
		}
		ArrayList<TreeNode> list = null;
		if (null != node.left) {
			list = inorder(node.left);
		}
		if (null == list) {
			list = new ArrayList<TreeNode>();
		}
		list.add(node);
		if (null != node.right) {
			ArrayList<TreeNode> listRight = inorder(node.right);
			list.addAll(listRight);
		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoverBinarySearchTree sl = new RecoverBinarySearchTree();
		TreeNode tn2 = sl.new TreeNode(2);
		TreeNode tn3 = sl.new TreeNode(3);
		TreeNode tn1 = sl.new TreeNode(1);
		tn3.right = tn1;
		tn3.left = tn2;
		sl.recoverTree(tn3);
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
