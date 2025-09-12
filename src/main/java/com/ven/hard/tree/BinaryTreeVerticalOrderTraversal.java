package com.ven.hard.tree;

import com.ven.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * Example 3:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,10,9,11,null,5,null,null,null,null,null,null,null,6]
 * Output: [[4],[2,5],[1,10,9,6],[3],[11]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<int[]>> vertOrder = new HashMap<>();
        int[] minMaxIdx = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        inorder(root, 0, 0, vertOrder, minMaxIdx);

        //System.out.println(vertOrder);
        List<List<Integer>> li = new ArrayList<>();

        for (int i = minMaxIdx[0]; i <= minMaxIdx[1]; i++) {
            List<int[]> nodes = vertOrder.get(i);
            nodes.sort((a, b) -> a[1] - b[1]);
            List<Integer> nodeNums = new ArrayList<>();
            for (int[] node : nodes) {
                nodeNums.add(node[0]);
            }

            li.add(nodeNums);
        }

        return li;
    }


    private void inorder(TreeNode node, int vertical, int level, Map<Integer, List<int[]>> vertOrder, int[] minMaxIdx) {
        if (node == null)
            return;

        minMaxIdx[0] = Math.min(minMaxIdx[0], vertical);
        minMaxIdx[1] = Math.max(minMaxIdx[1], vertical);
        vertOrder.computeIfAbsent(vertical, k -> new ArrayList<>()).add(new int[]{node.val, level});
        inorder(node.left, vertical - 1, level + 1, vertOrder, minMaxIdx);
        inorder(node.right, vertical + 1, level + 1, vertOrder, minMaxIdx);

    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal bt = new BinaryTreeVerticalOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Vertical Order Traversal: " + bt.verticalOrder(root)); // Output: [[9], [3, 15], [20], [7]]
    }
}
