package com.ven.medium.other;

import java.util.Stack;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvaluateReversePolishNotation {
    private final String OPERATORS = "+-*/";

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (OPERATORS.contains(s)) {
                int a = st.pop();
                int b = st.pop();
                st.push(operate(s, a, b));
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }

    private int operate(String operand, int a, int b) {
        int res = 0;
        switch (operand) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = b - a;
                break;

            case "*":
                res = a * b;
                break;

            case "/":
                res = b / a;
                break;

        }

        return res;
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation calculator = new EvaluateReversePolishNotation();

        test(calculator, new String[]{"2", "1", "+", "3", "*"}, 9);         // (2 + 1) * 3 = 9
        test(calculator, new String[]{"4", "13", "5", "/", "+"}, 6);        // 13 / 5 = 2 → 4 + 2 = 6
        test(calculator, new String[]{"10", "6", "9", "3", "/", "-", "*"}, 60); // 9 / 3 = 3 → 6 - 3 = 3 → 10 * 3 = 30
        test(calculator, new String[]{"3", "4", "+", "2", "*", "7", "/"}, 2);   // ((3 + 4) * 2) / 7 = 14 / 7 = 2
        test(calculator, new String[]{"5"}, 5); // Single number

        // Division edge case: negative result
        test(calculator, new String[]{"6", "10", "-"}, 4); // 10 - 6 = 4

        // Negative division
        test(calculator, new String[]{"10", "-5", "/"}, -2); // 10 / -5 = -2
    }

    private static void test(EvaluateReversePolishNotation calculator, String[] input, int expected) {
        int result = calculator.evalRPN(input);
        if (result == expected) {
            System.out.println("Test passed: " + String.join(" ", input) + " = " + result);
        } else {
            System.out.println("Test FAILED: " + String.join(" ", input) +
                    " | Expected: " + expected + ", Got: " + result);
        }
    }
}
