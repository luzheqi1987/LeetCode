package lzq.leetcode.initial.normal;

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
		ListNode round1 = null;
		ListNode p = head;
		int length = 0;
		while (null != p) {
			ListNode node = new ListNode(p.val);
			node.next = round1;
			p = p.next;
			round1 = node;
			length++;
		}
		if (n % length == 0) {
			return head;
		} else {
			n = n % length;
		}
		int num = 0;
		ListNode round2 = null;
		ListNode p1 = round1;
		while (num < n) {
			ListNode node = new ListNode(p1.val);
			node.next = round2;
			p1 = p1.next;
			round2 = node;
			num++;
		}

		ListNode round3 = new ListNode(0);
		ListNode round3Cpy = round3;
		ListNode p2 = round2;
		while (null != p2) {
			ListNode node = new ListNode(p2.val);
			p2 = p2.next;
			round3Cpy.next = node;
			round3Cpy = round3Cpy.next;
		}
		while (null != p1) {
			ListNode node = new ListNode(p1.val);
			node.next = round3Cpy.next;
			round3Cpy.next = node;
			p1 = p1.next;
		}
		return round3.next;
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
