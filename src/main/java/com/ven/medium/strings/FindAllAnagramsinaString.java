package com.ven.medium.strings;

import java.util.ArrayList;
import java.util.List;


/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        int[] freq = new int[26];
        char[] pc = p.toCharArray();
        for (int i = 0; i < pc.length; i++) {
            freq[pc[i] - 'a']++;
        }

        int[] currFreq = new int[26];
        char[] sc = s.toCharArray();
        for (int i = 0; i < pc.length - 1; i++) {
            currFreq[sc[i] - 'a']++;
        }
        int left = 0;
        for (int i = pc.length - 1; i < sc.length; i++) {
            currFreq[sc[i] - 'a']++;
            if (checkAnagram(freq, currFreq)) {
                res.add(left);
            }
            currFreq[sc[left] - 'a']--;
            left++;
        }
        return res;
    }

    private boolean checkAnagram(int[] freq, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        FindAllAnagramsinaString solution = new FindAllAnagramsinaString();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = solution.findAnagrams(s, p);
        System.out.println(res);
    }
}
