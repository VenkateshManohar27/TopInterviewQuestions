package com.ven.strings;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * <p>
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * <p>
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            freq[ch[i] - 'a']++;
        }

        for (int i = 0; i < ch.length; i++) {
            if (freq[ch[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        String s = "loveleetcode";
        int result = firstUniqueCharacter.firstUniqChar(s);
        System.out.println("The index of the first non-repeating character is: " + result); // Output: 2
    }
}
