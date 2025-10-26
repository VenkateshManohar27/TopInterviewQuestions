package com.ven.hard.design;

class Node {
    CharNode[] children;
    boolean isEnd;

    public Node() {
        children = new CharNode[26];
        isEnd = false;
    }


}

public class Trie {
    CharNode root;

    public Trie() {
        this.root = new CharNode();
    }

    public void insert(String word) {
        CharNode node = root;

        char[] chrs = word.toCharArray();

        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new CharNode();
            }
            node = node.children[idx];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        CharNode node = root;
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
        CharNode node = root;
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

