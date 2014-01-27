package lzq.leetcode.better.normal;

import lzq.leetcode.model.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
	/**
	 * Given a binary tree
	 * 
	 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right;
	 * TreeLinkNode *next; } Populate each next pointer to point to its next
	 * right node. If there is no next right node, the next pointer should be
	 * set to NULL.
	 * 
	 * Initially, all next pointers are set to NULL.
	 * 
	 * Note:
	 * 
	 * You may only use constant extra space. You may assume that it is a
	 * perfect binary tree (ie, all leaves are at the same level, and every
	 * parent has two children). For example, Given the following perfect binary
	 * tree, 1 / \ 2 3 / \ / \ 4 5 6 7 After calling your function, the tree
	 * should look like: 1 -> NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL
	 * 
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return;
		}
		TreeLinkNode tmp = root;
		while (null != tmp) {
			TreeLinkNode cur = tmp;
			TreeLinkNode prev = null;

			while (null != cur) {
				if (prev != null) {
					prev.next = cur.left;
				}// ...
				if (cur.left != null) {
					cur.left.next = cur.right;
					prev = cur.right;
				}// full tree
				else {
					break;
				}// ...
				cur = cur.next;
			}
			if (prev != null) {
				prev.next = null;
			}
			tmp = tmp.left;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersinEachNode sl = new PopulatingNextRightPointersinEachNode();
		TreeLinkNode tn2 = new TreeLinkNode(2);
		tn2.left = null;
		tn2.right = null;
		TreeLinkNode tn3 = new TreeLinkNode(3);
		tn3.left = null;
		tn3.right = null;
		TreeLinkNode tn1 = new TreeLinkNode(1);
		tn1.left = tn2;
		tn1.right = tn3;
		sl.connect(tn1);

		System.out.println(tn1);
	}
}
