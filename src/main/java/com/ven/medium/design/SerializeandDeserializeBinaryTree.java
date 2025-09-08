package com.ven.medium.design;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
public class SerializeandDeserializeBinaryTree {
    private static int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        sb.setLength(sb.length() - 1);
        // System.out.println(sb.toString());
        return sb.toString();
    }

    private void inorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val);
        sb.append(",");
        inorder(node.left, sb);
        inorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        index = 0;
        return construct(nodes);

    }

    private TreeNode construct(String[] nodes) {

        if ("null".equals(nodes[index])) {

            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index++]));

        node.left = construct(nodes);
        node.right = construct(nodes);
        return node;
    }


    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree codec = new SerializeandDeserializeBinaryTree();

        // Build a sample tree:
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize
        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        // Deserialize
        TreeNode deserialized = codec.deserialize(serialized);

        // Print preorder of deserialized tree to verify structure
        System.out.print("Preorder of deserialized tree: ");
        codec.printPreorder(deserialized);
    }

    // Helper: Print tree preorder to verify
    private void printPreorder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
