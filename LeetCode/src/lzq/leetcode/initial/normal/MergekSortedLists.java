package lzq.leetcode.initial.normal;

import java.util.ArrayList;

import lzq.leetcode.model.ListNode;

public class MergekSortedLists {
	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and
	 * describe its complexity.
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == lists || lists.isEmpty()) {
			return null;
		}
		return dfs(lists, 0, lists.size() - 1);
	}

	ListNode dfs(ArrayList<ListNode> lists, int start, int end) {
		if (start == end) {
			return lists.get(start);
		} else if (end > start && end == start + 1) {
			return merge2Lists(lists.get(start), lists.get(end));
		}
		int mid = start + (end - start) / 2;
		ListNode left = dfs(lists, start, mid);
		ListNode right = dfs(lists, mid + 1, end);
		return merge2Lists(left, right);
	}

	ListNode merge2Lists(ListNode first, ListNode second) {
		ListNode tmpF = first;
		ListNode tmpS = second;
		ListNode newNode = new ListNode(0);
		ListNode tmpN = newNode;
		while (null != tmpF && null != tmpS) {
			if (tmpS.val >= tmpF.val) {
				tmpN.next = tmpF;
				tmpF = tmpF.next;
				tmpN = tmpN.next;
			} else {
				ListNode node = new ListNode(tmpS.val);
				tmpN.next = node;
				tmpS = tmpS.next;
				tmpN = tmpN.next;
			}
		}
		if (null != tmpS) {
			tmpN.next = tmpS;
		}
		if (null != tmpF) {
			tmpN.next = tmpF;
		}
		return newNode.next;
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		// node1.next = node2;
		// node2.next = node3;
		// node3.next = node4;
		// node4.next = node5;
		// node5.next = node6;
		// node6.next = node7;
		// node7.next = node8;
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
		// ListNode node24 = new ListNode(4);
		// ListNode node25 = new ListNode(5);
		ListNode node26 = new ListNode(6);
		ListNode node27 = new ListNode(7);
		ListNode node28 = new ListNode(8);
		node21.next = node22;
		node22.next = node23;
		node23.next = node26;
		// node24.next = node25;
		// node25.next = node26;
		node26.next = node27;
		node27.next = node28;

		ArrayList<ListNode> nodes = new ArrayList<ListNode>();
		nodes.add(node1);
		nodes.add(node0);
		// nodes.add(node21);
		printNode(new MergekSortedLists().mergeKLists(nodes));
	}

	static void printNode(ListNode node) {
		while (null != node) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}
}
