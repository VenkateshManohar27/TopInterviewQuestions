package com.ven.medium.trees;

import com.ven.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,null,2,3]
 * <p>
 * Output: [1,3,2]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * <p>
 * Output: [4,2,6,5,7,1,3,9,8]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * <p>
 * Output: []
 * <p>
 * Example 4:
 * <p>
 * Input: root = [1]
 * <p>
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        //recur(root, l);
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            l.add(curr.val);
            curr = curr.right;

        }


        return l;
    }

    private void recur(TreeNode node, List<Integer> l) {
        if (node == null)
            return;
        recur(node.left, l);
        l.add(node.val);
        recur(node.right, l);
    }
}
