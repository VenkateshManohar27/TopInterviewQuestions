package com.ven.easy.strings;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        char[] chrs = s.toCharArray();
        int l = 0, r = chrs.length - 1;

        while (l < r) {
            if (chrs[l] != chrs[r]) {
                return checkValid(chrs, l + 1, r) || checkValid(chrs, l, r - 1);
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean checkValid(char[] chrs, int l, int r) {
        while (l < r) {
            if (chrs[l] != chrs[r]) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII solution = new ValidPalindromeII();
        String input = "abca"; // Example input
        boolean result = solution.validPalindrome(input);
        System.out.println("Can the string be a palindrome after deleting at most one character? " + result);
    }
}
