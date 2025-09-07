package com.ven.hard.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 */
public class CopyListRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Node dummy = new Node(0);
        Node curr = dummy;
        Node oldHead = head;
        while (head != null) {
            Node node = head;
            Node n = new Node(node.val);
            curr.next = n;
            oldToNew.put(node, n);
            curr = curr.next;
            head = head.next;
        }
        curr = dummy.next;
        while (oldHead != null && curr != null) {
            Node random = oldHead.random;

            Node randomNew = oldToNew.get(random);
            curr.random = randomNew;
            curr = curr.next;
            oldHead = oldHead.next;
        }


        Node temp = dummy.next;
        dummy.next = null;
        return temp;
    }

    public static void main(String[] args) {
        CopyListRandomPointer copyListRandomPointer = new CopyListRandomPointer();
        Node head = copyListRandomPointer.new Node(7);
        head.next = copyListRandomPointer.new Node(13);
        head.next.next = copyListRandomPointer.new Node(11);
        head.next.next.next = copyListRandomPointer.new Node(10);
        head.next.next.next.next = copyListRandomPointer.new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node newHead = copyListRandomPointer.copyRandomList(head);
        while (newHead != null) {
            System.out.print("Node: " + newHead.val);
            if (newHead.random != null) {
                System.out.print(", Random: " + newHead.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            newHead = newHead.next;
        }
    }
}
