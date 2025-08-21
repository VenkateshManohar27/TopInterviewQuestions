package com.ven.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> li = new ArrayList<>();
        backtrack(new StringBuilder(), 0, n, li);
        return li;
    }

    private void backtrack(StringBuilder sb, int open, int n, List<String> li) {
        if (sb.length() == 2 * n) {
            if (open == 0)
                li.add(sb.toString());
            return;
        }


        if (open > 0) {
            sb.append(")");
            backtrack(sb, open - 1, n, li);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open < n) {
            sb.append("(");
            backtrack(sb, open + 1, n, li);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 3;
        List<String> parentheses = solution.generateParenthesis(n);
        System.out.println("Generated Parentheses: " + parentheses);
    }
}
