package com.ven.medium.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Follow-up:
 * <p>
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            while (size > 0) {
                Node curr = q.poll();

                if (prev != null) {
                    prev.next = curr;
                }

                prev = curr;

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

                size--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersEachNode solution = new PopulatingNextRightPointersEachNode();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        solution.connect(root);

        // Print the next pointers for each level
        System.out.println("Level 1: " + root.val + " -> " + (root.next == null ? "null" : root.next.val));
        System.out.println("Level 2: " + root.left.val + " -> " + (root.left.next == null ? "null" : root.left.next.val) +
                ", " + root.right.val + " -> " + (root.right.next == null ? "null" : root.right.next.val));
        System.out.println("Level 3: " + root.left.left.val + " -> " + (root.left.left.next == null ? "null" : root.left.left.next.val) +
                ", " + root.left.right.val + " -> " + (root.left.right.next == null ? "null" : root.left.right.next.val) +
                ", " + root.right.left.val + " -> " + (root.right.left.next == null ? "null" : root.right.left.next.val) +
                ", " + root.right.right.val + " -> " + (root.right.right.next == null ? "null" : root.right.right.next.val));
    }
}
