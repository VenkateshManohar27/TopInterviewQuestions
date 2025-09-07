package com.ven.meta.hard;

class Node {
    Node[] children;
    boolean isEnd;

    public Node() {
        this.children = new Node[26];
        this.isEnd = false;
    }

    /*public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < children.length; i++) {
            sb.append(children[i] == null ? "" : (char) ('a' + i));
            sb.append(",");
        }
        sb.append("]");
        sb.append(" is end :" + isEnd);
        return sb.toString();
    }*/
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        char[] chrs = word.toCharArray();
        Node node = root;
        for (int i = 0; i < chrs.length; i++) {
            int charIndex = chrs[i] - 'a';
            if (node.children[charIndex] == null) {
                node.children[charIndex] = new Node();
            }
            node = node.children[charIndex];
        }
        node.isEnd = true;
    }

    private boolean search(char[] chrs, int start, Node node, int len) {
        //System.out.println("start index : "+start+" , len:"+len);
        if (start > len) {
            return node.isEnd;
        }
        //System.out.println("start index : "+start);
        //System.out.println(node);
        for (int i = start; i < chrs.length; i++) {
            char c = chrs[i];
            if (c == '.') {
                boolean res = false;
                for (int j = 0; j < node.children.length; j++) {
                    if (node.children[j] != null) {
                        res |= search(chrs, i + 1, node.children[j], len);
                    }
                    //System.out.println(j+" res:"+res);
                    if (res)
                        return res;
                }
                return res;
            } else {
                //System.out.println("char is ["+c+"]");
                int charIndex = c - 'a';
                //System.out.println(node);
                if (node.children[charIndex] == null) {
                    return false;
                }
                node = node.children[charIndex];
            }
        }
        // System.out.println("The end");
        //System.out.println(node);
        return node.isEnd;
    }

    public boolean search(String word) {
        //System.out.println("Search "+word);
        char[] chrs = word.toCharArray();
        return search(chrs, 0, root, word.length() - 1);
        //node.isEnd = true;
    }
}

public class AddandSearchWord {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
