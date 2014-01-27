package lzq.leetcode.initial.dfs;

import lzq.leetcode.model.ListNode;
import lzq.leetcode.model.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return dfs(head);
	}

	TreeNode dfs(ListNode head) {
		TreeNode node = null;

		if (head != null) {
			ListNode perMidNode = null;
			ListNode midNode = head;
			ListNode lastNode = head;
			while (null != lastNode.next && null != lastNode.next.next) {
				perMidNode = midNode;
				midNode = midNode.next;
				lastNode = lastNode.next.next;
			}
			if (null != perMidNode) {
				perMidNode.next = null;
			}
			node = new TreeNode(midNode.val);
			TreeNode left = dfs(perMidNode == null ? null : head);
			TreeNode right = dfs(midNode.next);
			node.left = left;
			node.right = right;
		}
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListtoBinarySearchTree sc = new ConvertSortedListtoBinarySearchTree();
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		l0.next = l1;

		TreeNode node = sc.sortedListToBST(l0);

		System.out.println(node);
	}

}
