package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class MergeTwoSortedLists {
	/**
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (null == l1 && null == l2) {
			return null;
		} else if (null == l2) {
			return l1;
		} else if (null == l1) {
			return l2;
		}
		ListNode newList = new ListNode(0);
		ListNode p = newList;
		ListNode p1 = l1;
		ListNode p2 = l2;
		while (null != p1 && null != p2) {
			if (p1.val < p2.val) {
				ListNode node = new ListNode(p1.val);
				p.next = node;
				p = p.next;
				p1 = p1.next;
			} else {
				ListNode node = new ListNode(p2.val);
				p.next = node;
				p = p.next;
				p2 = p2.next;
			}
		}
		if (null != p1) {
			p.next = p1;
		} else if (null != p2) {
			p.next = p2;
		}
		return newList.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
