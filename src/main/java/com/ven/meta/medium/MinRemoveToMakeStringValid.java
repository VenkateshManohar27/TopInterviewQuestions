package com.ven.meta.medium;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 *
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * <p>
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is either '(' , ')', or lowercase English letter.
 */
public class MinRemoveToMakeStringValid {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> parentheses = new Stack<>();
        char[] chrs = s.toCharArray();
        for(int i = 0; i < chrs.length; i++) {
            if(!(chrs[i] ==')' || chrs[i] == '(')) {
                continue;
            }
            if(chrs[i] == ')' && !parentheses.isEmpty() && chrs[parentheses.peek()] == '(') {
                parentheses.pop();
            }else {
                parentheses.push(i);
            }
        }

        //System.out.println(parentheses);
        int length = chrs.length - parentheses.size();

        char[] str = new char[length];

        for(int i = chrs.length -1, j = str.length-1; i >= 0; i--) {
            if(!parentheses.isEmpty() && parentheses.peek() == i) {
                parentheses.pop();
                continue;
            }else {
                str[j--]=chrs[i];
            }
        }

        return new String(str);
    }

    public static void main(String[] args) {
        MinRemoveToMakeStringValid remover = new MinRemoveToMakeStringValid();
        String s1 = "lee(t(c)o)de)";
        System.out.println(remover.minRemoveToMakeValid(s1)); // Output: "lee(t(c)o)de"

        String s2 = "a)b(c)d";
        System.out.println(remover.minRemoveToMakeValid(s2)); // Output: "ab(c)d"

        String s3 = "))((";
        System.out.println(remover.minRemoveToMakeValid(s3)); // Output: ""
    }
}
