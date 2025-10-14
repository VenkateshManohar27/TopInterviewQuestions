package com.ven.medium.strings;

/**
 * Sometimes people repeat letters to represent extra feeling. For example:
 * <p>
 * "hello" -> "heeellooo"
 * "hi" -> "hiiii"
 * In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
 * <p>
 * You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.
 * <p>
 * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
 * Return the number of query strings that are stretchy.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "heeellooo", words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 * Example 2:
 * <p>
 * Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, words.length <= 100
 * 1 <= words[i].length <= 100
 * s and words[i] consist of lowercase letters.
 */
public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int count = 0;

        int i = 0;
        int j = 0;
        int k = 0;
        while (k < words.length) {
            String t = words[k];
            i = 0;
            j = 0;

            while (i < s.length() && j < t.length()) {
                char sc = s.charAt(i);
                char tc = t.charAt(j);
                if (sc != tc) {
                    break;
                }

                int scount = 1;
                int l = i + 1;
                while (l < s.length() && sc == s.charAt(l)) {
                    scount++;
                    l++;
                }
                int tcount = 1;
                int m = j + 1;
                while (m < t.length() && tc == t.charAt(m)) {
                    tcount++;
                    m++;
                }

                if (scount != tcount && (scount < tcount || scount < 3)) {
                    break;
                }

                i = l;
                j = m;
            }
            if (i == s.length() && j == t.length()) {
                count++;
            }
            k++;
        }
        return count;
    }

    public static void main(String[] args) {
        ExpressiveWords ew = new ExpressiveWords();
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println("Result : " + ew.expressiveWords(s, words));
    }

}
