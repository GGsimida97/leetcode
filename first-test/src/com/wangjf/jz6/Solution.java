package com.wangjf.jz6;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 此题注意：LinkedList可以当成栈使用，
 * 当使用push()方法时，相当于入栈，若用get()方法取出，最后压入的元素，下标为0
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        //定义一个辅助指针，指向头节点
        ListNode temp = head;
        //定义一个LinkedList集合
        LinkedList<Integer> list = new LinkedList<>();
        while (temp != null) {
            //遍历链表，将元素压入list中
            //注意：当使用push()方法时，相当于入栈，若用get()方法取出，最后压入的元素，下标为0
            list.push(temp.val);
            temp = temp.next;
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.pop();
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}