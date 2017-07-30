package com.bing.test;

import org.junit.Test;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        FindKthToTail(node1,6);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (k < 1 || head == null)
            return null;
        ListNode headFront = head;
        ListNode headPre = head;
        int i = 1;
        while (headFront != null) {
            if (i < k) {
                headFront = headFront.next;
                i++;
                continue;
            }
            headFront = headFront.next;
            headPre = headPre.next;
        }

        return headPre;
    }


    public int Fibonacci2(int n) {
        if (n == 1 || n == 2)
            return 1;
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }
}