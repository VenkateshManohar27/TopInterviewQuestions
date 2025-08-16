package com.ven.medium.linkedlist;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode();
        ListNode currOdd = dummyOdd;
        ListNode dummyEven = new ListNode();
        ListNode currEven = dummyEven;
        boolean even = false;
        while (head != null) {
            if (even) {
                currEven.next = head;
                head = head.next;
                currEven = currEven.next;
                currEven.next = null;
                even = false;
            } else {
                currOdd.next = head;
                head = head.next;
                currOdd = currOdd.next;
                currOdd.next = null;
                even = true;
            }
        }

        currOdd.next = dummyEven.next;


        return dummyOdd.next;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = oddEvenLinkedList.oddEvenList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
