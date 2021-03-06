package lzq.leetcode.better.normal;

import lzq.leetcode.model.ListNode;
import lzq.leetcode.util.LeetCodeUtil;

public class AddTwoNumbers {
	/**
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	//do this like the "Add Binary"
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode cpyl1 = l1;
		ListNode cpyl2 = l2;
		ListNode result = new ListNode(0);
		ListNode tmpResult = result;
		int c = 0;
		// contains all cases
		while (null != cpyl1 || null != cpyl2 || c > 0) {
			int tmp = c;
			if (null != cpyl1) {
				tmp += cpyl1.val;
				cpyl1 = cpyl1.next;
			}
			if (null != cpyl2) {
				tmp += cpyl2.val;
				cpyl2 = cpyl2.next;
			}
			// calculate the carry
			c = tmp / 10;

			tmpResult.next = new ListNode(tmp % 10);
			tmpResult = tmpResult.next;
		}
		return result.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		ListNode node0 = new ListNode(0);
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
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(2);
		ListNode node13 = new ListNode(3);
		ListNode node14 = new ListNode(4);
		ListNode node15 = new ListNode(5);
		ListNode node16 = new ListNode(6);
		ListNode node17 = new ListNode(7);
		ListNode node18 = new ListNode(8);
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
		node16.next = node17;
		node17.next = node18;
		ListNode node21 = new ListNode(1);
		ListNode node22 = new ListNode(2);
		ListNode node23 = new ListNode(3);
		ListNode node24 = new ListNode(4);
		ListNode node25 = new ListNode(5);
		ListNode node26 = new ListNode(6);
		ListNode node27 = new ListNode(7);
		ListNode node28 = new ListNode(8);
		node21.next = node22;
		node22.next = node23;
		node23.next = node24;
		node25.next = node26;
		node26.next = node27;
		node27.next = node28;
		LeetCodeUtil
				.printlist(new AddTwoNumbers().addTwoNumbers(node1, node11));
	}
}
