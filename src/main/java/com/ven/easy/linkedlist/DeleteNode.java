package com.ven.easy.linkedlist;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Node to be deleted (node with value 5)
        ListNode nodeToDelete = head.next;

        System.out.println("Original list:");
        printList(head);

        deleteNode.deleteNode(nodeToDelete);

        System.out.println("List after deleting node with value 5:");
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
