package lzq.leetcode.initial.normal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import lzq.leetcode.model.ListNode;

public class ReorderList {
	/**
	 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to:
	 * L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
	 * 
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 * 
	 * @param head
	 */
	public void reorderList(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == head) {
			return;
		}
		ListNode tmpHead = head;
		int size = 0;
		while (tmpHead != null) {
			size++;
			tmpHead = tmpHead.next;
		}
		Queue<ListNode> q = new LinkedList<ListNode>();
		Stack<ListNode> s = new Stack<ListNode>();

		tmpHead = head;
		for (int i = 0; i < (size + 1) / 2; i++) {
			q.offer(tmpHead);
			tmpHead = tmpHead.next;
		}
		while (tmpHead != null) {
			s.push(tmpHead);
			tmpHead = tmpHead.next;
		}
		ListNode newNode = new ListNode(0);
		ListNode newTmpNode = newNode;
		while (!q.isEmpty() && !s.isEmpty()) {
			newTmpNode.next = q.poll();
			newTmpNode = newTmpNode.next;
			newTmpNode.next = s.pop();
			newTmpNode = newTmpNode.next;
		}
		if (!q.isEmpty()) {
			newTmpNode.next = q.poll();
			newTmpNode = newTmpNode.next;
		}
		newTmpNode.next = null;
		head = newNode.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;

		new ReorderList().reorderList(n1);
		printlist(n1);
	}

	static void printlist(ListNode l1) {
		while (null != l1) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}
}
