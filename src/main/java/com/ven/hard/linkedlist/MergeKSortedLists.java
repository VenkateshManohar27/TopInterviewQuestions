package com.ven.hard.linkedlist;

import com.ven.linkedList.utilities.ListNode;

import java.util.ArrayList;
import java.util.List;

import static com.ven.linkedList.utilities.ListUtility.printList;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted linked list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> li = new ArrayList<>();

        for (ListNode l : lists) {
            while (l != null) {
                ListNode n = l;
                l = l.next;
                n.next = null;
                li.add(n);
            }
        }
        return mergeSort(0, li.size() - 1, li);
    }

    private ListNode mergeSort(int start, int end, List<ListNode> li) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return li.get(start);
        }
        int mid = start + (end - start) / 2;

        ListNode left = mergeSort(start, mid, li);
        ListNode right = mergeSort(mid + 1, end, li);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                ListNode curr = left;
                left = left.next;
                curr.next = null;
                dummy.next = curr;
                dummy = dummy.next;
            } else {
                ListNode curr = right;
                right = right.next;
                curr.next = null;
                dummy.next = curr;
                dummy = dummy.next;
            }
        }
        while (left != null) {
            ListNode curr = left;
            left = left.next;
            curr.next = null;
            dummy.next = curr;
            dummy = dummy.next;
        }
        while (right != null) {
            ListNode curr = right;
            right = right.next;
            curr.next = null;
            dummy.next = curr;
            dummy = dummy.next;
        }

        return head.next;

    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode mergedList = mergeKSortedLists.mergeKLists(lists);
        printList(mergedList); // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }
}
