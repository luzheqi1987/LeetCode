package lzq.leetcode.initial.normal;

import lzq.leetcode.model.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(null == root){
            return;
        }
        link(root);
    }

    private TreeNode link(TreeNode root){
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode rootRight = root.right;

        if(root.left != null) {
            TreeNode left = link(root.left);
            root.right = left;
            root.left = null;
        }else{
            root.right = null;
        }

        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }

        if(rootRight != null){
            TreeNode right = link(rootRight);
            p.right = right;
        }
        return root;
    }
}
