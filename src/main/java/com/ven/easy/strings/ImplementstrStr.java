package com.ven.easy.strings;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * <p>
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int start = 0;

        char[] hay = haystack.toCharArray();
        char[] needl = needle.toCharArray();

        while (i < hay.length && j < needl.length) {

            if (hay[i] != needl[j]) {
                j = 0;
                start++;
                while (start < hay.length && hay[start] != needl[j]) {
                    start++;
                }
                // System.out.println("i : "+ i+" , start: "+start);
                i = start;
            } else {
                i++;
                j++;

                if (j == needl.length)
                    return start;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr implementstrStr = new ImplementstrStr();
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = implementstrStr.strStr(haystack, needle);
        System.out.println("The index of the first occurrence of \"" + needle + "\" in \"" + haystack + "\" is: " + result); // Output: 0
    }
}
