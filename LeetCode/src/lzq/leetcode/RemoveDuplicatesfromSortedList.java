package lzq.leetcode;

public class RemoveDuplicatesfromSortedList {
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
