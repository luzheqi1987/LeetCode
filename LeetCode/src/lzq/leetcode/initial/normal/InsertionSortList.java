package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class InsertionSortList {
	/**
	 * Sort a linked list using insertion sort.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode node = new ListNode(0);
		ListNode tmp = head;
		while (null != tmp) {
			ListNode next = tmp.next;
			if (node.next == null) {
				tmp.next = node.next;
				node.next = tmp;
			} else {
				ListNode tmpNode = node;
				while (null != tmpNode.next && tmpNode.next.val <= tmp.val) {
					tmpNode = tmpNode.next;
				}
				tmp.next = tmpNode.next;
				tmpNode.next = tmp;
			}
			tmp = next;
		}
		return node.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		new InsertionSortList().insertionSortList(n1);
	}

}
