package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class RemoveDuplicatesfromSortedList {
	/**
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == head) {
			return null;
		}
		ListNode node = new ListNode(head.val);
		ListNode next = head.next;
		ListNode currentNode = node;
		while (null != next) {
			if (next.val > currentNode.val) {
				currentNode.next = new ListNode(next.val);
				currentNode = currentNode.next;
			} else {
				next = next.next;
			}
		}
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
