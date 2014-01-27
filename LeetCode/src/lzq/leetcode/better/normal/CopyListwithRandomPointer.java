package lzq.leetcode.better.normal;

import lzq.leetcode.model.RandomListNode;

public class CopyListwithRandomPointer {
	/**
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 * 
	 * 对oldlist中的节点，依次作如下的操作：对于第i个节点oldnode[i]，生成拷贝节点copynode[i]，并且插入在oldnode[i]
	 * 和oldnode[i+1]之间，最后一个节点直接附加到oldlist后面即可。
	 * 处理每一个copynode的random拷贝，及对每一个copynode=oldnode.next,
	 * oldnode.next.random=oldnode.random.next 后面的next确保是copynode。
	 * 通过如下的操作，恢复oldlist，以及生成copylist 1) oldnode.next = oldnode.next.next 2)
	 * copynode.next = copynode.next.next 这里要注意，oldnode的最后一个节点，next是null
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
