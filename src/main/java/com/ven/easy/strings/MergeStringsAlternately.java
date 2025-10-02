package com.ven.easy.strings;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 * <p>
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 * <p>
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder();

        while (i < w1.length || j < w2.length) {
            if (i < w1.length) {
                sb.append(w1[i++]);
            }

            if (j < w2.length) {
                sb.append(w2[j++]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately solution = new MergeStringsAlternately();
        String word1 = "abcd";
        String word2 = "pq";
        String result = solution.mergeAlternately(word1, word2);
        System.out.println("Merged string: " + result); // Output: "apbqcd"
    }
}
