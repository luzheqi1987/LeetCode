package lzq.leetcode.initial.normal;

import java.util.Stack;

import lzq.leetcode.model.ListNode;

public class ReverseLinkedListII {
	/**
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of
	 * list.
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ListNode tmpHead = head;
		Stack<Integer> stack = new Stack<Integer>();
		int number = 1;
		if (tmpHead != null) {
			while (tmpHead != null && number < m) {
				tmpHead = tmpHead.next;
				number++;
			}
			ListNode tmp = tmpHead;
			while (tmp != null && number <= n) {
				stack.push(tmp.val);
				tmp = tmp.next;
				number++;
			}
			if (number > n) {
				while (!stack.isEmpty()) {
					tmpHead.val = stack.pop();
					tmpHead = tmpHead.next;
				}
			}
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		printNode(new ReverseLinkedListII().reverseBetween(node1, 3, 4));
	}

	static void printNode(ListNode node) {
		while (null != node) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}

}
