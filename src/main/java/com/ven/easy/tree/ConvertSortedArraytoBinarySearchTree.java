package com.ven.easy.tree;

import com.ven.tree.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(0, nums.length - 1, nums);
    }

    private TreeNode generate(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = generate(start, mid - 1, nums);
        node.right = generate(mid + 1, end, nums);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree converter = new ConvertSortedArraytoBinarySearchTree();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = converter.sortedArrayToBST(nums);

        System.out.println("Root of the BST: " + root.val); // Output: 0
        System.out.println("Left child of root: " + root.left.val); // Output: -3
        System.out.println("Right child of root: " + root.right.val); // Output: 5
    }
}
