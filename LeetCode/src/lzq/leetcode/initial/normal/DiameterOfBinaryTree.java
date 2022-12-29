package lzq.leetcode.initial.normal;

import lzq.leetcode.model.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class DiameterOfBinaryTree {
    private static int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        calc(root);
        return dia;
    }

    public int calc(TreeNode root) {
        if (root.right == null && root.left == null) {
            return 0;
        } else if (root.right == null) {
            int depth = 1 + calc(root.left);
            if (depth > dia) {
                dia = depth;
            }
            return depth;
        } else if (root.left == null) {
            int depth = 1 + calc(root.right);
            if (depth > dia) {
                dia = depth;
            }
            return depth;
        } else {
            int leftDepth = 1 + calc(root.left);
            int rightDepth = 1 + calc(root.right);
            int depth = Math.max(leftDepth, rightDepth);
            if (leftDepth + rightDepth > dia) {
                dia = leftDepth + rightDepth;
            }
            return depth;
        }
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        //TreeNode tn6 = new TreeNode(6);
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        //tn5.right = tn6;
        int dd = d.diameterOfBinaryTree(tn1);
        System.out.println(dd);

    }
}
