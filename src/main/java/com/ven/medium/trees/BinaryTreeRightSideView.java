package com.ven.medium.trees;

import com.ven.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 *
 * Example 1:
 * <p>
 * Input: root = [1,2,3,null,5,null,4]
 * <p>
 * Output: [1,3,4]
 * <p>
 * Explanation:
 * <p>
 *
 * Example 2:
 * <p>
 * Input: root = [1,2,3,4,null,null,null,5]
 * <p>
 * Output: [1,3,4,5]
 * <p>
 * Explanation:
 * <p>
 *
 * Example 3:
 * <p>
 * Input: root = [1,null,3]
 * <p>
 * Output: [1,3]
 * <p>
 * Example 4:
 * <p>
 * Input: root = []
 * <p>
 * Output: []
 * <p>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if(root == null)
            return li;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            // System.out.println("size :" +size);
            while(size > 0) {
                TreeNode node = q.poll();
                size--;
                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }

                if(size == 0) {
                    li.add(node.val);
                }

            }
        }
        return li;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = solution.rightSideView(root);
        System.out.println(result); // Output: [1, 3, 4]
    }
}
