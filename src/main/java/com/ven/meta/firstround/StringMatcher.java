package com.ven.meta.firstround;

/**
 * The problem requires determining if a given target string can be "matched"
 * by a pattern string containing characters and numbers, where numbers
 * represent a count of characters to skip. For instance, "i18n" matches
 * "internationalization" because 'i' matches 'i', '18' skips 18 characters,
 * and 'n' matches 'n'.
 */
public class StringMatcher {
    public boolean match(String pattern, String target) {

        //use character arrays for better performance
        char[] pArr = pattern.toCharArray();
        char[] tArr = target.toCharArray();
        int pLen = pArr.length;
        int tLen = tArr.length;
        int pIndex = 0, tIndex = 0;
        while (pIndex < pLen && tIndex < tLen) {
            char pChar = pArr[pIndex];

            if (Character.isDigit(pChar)) {
                int numStart = pIndex;
                while (pIndex < pLen && Character.isDigit(pArr[pIndex])) {
                    pIndex++;
                }
                int skipCount = Integer.parseInt(pattern.substring(numStart, pIndex));
                tIndex += skipCount;
            } else {
                if (tIndex >= tLen || pChar != tArr[tIndex]) {
                    return false;
                }
                pIndex++;
                tIndex++;
            }
        }

        return pIndex == pLen && tIndex == tLen;
    }

    public static void main(String[] args) {
        StringMatcher matcher = new StringMatcher();
        System.out.println(matcher.match("i18n", "internationalization")); // true
        System.out.println(matcher.match("f6k", "facebook")); // true
        System.out.println(matcher.match("f6k", "focus")); // false
        System.out.println(matcher.match("a3b", "applepieb")); // false
        System.out.println(matcher.match("a3b", "aplepieb")); // false (wrong number of skipped chars)
        System.out.println(matcher.match("abc", "abc")); // true
        System.out.println(matcher.match("a1b", "ab")); // false
        System.out.println(matcher.match("a1b", "acb")); // true
    }
}
