package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

import lzq.leetcode.model.RandomListNode;

public class CopyListwithRandomPointer {
	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 * 
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

		RandomListNode cpyList = new RandomListNode(0);
		RandomListNode cpyListTmp = cpyList;
		RandomListNode headTmp = head;
		while (null != headTmp) {
			int val = headTmp.label;
			if (map.containsKey(val)) {
				RandomListNode newnode = map.get(val);
				cpyListTmp.next = newnode;
				cpyListTmp = cpyListTmp.next;
				headTmp = headTmp.next;
			} else {
				RandomListNode newnode = new RandomListNode(val);
				cpyListTmp.next = newnode;
				cpyListTmp = cpyListTmp.next;
				headTmp = headTmp.next;
				map.put(val, newnode);
			}
		}
		cpyListTmp = cpyList;
		headTmp = head;
		while (null != headTmp) {
			if (null == headTmp.random) {
				cpyListTmp.next.random = null;
			} else {
				cpyListTmp.next.random = map.get(headTmp.random.label);
			}
			cpyListTmp = cpyListTmp.next;
			headTmp = headTmp.next;
		}
		return cpyList.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
