package com.ven.medium.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderandInorderTraversal {
    private static int preIn = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inordMap = new HashMap<>();
        preIn = 0;
        for (int i = 0; i < inorder.length; i++) {
            inordMap.put(inorder[i], i);
        }

        return construct(0, inorder.length - 1, preorder, inordMap);
    }

    private TreeNode construct(int left, int right, int[] pre, Map<Integer, Integer> inordMap) {
        if (left > right) {
            return null;
        }
        int val = pre[preIn++];

        TreeNode node = new TreeNode(val);

        node.left = construct(left, inordMap.get(val) - 1, pre, inordMap);
        node.right = construct(inordMap.get(val) + 1, right, pre, inordMap);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderandInorderTraversal solution = new ConstructBinaryTreeFromPreorderandInorderTraversal();

        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("Tree constructed from preorder1 and inorder1: " + root1); // Output: [3,9,20,null,null,15,7]

        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("Tree constructed from preorder2 and inorder2: " + root2); // Output: [-1]
    }
}
