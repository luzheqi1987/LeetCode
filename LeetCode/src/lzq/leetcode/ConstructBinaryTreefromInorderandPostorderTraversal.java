package lzq.leetcode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == inorder || null == preorder || inorder.length <= 0
				|| preorder.length <= 0) {
			return null;
		}
		return dfs(inorder, preorder, 0, inorder.length - 1, 0,
				preorder.length - 1);
	}

	TreeNode dfs(int[] inorder, int[] preorder, int inorderStart,
			int inorderEnd, int preorderStart, int preorderEnd) {
		TreeNode node = new TreeNode(preorder[preorderStart]);
		int nodeIndexInInorder = findElement(inorder, preorder[preorderStart]);
		int leftLength = nodeIndexInInorder - inorderStart;
		int rightLength = inorderEnd - nodeIndexInInorder;
		if (leftLength > 0) {
			TreeNode left = dfs(inorder, preorder, inorderStart,
					nodeIndexInInorder - 1, preorderStart + 1, preorderStart
							+ leftLength);
			node.left = left;
		}
		if (rightLength > 0) {
			TreeNode right = dfs(inorder, preorder, nodeIndexInInorder + 1,
					inorderEnd, preorderEnd - rightLength + 1, preorderEnd);
			node.right = right;
		}
		return node;
	}

	int findElement(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = { 4, 2, 5, 8, 1, 6, 3, 7 };
		int[] post = { 4, 8, 5, 2, 6, 7, 3, 1 };
		int[] pre = { 1, 2, 4, 5, 8, 3, 6, 7 };

		TreeNode tree = new ConstructBinaryTreefromInorderandPostorderTraversal()
				.buildTree(pre, in);

		System.out.println(tree);

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
