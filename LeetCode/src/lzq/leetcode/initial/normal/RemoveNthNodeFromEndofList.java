package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class RemoveNthNodeFromEndofList {
	/**
	 * Given a linked list, remove the nth node from the end of list and return
	 * its head.
	 * 
	 * For example,
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one
	 * pass.
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 1 || null == head) {
			return head;
		}
		ListNode pre = head;
		int i = 0;
		for (i = 1; i <= n && null != pre; i++) {
			pre = pre.next;
		}
		ListNode last = head;
		ListNode preLast = null;
		while (null != pre) {
			pre = pre.next;
			preLast = last;
			last = last.next;
		}
		if (null != preLast) {
			preLast.next = last.next;
		} else if (i == n + 1) {
			return head.next;
		} else {
			return head;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		printNode(new RemoveNthNodeFromEndofList().removeNthFromEnd(node1, 9));
	}

	static void printNode(ListNode node) {
		while (null != node) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}

}
