package lzq.leetcode.initial.normal;

import lzq.leetcode.model.ListNode;

public class LinkListSort {
    public ListNode sort(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode next = node.next;
        newHead.next = node;
        node.next = null;
        while(next != null) {
            ListNode tmp = next.next;
            ListNode i = newHead;
            ListNode j = newHead.next;
            while(j != null && j.val < next.val){
                j = j.next;
                i = i.next;
            }
            if(j == null) {
                i.next = next;
                next.next = null;
            }else{
                i.next = next;
                next.next = j;
            }
            next = tmp;
        }
        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
