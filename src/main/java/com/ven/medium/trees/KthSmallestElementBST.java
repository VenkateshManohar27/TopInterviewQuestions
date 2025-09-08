package com.ven.medium.trees;

import com.ven.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * <p>
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */
public class KthSmallestElementBST {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        // Traverse left subtree
        inOrderTraversal(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse right subtree
        inOrderTraversal(node.right, k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();

        inorder(root, li);

        return li.get(k - 1);
    }

    private void inorder(TreeNode node, List<Integer> li) {
        if (node == null) {
            return;
        }
        inorder(node.left, li);
        li.add(node.val);
        inorder(node.right, li);
    }

    public static void main(String[] args) {
        KthSmallestElementBST solution = new KthSmallestElementBST();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        int k1 = 1;
        System.out.println("Kth smallest element: " + solution.kthSmallest(root1, k1)); // Output: 1

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        int k2 = 3;
        System.out.println("Kth smallest element: " + solution.kthSmallest2(root2, k2)); // Output: 3
    }
}
