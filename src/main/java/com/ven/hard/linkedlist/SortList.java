package com.ven.hard.linkedlist;

import com.ven.linkedList.utilities.ListNode;
import com.ven.linkedList.utilities.ListUtility;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }

        ListNode midPrev = getMid(node);
        ListNode mid = midPrev.next;
        midPrev.next = null;

        ListNode left = mergeSort(node);
        ListNode right = mergeSort(mid);

        ListNode headNew = merge(left, right);
        return headNew.next;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode headNew = new ListNode();
        ListNode curr = headNew;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
                curr = curr.next;
                curr.next = null;
            } else {
                curr.next = right;
                right = right.next;
                curr = curr.next;
                curr.next = null;
            }
        }

        if (left != null) {
            curr.next = left;
        }

        if (right != null) {
            curr.next = right;
        }
        return headNew;
    }

    private static ListNode getMid(ListNode node) {
        ListNode slow = node, fast = node;
        ListNode midPrev = null;
        while (fast != null && fast.next != null) {
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return midPrev;
    }

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original list:");
        ListUtility.printList(head);

        ListNode sortedHead = sortList.sortList(head);

        System.out.println("Sorted list:");
        ListUtility.printList(sortedHead);
    }
}
