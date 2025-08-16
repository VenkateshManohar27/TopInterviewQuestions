package com.ven.medium.strings;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        String palindrome = "";
        int maxlength = 0;
        int[] ans = new int[2];
        for (int i = 0; i < chs.length; i++) {
            int odd = expand(chs, i, i);
            int even = expand(chs, i, i + 1);

            if (odd > ans[1] - ans[0] + 1) {
                int dist = odd / 2;
                ans[0] = i - dist;
                ans[1] = i + dist;
            }

            if (even > ans[1] - ans[0] + 1) {
                int dist = (even / 2) - 1;
                ans[0] = i - dist;
                ans[1] = i + 1 + dist;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    private int expand(char[] ch, int i, int j) {
        while (i >= 0 && j < ch.length && ch[i] == ch[j]) {
            i--;
            j++;
        }

        return j - i - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String input = "babad"; // Example input
        String result = solution.longestPalindrome(input);
        System.out.println("Longest palindromic substring: " + result);
    }
}
