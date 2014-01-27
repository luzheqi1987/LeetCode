package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.Arrays;

import lzq.leetcode.model.ListNode;

public class SortList {
	/**
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> its = new ArrayList<Integer>();
		ListNode tmp = head;
		while (null != tmp) {
			its.add(tmp.val);
			tmp = tmp.next;
		}
		int[] is = new int[its.size()];
		for (int i = 0; i < its.size(); i++) {
			is[i] = its.get(i);
		}
		Arrays.sort(is);
		tmp = head;
		for (int i = 0; i < its.size(); i++) {
			tmp.val = is[i];
			tmp = tmp.next;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		new SortList().sortList(n1);
	}

}
