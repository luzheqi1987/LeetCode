package lzq.leetcode.initial.knack;

import lzq.leetcode.model.ListNode;

public class LinkedListCycleII {
	/**
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 * 
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		// Empty linked list
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		// Find meeting point
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}

		// Error - there is no meeting point, and therefore no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		/*
		 * Move slow to Head. Keep fast at meeting Point. Each are k steps from
		 * the loop Start. If they move at the same pace, they must meet at Loop
		 * Start.
		 */
		slow = head;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		// Now fast points to the start of the loop.
		return fast;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
