package lzq.leetcode.initial.normal;

import lzq.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumWidthofBinaryTree1 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        q.addLast(root);
        int layerSize = 1;
        int maxWidth = 1;
        List<TreeNode> layerNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            if (layerSize == 0) {
                int right = layerNodes.size() - 1;
                int left = 0;
                if(left < right) {
                    while(left < right && layerNodes.get(left).val == Integer.MIN_VALUE) {
                        left++;
                    }
                    while(left < right && layerNodes.get(right).val == Integer.MIN_VALUE) {
                        right--;
                    }
                    if(left != right) {
                        maxWidth = Math.max(maxWidth, right - left + 1);
                    }
                }
                if(left == right && layerNodes.get(left).val == Integer.MIN_VALUE) {
                    break;
                }
                layerNodes.clear();
                layerSize = q.size();
            }

            TreeNode curr = q.peekFirst();
            q.removeFirst();
            layerSize--;
            layerNodes.add(curr);
            if(curr.val != Integer.MIN_VALUE){
                if (curr.left != null) {
                    q.addLast(curr.left);
                } else {
                    q.addLast(new TreeNode(Integer.MIN_VALUE));
                }
                if (curr.right != null) {
                    q.addLast(curr.right);
                } else {
                    q.addLast(new TreeNode(Integer.MIN_VALUE));
                }
            }else {
                q.addLast(new TreeNode(Integer.MIN_VALUE));
                q.addLast(new TreeNode(Integer.MIN_VALUE));
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;

        MaximumWidthofBinaryTree1 t= new MaximumWidthofBinaryTree1();
        System.out.println(t.widthOfBinaryTree(treeNode1));
    }
}
