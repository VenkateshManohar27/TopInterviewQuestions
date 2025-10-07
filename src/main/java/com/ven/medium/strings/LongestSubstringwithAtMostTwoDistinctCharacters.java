package com.ven.medium.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: s = "ccaabbb"
 * Output: 5
 * Explanation: The substring is "aabbb" which its length is 5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of English letters.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int longest = 0;
        int l = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        char[] chrs = s.toCharArray();
        for (int r = 0; r < chrs.length; r++) {
            charFreq.put(chrs[r], charFreq.getOrDefault(chrs[r], 0) + 1);
            while (charFreq.size() > 2) {
                char c = chrs[l++];
                charFreq.put(c, charFreq.get(c) - 1);
                if (charFreq.get(c) == 0) {
                    charFreq.remove(c);
                }
            }

            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters obj = new LongestSubstringwithAtMostTwoDistinctCharacters();
        String s = "eceba";
        System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
    }
}
