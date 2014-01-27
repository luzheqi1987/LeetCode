package lzq.leetcode.initial.bfs;

import java.util.LinkedList;
import java.util.Queue;

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
		bfs(root);
	}

	private void bfs(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int queueNumber = 1;
		int layerNumber = 0;
		TreeLinkNode tempNode = null;
		while (!queue.isEmpty()) {
			tempNode = queue.poll();
			queueNumber--;
			if (null != tempNode.left) {
				queue.offer(tempNode.left);
				layerNumber++;
			}
			if (null != tempNode.right) {
				queue.offer(tempNode.right);
				layerNumber++;
			}
			if (queueNumber != 0) {
				tempNode.next = queue.peek();
			} else {
				tempNode.next = null;
			}

			if (queueNumber == 0 && layerNumber != 0) {
				queueNumber = layerNumber;
				layerNumber = 0;
			}
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
