package lzq.leetcode.util;

import lzq.leetcode.model.ListNode;

public class LeetCodeUtil {
	public static void printlist(ListNode l1) {
		while (null != l1) {
			System.out.print(l1.val + "->");
			l1 = l1.next;
		}
		System.out.println();
	}
}
