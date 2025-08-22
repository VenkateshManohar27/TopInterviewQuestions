package com.ven.easy.linkedlist;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int mid = length / 2;
        boolean odd = length % 2 == 1;
        ListNode reverse = new ListNode();
        curr = head;
        while (mid > 0) {
            ListNode node = curr;
            curr = curr.next;
            node.next = reverse.next;
            reverse.next = node;
            mid--;
        }

        if (odd) {
            curr = curr.next;
        }
        reverse = reverse.next;
        while (reverse != null && curr != null) {
            if (reverse.val != curr.val) {
                return false;
            }
            reverse = reverse.next;
            curr = curr.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = palindromeLinkedList.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result); // Output: true
    }
}
