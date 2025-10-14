package com.ven.medium.linkedlist;

import com.ven.linkedList.utilities.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (n1 != null || n2 != null || carry > 0) {
            int val1 = 0;

            if (n1 != null) {
                val1 = n1.val;
                n1 = n1.next;
            }
            int val2 = 0;
            if (n2 != null) {
                val2 = n2.val;
                n2 = n2.next;
            }
            int sum = val1 + val2 + carry;

            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // Represents 342
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // Represents 465
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output should be: 7 0 8 (represents 807)
    }
}
