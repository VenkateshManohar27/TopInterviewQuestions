package com.ven.easy.tree;

import com.ven.tree.TreeNode;

/**
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */
public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] res = new int[1];
        dfs(root, low, high, res);
        return res[0];
    }

    private void dfs(TreeNode node, int low, int high, int[] res) {
        if (node == null)
            return;

        if (node.val >= low && node.val <= high) {
            res[0] += node.val;
        }
        if (node.val >= low)
            dfs(node.left, low, high, res);

        if (node.val <= high)
            dfs(node.right, low, high, res);
    }

    public static void main(String[] args) {
        RangeSumofBST obj = new RangeSumofBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        int result = obj.rangeSumBST(root, low, high);
        System.out.println("Range Sum of BST: " + result); // Output: 32
    }
}
