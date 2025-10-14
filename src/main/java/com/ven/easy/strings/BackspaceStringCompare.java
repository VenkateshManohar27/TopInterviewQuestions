package com.ven.easy.strings;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 * <p>
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 * <p>
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();


        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int length = Math.max(schar.length, tchar.length);


        for (int i = 0; i < length; i++) {
            if (i < schar.length) {
                char sc = schar[i];
                if (sc == '#') {
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                } else {
                    sb.append(sc);
                }

            }

            if (i < tchar.length) {
                char tc = tchar[i];
                if (tc == '#') {
                    if (tb.length() > 0) {
                        tb.setLength(tb.length() - 1);
                    }
                } else {
                    tb.append(tc);
                }
            }
        }
        // System.out.println(sb.toString());
        // System.out.println(tb.toString());
        return sb.toString().equals(tb.toString());
    }

    public static void main(String[] args) {
        BackspaceStringCompare solution = new BackspaceStringCompare();
        String s1 = "ab#c";
        String t1 = "ad#c";
        boolean result1 = solution.backspaceCompare(s1, t1);
        System.out.println("Result 1: " + result1); // Output: true

        String s2 = "ab##";
        String t2 = "c#d#";
        boolean result2 = solution.backspaceCompare(s2, t2);
        System.out.println("Result 2: " + result2); // Output: true

        String s3 = "a#c";
        String t3 = "b";
        boolean result3 = solution.backspaceCompare(s3, t3);
        System.out.println("Result 3: " + result3); // Output: false
    }
}
