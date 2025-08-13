package com.ven.linkedlist;

import static com.ven.linkedlist.ListUtility.printList;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode reverse = new ListNode();

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = reverse.next;
            reverse.next = node;

        }

        return reverse.next;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        ListNode reversedHead = reverseList.reverseList(head);

        System.out.println("Reversed list:");
        printList(reversedHead);
    }
}
