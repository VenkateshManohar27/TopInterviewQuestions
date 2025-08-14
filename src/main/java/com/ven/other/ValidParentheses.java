package com.ven.other;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * <p>
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(]"
 * <p>
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: s = "([])"
 * <p>
 * Output: true
 * <p>
 * Example 5:
 * <p>
 * Input: s = "([)]"
 * <p>
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();

        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty())
                    return false;

                char prev = chs[st.pop()];
                if (c == ')' && prev != '(') {
                    return false;
                } else if (c == '}' && prev != '{') {
                    return false;
                } else if (c == ']' && prev != '[') {
                    return false;
                }

            } else {
                st.push(i);
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "([])"; // Example input
        boolean result = validParentheses.isValid(s);
        System.out.println("Is the string \"" + s + "\" valid? " + result); // Output: true
    }
}
