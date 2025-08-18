package com.ven.daily.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.
 * <p>
 * You are restricted with the following rules:
 * <p>
 * The division operator '/' represents real division, not integer division.
 * For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
 * For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
 * You cannot concatenate numbers together
 * For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
 * Return true if you can get such expression that evaluates to 24, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cards = [4,1,8,7]
 * Output: true
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 * <p>
 * Input: cards = [1,2,1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * cards.length == 4
 * 1 <= cards[i] <= 9
 */
public class TwentyFourGame {
    private List<Double> generatePossibleResults(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (b != 0) {
            res.add(a / b);
        }
        if (a != 0) {
            res.add(b / a);
        }
        return res;
    }

    // Check if using current list we can react result 24.
    private boolean checkIfResultReached(List<Double> list) {
        if (list.size() == 1) {
            // Base Case: We have only one number left, check if it is approximately 24.
            return Math.abs(list.get(0) - 24) <= 0.1;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                // Create a new list with the remaining numbers and the new result.
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != j && k != i) {
                        newList.add(list.get(k));
                    }
                }

                // For any two numbers in our list,
                // we perform every operation one by one.
                for (double res : generatePossibleResults(list.get(i), list.get(j))) {
                    // Push the new result in the list
                    newList.add(res);

                    // Check if using this new list we can obtain the result 24.
                    if (checkIfResultReached(newList)) {
                        return true;
                    }

                    // Backtrack: remove the result from the list.
                    newList.remove(newList.size() - 1);
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }

        return checkIfResultReached(list);
    }

    public static void main(String[] args) {
        TwentyFourGame solution = new TwentyFourGame();
        int[] cards1 = {4, 1, 8, 7};
        System.out.println("Can form 24: " + solution.judgePoint24(cards1)); // Output: true

        int[] cards2 = {1, 2, 1, 2};
        System.out.println("Can form 24: " + solution.judgePoint24(cards2)); // Output: false
    }
}
