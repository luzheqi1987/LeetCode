package lzq.leetcode.initial.normal;

import java.util.Stack;

import lzq.leetcode.model.ListNode;

public class ReverseNodesinkGroup {
	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list.
	 * 
	 * If the number of nodes is not a multiple of k then left-out nodes in the
	 * end should remain as it is.
	 * 
	 * You may not alter the values in the nodes, only nodes itself may be
	 * changed.
	 * 
	 * Only constant memory is allowed.
	 * 
	 * For example, Given this linked list: 1->2->3->4->5
	 * 
	 * For k = 2, you should return: 2->1->4->3->5
	 * 
	 * For k = 3, you should return: 3->2->1->4->5
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode tmpHead = head;
		Stack<Integer> stack = new Stack<Integer>();
		int number = 1;
		while (tmpHead != null) {
			ListNode tmp = tmpHead;
			while (tmp != null && number <= k) {
				stack.push(tmp.val);
				tmp = tmp.next;
				number++;
			}
			if (number > k) {
				while (!stack.isEmpty()) {
					tmpHead.val = stack.pop();
					tmpHead = tmpHead.next;
				}
			}
			tmpHead = tmp;
			number = 1;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		printNode(new ReverseNodesinkGroup().reverseKGroup(node1, 3));
	}

	static void printNode(ListNode node) {
		while (null != node) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}

}
