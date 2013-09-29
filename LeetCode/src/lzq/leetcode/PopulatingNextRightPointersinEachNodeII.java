package lzq.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == root) {
			return;
		}
		bfs(root);
	}

	private void bfs(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int queueNumber = 1;
		int layerNumber = 0;
		TreeLinkNode tempNode = null;
		while (!queue.isEmpty()) {
			tempNode = queue.poll();
			queueNumber--;
			if (null != tempNode.left) {
				queue.offer(tempNode.left);
				layerNumber++;
			}
			if (null != tempNode.right) {
				queue.offer(tempNode.right);
				layerNumber++;
			}
			if (queueNumber != 0) {
				tempNode.next = queue.peek();
			} else {
				tempNode.next = null;
			}

			if (queueNumber == 0 && layerNumber != 0) {
				queueNumber = layerNumber;
				layerNumber = 0;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersinEachNodeII sl = new PopulatingNextRightPointersinEachNodeII();
		TreeLinkNode tn2 = sl.new TreeLinkNode(2);
		tn2.left = null;
		tn2.right = null;
		TreeLinkNode tn3 = sl.new TreeLinkNode(3);
		tn3.left = null;
		tn3.right = null;
		TreeLinkNode tn1 = sl.new TreeLinkNode(1);
		tn1.left = tn2;
		tn1.right = tn3;
		sl.connect(tn1);

		System.out.println(tn1);
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
