package com.ven.meta.hard;

import java.util.Arrays;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        char[] tchar = t.toCharArray();
        int[] freq = new int[52];

        for (int i = 0; i < tchar.length; i++) {
            incrFreq(tchar[i], freq);
        }

        int l = 0;
        char[] chr = s.toCharArray();
        int minimum = Math.max(chr.length, tchar.length) + 1;
        int[] window = new int[2];
        Arrays.fill(window, -1);
        int[] curr = new int[52];
        for (int r = 0; r < chr.length; r++) {
            incrFreq(chr[r], curr);
            while (l <= r && allCharFreqMatch(freq, curr)) {
                //System.out.println("matched : "+c);
                if (r - l + 1 < minimum) {
                    minimum = r - l + 1;
                    window[0] = l;
                    window[1] = r;
                }
                decrFreq(chr[l++], curr);
            }

        }
        if (window[0] == -1) {
            return "";
        }
        return s.substring(window[0], window[1] + 1);

    }

    private void incrFreq(char c, int[] f) {
        if (c >= 'a' && c <= 'z') {
            f[c - 'a']++;
        } else {
            f[c - 'A' + 26]++;
        }
    }

    private void decrFreq(char c, int[] f) {
        if (c >= 'a' && c <= 'z') {
            f[c - 'a']--;
        } else {
            f[c - 'A' + 26]--;
        }
    }

    private boolean allCharFreqMatch(int[] freq, int[] curr) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > curr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s1, t1) + "\""); // Expected: "BANC"

        String s2 = "a";
        String t2 = "a";
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s2, t2) + "\""); // Expected: "a"

        String s3 = "a";
        String t3 = "aa";
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s3, t3) + "\""); // Expected: ""
    }
}
