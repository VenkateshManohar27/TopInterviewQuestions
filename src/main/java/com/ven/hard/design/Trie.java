package com.ven.hard.design;

class Node {
    Node[] children;
    boolean isEnd;

    public Node() {
        children = new Node[26];
        isEnd = false;
    }


}

public class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        char[] chrs = word.toCharArray();

        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        char[] chrs = word.toCharArray();

        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        char[] chrs = prefix.toCharArray();

        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}

