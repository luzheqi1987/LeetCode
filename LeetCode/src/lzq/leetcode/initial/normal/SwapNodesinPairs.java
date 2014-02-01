package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class SwapNodesinPairs {
	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode newHead = new ListNode(0);
		ListNode tmpHead = newHead;
		ListNode tmp = head;
		while (null != tmp && null != tmp.next) {
			ListNode first = tmp;
			ListNode second = tmp.next;
			tmp = second.next;
			tmpHead.next = second;
			tmpHead.next.next = first;
			tmpHead = tmpHead.next.next;
		}
		if (null != tmp) {
			tmpHead.next = tmp;
			tmpHead = tmpHead.next;
		}
		tmpHead.next = null;
		return newHead.next;
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
		printNode(new SwapNodesinPairs().swapPairs(node1));
	}

	static void printNode(ListNode node) {
		while (null != node) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}

}
