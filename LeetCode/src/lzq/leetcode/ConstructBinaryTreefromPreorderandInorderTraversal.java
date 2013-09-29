package lzq.leetcode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (null == inorder || null == postorder || inorder.length <= 0
				|| postorder.length <= 0) {
			return null;
		}
		return dfs(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
	}

	TreeNode dfs(int[] inorder, int[] postorder, int inorderStart,
			int inorderEnd, int postorderStart, int postorderEnd) {
		TreeNode node = new TreeNode(postorder[postorderEnd]);
		int nodeIndexInInorder = findElement(inorder, postorder[postorderEnd]);
		int leftLength = nodeIndexInInorder - inorderStart;
		int rightLength = inorderEnd - nodeIndexInInorder;
		if (leftLength > 0) {
			TreeNode left = dfs(inorder, postorder, inorderStart,
					nodeIndexInInorder - 1, postorderStart, postorderEnd
							- rightLength - 1);
			node.left = left;
		}
		if (rightLength > 0) {
			TreeNode right = dfs(inorder, postorder, nodeIndexInInorder + 1,
					inorderEnd, postorderEnd - rightLength, postorderEnd - 1);
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

		TreeNode tree = new ConstructBinaryTreefromPreorderandInorderTraversal()
				.buildTree(in, post);

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
