package com.wangjf;


import java.util.LinkedList;



public class Test002 {
    public static void main(String[] args) {
        System.out.println(Math.max(2, 4));
//        Solution solution = new Solution();
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(0);
//        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(1);
//        node1.next = node2;
//        node1.next.next = node3;


//        node1.next.next.next = node4;
//        boolean palindrome = solution.isPalindrome(node1);
//        System.out.println(palindrome);
//        LinkedList list = new LinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        System.out.println(list.pollLast());
////        System.out.println(list.poll());

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        LinkedList<Integer> list = new LinkedList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        boolean flag = true;
        while (!list.isEmpty()) {
            int i = list.pollLast();
            int j  = list.poll();
            if (i != j) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}