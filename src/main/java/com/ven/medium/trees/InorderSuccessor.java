package com.ven.medium.trees;

import java.util.ArrayList;
import java.util.List;


public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> li = new ArrayList<>();
        int[] index = new int[]{-1};
        inorder(root, li, index, p);
        // System.out.println(li);
        // System.out.println("index[0]: "+index[0]);
        if (index[0] == -1 || index[0] + 1 >= li.size()) {
            return null;
        }

        return li.get(index[0] + 1);
    }

    private void inorder(TreeNode node, List<TreeNode> li, int[] idx, TreeNode p) {
        if (node == null) {
            return;
        }

        inorder(node.left, li, idx, p);
        int val = node.val;
        if (val == p.val) {
            idx[0] = li.size();
        }
        li.add(node);
        inorder(node.right, li, idx, p);
    }

    public static void main(String[] args) {
        // Build the following BST:
        //        20
        //       /  \
        //      10   30
        //     / \     \
        //    5  15     35
        //
        // In-order: 5, 10, 15, 20, 30, 35

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.right = new TreeNode(35);

        InorderSuccessor test = new InorderSuccessor();

        // Test case 1: Successor of 15 is 20
        TreeNode p1 = root.left.right; // 15
        TreeNode succ1 = test.inorderSuccessor(root, p1);
        System.out.println("Successor of " + p1.val + " is " + (succ1 != null ? succ1.val : "null"));

        // Test case 2: Successor of 10 is 15
        TreeNode p2 = root.left; // 10
        TreeNode succ2 = test.inorderSuccessor(root, p2);
        System.out.println("Successor of " + p2.val + " is " + (succ2 != null ? succ2.val : "null"));

        // Test case 3: Successor of 35 is null
        TreeNode p3 = root.right.right; // 35
        TreeNode succ3 = test.inorderSuccessor(root, p3);
        System.out.println("Successor of " + p3.val + " is " + (succ3 != null ? succ3.val : "null"));
    }
}
