package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class LinkedListCycle {
	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == head) {
			return false;
		}
		ListNode first = head;
		ListNode second = head;
		while (first != null && first.next != null) {
			second = second.next;
			first = first.next.next;
			if (second.equals(first)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
