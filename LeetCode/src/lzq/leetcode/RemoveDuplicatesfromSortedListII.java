package lzq.leetcode;

public class RemoveDuplicatesfromSortedListII {
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
