package com.ven.hard.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 * <p>
 * <p>
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        isEnd = false;
    }


}

public class WordSearchII {
    TrieNode root = null;
    private final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        List<String> li = new ArrayList<>();
        for (String w : words) {
            addWord(w, root);
        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    dfs(i, j, board, li, root.children[board[i][j] - 'a'], sb, seen);
                }
            }
        }

        return li;
    }


    private void dfs(int r, int c, char[][] board, List<String> li, TrieNode node, StringBuilder sb, Set<String> seen) {

        if (node.isEnd) {
            if (!seen.contains(sb.toString())) {
                li.add(sb.toString());
                seen.add(sb.toString());
            }
            //return;
        }
        char temp = board[r][c];
        board[r][c] = '#';

        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (isValid(nr, nc, board) && board[nr][nc] != '#' && node.children[board[nr][nc] - 'a'] != null) {
                sb.append(board[nr][nc]);
                //System.out.println(sb);
                dfs(nr, nc, board, li, node.children[board[nr][nc] - 'a'], sb, seen);
                sb.deleteCharAt(sb.length() - 1);
            }


        }

        board[r][c] = temp;

    }

    private boolean isValid(int r, int c, char[][] b) {
        return !(r < 0 || r >= b.length || c < 0 || c >= b[0].length);
    }

    private void addWord(String w, TrieNode node) {
        char[] chrs = w.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            int in = chrs[i] - 'a';
            if (node.children[in] == null) {
                node.children[in] = new TrieNode();
            }
            node = node.children[in];
        }
        node.isEnd = true;
    }

    public static void main(String[] args) {
        WordSearchII obj = new WordSearchII();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> result = obj.findWords(board, words);
        System.out.println("Words found: " + result);
    }
}
