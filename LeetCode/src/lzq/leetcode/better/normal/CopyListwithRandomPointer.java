package lzq.leetcode.better.normal;

import lzq.leetcode.model.RandomListNode;

public class CopyListwithRandomPointer {
	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 * 
	 * ��oldlist�еĽڵ㣬���������µĲ��������ڵ�i���ڵ�oldnode[i]�����ɿ����ڵ�copynode[i]�����Ҳ�����oldnode[i]
	 * ��oldnode[i+1]֮�䣬���һ���ڵ�ֱ�Ӹ��ӵ�oldlist���漴�ɡ�
	 * ����ÿһ��copynode��random����������ÿһ��copynode=oldnode.next,
	 * oldnode.next.random=oldnode.random.next �����nextȷ����copynode��
	 * ͨ�����µĲ������ָ�oldlist���Լ�����copylist 1) oldnode.next = oldnode.next.next 2)
	 * copynode.next = copynode.next.next ����Ҫע�⣬oldnode�����һ���ڵ㣬next��null
	 * 
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == head) {
			return null;
		}
		RandomListNode tmpHead = head;
		RandomListNode tmp = null;
		while (null != tmpHead) {
			tmp = tmpHead.next;

			RandomListNode node = new RandomListNode(tmpHead.label);
			tmpHead.next = node;
			node.next = tmp;

			tmpHead = tmp;
		}
		tmpHead = head;
		while (null != tmpHead) {
			if (null != tmpHead.random) {
				tmpHead.next.random = tmpHead.random.next;
			}
			tmpHead = tmpHead.next.next;
		}
		RandomListNode newList = new RandomListNode(0);
		RandomListNode newTmp = newList;

		tmpHead = head;
		while (null != tmpHead) {
			newTmp.next = tmpHead.next;
			tmpHead.next = tmpHead.next.next;

			newTmp = newTmp.next;
			tmpHead = tmpHead.next;
		}
		return newList.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
