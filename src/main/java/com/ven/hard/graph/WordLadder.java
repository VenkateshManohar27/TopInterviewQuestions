package com.ven.hard.graph;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 0;

        Map<String, Set<String>> combinations = new HashMap<>();
        //addStart(beginWord, combinations);
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            addCombinations(word, combinations);
        }
        //System.out.println(combinations);

        Set<String> visited = new HashSet<>();

        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            //System.out.println(q);
            while (size > 0) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return step + 1;
                }
                List<String> li = getAllPatterns(word);
                //System.out.println("listL :"+li);
                for (String w : li) {
                    Set<String> combination = combinations.getOrDefault(w, new HashSet<>());
                    for (String str : combination) {
                        if (!visited.contains(str)) {
                            visited.add(str);
                            q.offer(str);
                        }
                    }

                }
                size--;
            }

            step++;
        }


        return 0;
    }

    private List<String> getAllPatterns(String word) {
        char[] chs = word.toCharArray();
        List<String> li = new ArrayList<>();
        for (int j = 0; j < chs.length; j++) {
            char temp = chs[j];
            chs[j] = '*';
            li.add(new String(chs));
            //combinations.computeIfAbsent(word, k -> new HashSet<>()).add(new String(chs));
            chs[j] = temp;
        }
        return li;
    }

    private void addCombinations(String word, Map<String, Set<String>> combinations) {
        char[] chs = word.toCharArray();

        for (int j = 0; j < chs.length; j++) {
            char temp = chs[j];
            chs[j] = '*';
            combinations.computeIfAbsent(new String(chs), k -> new HashSet<>()).add(word);
            //combinations.computeIfAbsent(word, k -> new HashSet<>()).add(new String(chs));
            chs[j] = temp;
        }
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Result : " + wl.ladderLength(beginWord, endWord, wordList));
    }
}
