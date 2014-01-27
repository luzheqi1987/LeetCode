package lzq.leetcode.better.normal;

import lzq.leetcode.model.ListNode;

public class RotateList {
	/**
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: Given 1->2->3->4->5->NULL and k = 2, return
	 * 4->5->1->2->3->NULL.
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (null == head) {
			return null;
		}
		ListNode p = head;
		int length = 0;
		while (null != p) {
			p = p.next;
			length++;
		}
		if (n % length == 0) {
			return head;
		} else {
			n = n % length;
		}
		int num = n;
		ListNode first = head;
		ListNode second = head;
		while (num > 0) {
			first = first.next;
			num--;
		}

		while (null != first.next) {
			first = first.next;
			second = second.next;
		}

		ListNode newHead = second.next;
		second.next = null;
		first.next = head;
		return newHead;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = { 1, 2, 3 };
		ListNode l1 = new ListNode(i[0]);
		ListNode l2 = l1;
		for (int j = 1; j < i.length; j++) {
			l2.next = new ListNode(i[j]);
			l2 = l2.next;
		}
		ListNode l3 = new RotateList().rotateRight(l1, 3);
		while (l3 != null) {
			System.out.print(l3.val + " ");
			l3 = l3.next;
		}
	}
}
