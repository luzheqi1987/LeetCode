package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class RemoveDuplicatesfromSortedListII {
	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given
	 * 1->1->1->2->3, return 2->3.
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
		ListNode node = new ListNode(0);
		ListNode next = head.next;
		int currentVal = head.val;
		ListNode currentNode = node;
		boolean isDouble = false;
		while (null != next) {
			if (next.val > currentVal) {
				if (!isDouble) {
					currentNode.next = new ListNode(currentVal);
					currentNode = currentNode.next;
				}
				isDouble = false;
				currentVal = next.val;
			} else if (next.val == currentVal) {
				isDouble = true;
			}
			next = next.next;
		}
		if (!isDouble) {
			currentNode.next = new ListNode(currentVal);
		}
		return node.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		ListNode node = new RemoveDuplicatesfromSortedListII()
				.deleteDuplicates(node1);

		System.out.println(node);

	}
}
