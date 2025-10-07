package com.ven.hard.linkedlist;

import com.ven.linkedList.utilities.ListNode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.PriorityQueue;

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
public class MergeKSortedListsII {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair<ListNode, Integer>> pq = new PriorityQueue<>((a, b) ->
                a.getKey().val - b.getKey().val);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            ListNode node = lists[i];
            lists[i] = node.next;
            node.next = null;
            pq.offer(Pair.of(node, i));

        }
        //System.out.println(pq);
        ListNode head = new ListNode();
        ListNode curr = head;
        while (!pq.isEmpty()) {
            Pair<ListNode, Integer> pair = pq.poll();
            ListNode node = pair.getKey();
            curr.next = node;
            curr = curr.next;
            int index = pair.getValue();
            node.next = null;
            if (lists[index] != null) {
                ListNode l = lists[index];
                lists[index] = l.next;
                l.next = null;
                pq.offer(Pair.of(l, index));
            }

        }
        return head.next;
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
        MergeKSortedListsII mergeKSortedLists = new MergeKSortedListsII();
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode mergedList = mergeKSortedLists.mergeKLists(lists);
        printList(mergedList); // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }
}
