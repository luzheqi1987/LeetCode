package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class PartitionList {
	/**
	 * Given a linked list and a value x, partition it such that all nodes less
	 * than x come before nodes greater than or equal to x.
	 * 
	 * You should preserve the original relative order of the nodes in each of
	 * the two partitions.
	 * 
	 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode p1 = new ListNode(0);
		ListNode q1 = new ListNode(0);
		ListNode p2 = p1;
		ListNode q2 = q1;

		while (head != null) {
			if (x > head.val) {
				p2.next = new ListNode(head.val);
				p2 = p2.next;
			} else {
				q2.next = new ListNode(head.val);
				q2 = q2.next;
			}
			head = head.next;
		}
		if (null != q1.next) {
			p2.next = q1.next;
		}
		return p1.next;
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		// l2.next = l3;
		// l3.next = l4;
		// l4.next = l5;
		// l5.next = l6;

		ListNode o = new PartitionList().partition(l1, 2);

		System.out.println(o);
	}

}
