package com.ven.meta.medium;

import com.ven.linkedList.utilities.ListNode;

import static com.ven.linkedList.utilities.ListUtility.printList;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode rev = null;

        while (mid != null) {
            ListNode node = mid;
            mid = mid.next;
            node.next = rev;
            rev = node;
        }
        slow = head;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (slow != null || rev != null) {

            if (slow != null) {
                curr.next = slow;
                slow = slow.next;
                curr = curr.next;
            }

            if (rev != null) {
                curr.next = rev;
                rev = rev.next;
                curr = curr.next;
            }

        }
        head = dummy.next;
    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        solution.reorderList(head1);
        System.out.print("Reordered list 1: ");
        printList(head1); // Expected: 1 -> 4 -> 2 -> 3

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        solution.reorderList(head2);
        System.out.print("Reordered list 2: ");
        printList(head2); // Expected: 1 -> 5 -> 2 -> 4 -> 3
    }
}
