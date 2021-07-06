package com.nxy006.project.alogtithm.utils.struct;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder("[" + node.val);
        while(node.next != null) {
            sb.append(", ").append(node.next.val);
            node = node.next;
        }
        return sb.append("]").toString();
    }
}
