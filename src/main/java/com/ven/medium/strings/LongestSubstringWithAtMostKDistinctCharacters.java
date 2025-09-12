package com.ven.medium.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * Example 2:
 * <p>
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int length = 0;

        int left = 0;
        char[] chrs = s.toCharArray();
        Map<Character, Integer> seen = new HashMap<>();
        for (int right = 0; right < chrs.length; right++) {
            char c = chrs[right];
            seen.put(c, seen.getOrDefault(c, 0) + 1);
            while (seen.size() > k) {
                char l = chrs[left];
                seen.put(l, seen.get(l) - 1);
                if (seen.get(l) == 0) {
                    seen.remove(l);
                }
                left++;
            }
            length = Math.max(length, right - left + 1);
        }

        return length;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters solution = new LongestSubstringWithAtMostKDistinctCharacters();
        String input = "eceba"; // Example input
        int k = 2;
        int result = solution.lengthOfLongestSubstringKDistinct(input, k);
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + result);
    }
}