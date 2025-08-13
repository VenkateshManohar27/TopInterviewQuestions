package com.ven.tree;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        return left.val == right.val && check(left.left, right.right)
                && check(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is symmetric: " + symmetricTree.isSymmetric(root)); // Output: true

        TreeNode asymmetricRoot = new TreeNode(1);
        asymmetricRoot.left = new TreeNode(2);
        asymmetricRoot.right = new TreeNode(2);
        asymmetricRoot.left.right = new TreeNode(3);
        asymmetricRoot.right.right = new TreeNode(3);

        System.out.println("Is symmetric: " + symmetricTree.isSymmetric(asymmetricRoot)); // Output: false
    }
}
