package com.ven.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsPhoneNumber {
    private static final String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> li = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return li;
        }

        backtrack(0, new StringBuilder(), li, digits);


        return li;
    }

    private void backtrack(int in, StringBuilder sb, List<String> li, String digits) {
        if (in >= digits.length()) {
            li.add(sb.toString());
            return;
        }

        int index = digits.charAt(in) - '0';
        char[] chrs = strs[index].toCharArray();

        for (int i = 0; i < chrs.length; i++) {
            sb.append(chrs[i]);
            backtrack(in + 1, sb, li, digits);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber solution = new LetterCombinationsPhoneNumber();
        String digits1 = "23";
        System.out.println("Letter combinations for " + digits1 + ": " + solution.letterCombinations(digits1)); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        String digits2 = "";
        System.out.println("Letter combinations for " + digits2 + ": " + solution.letterCombinations(digits2)); // Output: []

        String digits3 = "2";
        System.out.println("Letter combinations for " + digits3 + ": " + solution.letterCombinations(digits3)); // Output: ["a","b","c"]
    }
}
