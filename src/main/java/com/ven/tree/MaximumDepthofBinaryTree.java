package com.ven.tree;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 *
 *
 * Example 1:
 * <p>
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        MaximumDepthofBinaryTree maxDepth = new MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Depth: " + maxDepth.maxDepth(root)); // Output: 3
    }
}
