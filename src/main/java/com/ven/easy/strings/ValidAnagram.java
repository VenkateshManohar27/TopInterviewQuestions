package com.ven.easy.strings;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * <p>
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();

        for (int i = 0; i < sch.length; i++) {
            freq[sch[i] - 'a']++;
            freq[tch[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean result = validAnagram.isAnagram(s, t);
        System.out.println("Is \"" + t + "\" an anagram of \"" + s + "\"? " + result); // Output: true
    }
}
