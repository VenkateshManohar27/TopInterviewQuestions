package com.ven.meta.medium;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int[] freq = new int[26];
        for (int i = 0; i < chrs1.length; i++) {
            freq[chrs1[i] - 'a']++;
        }

        int length = chrs1.length;
        int left = 0;
        int[] freq2 = new int[26];
        for (int right = 0; right < chrs2.length; right++) {
            char c = chrs2[right];

            freq2[c - 'a']++;

            while ((right - left + 1) > length) {
                char l = chrs2[left++];
                freq2[l - 'a']--;
            }

            if (check(freq, freq2)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] freq, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = solution.checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
    }
}
