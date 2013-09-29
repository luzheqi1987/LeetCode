package lzq.leetcode;

import java.util.ArrayList;

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		if (null == root) {
			return paths;
		}
		dfs(paths, new ArrayList<Integer>(), root, 0, sum);
		return paths;
	}

	private void dfs(ArrayList<ArrayList<Integer>> paths,
			ArrayList<Integer> path, TreeNode root, int current, int sum) {
		if (root.left == null && root.right == null) {
			if (current + root.val == sum) {
				path.add(root.val);
				ArrayList<Integer> pathCopy = new ArrayList<Integer>();
				pathCopy.addAll(path);
				paths.add(pathCopy);
				path.remove(path.size() - 1);
			}
		}
		path.add(root.val);
		current += root.val;
		if (root.left != null) {
			dfs(paths, path, root.left, current, sum);
		}
		if (root.right != null) {
			dfs(paths, path, root.right, current, sum);
		}
		path.remove(path.size() - 1);
	}

	@SuppressWarnings("unused")
	private ArrayList<ArrayList<Integer>> dfs(TreeNode root, int current,
			int sum) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		if (root.left == null && root.right == null) {
			if (current + root.val == sum) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				path.add(root.val);
				paths.add(path);
			}
		}
		current += root.val;
		if (root.left != null) {
			ArrayList<ArrayList<Integer>> pathsLeft = dfs(root.left, current,
					sum);
			for (ArrayList<Integer> pathLeft : pathsLeft) {
				pathLeft.add(0, root.val);
				paths.add(pathLeft);
			}
		}
		if (root.right != null) {
			ArrayList<ArrayList<Integer>> pathsRight = dfs(root.right, current,
					sum);
			for (ArrayList<Integer> pathRight : pathsRight) {
				pathRight.add(0, root.val);
				paths.add(pathRight);
			}
		}
		return paths;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumII sl = new PathSumII();
		TreeNode tn1 = sl.new TreeNode(1);
		TreeNode tn2 = sl.new TreeNode(-2);
		TreeNode tn3 = sl.new TreeNode(-3);
		TreeNode tn4 = sl.new TreeNode(1);
		TreeNode tn5 = sl.new TreeNode(3);
		TreeNode tn6 = sl.new TreeNode(-2);
		TreeNode tn7 = sl.new TreeNode(-1);
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.left = tn6;
		tn4.left = tn7;

		ArrayList<ArrayList<Integer>> paths = sl.pathSum(tn1, 3);
		System.out.println(paths);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
