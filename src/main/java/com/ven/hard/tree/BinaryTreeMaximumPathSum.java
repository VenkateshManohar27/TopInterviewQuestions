package com.ven.hard.tree;

import com.ven.tree.TreeNode;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeMaximumPathSum {
    private static int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;

        traverse(root);
        return maxSum;
    }

    private int traverse(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(traverse(node.left), 0);
        int right = Math.max(traverse(node.right), 0);

        int sum = node.val + left + right;

        maxSum = Math.max(maxSum, sum);
        return Math.max(node.val + left, node.val + right);
    }

}
