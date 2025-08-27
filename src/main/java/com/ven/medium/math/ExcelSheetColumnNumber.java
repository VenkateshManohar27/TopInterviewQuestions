package com.ven.medium.math;

/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 *
 * Input: columnTitle = "A"
 * Output: 1
 * Example 2:
 *
 * Input: columnTitle = "AB"
 * Output: 28
 * Example 3:
 *
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 *
 * Constraints:
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        char[] chrs = columnTitle.toCharArray();
        int number = 0;
        for (int i = 0; i < chrs.length; i++) {
            char c = chrs[i];
            int index = (int) (c - 'A' + 1);
            number = 26 * number + index;
        }
        return number;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber converter = new ExcelSheetColumnNumber();

        // Test cases
        test(converter, "A", 1);
        test(converter, "Z", 26);
        test(converter, "AA", 27);
        test(converter, "AB", 28);
        test(converter, "BA", 53);
        test(converter, "ZY", 701);
        test(converter, "ZZ", 702);
        test(converter, "AAA", 703);
        test(converter, "ABC", 731);
    }

    private static void test(ExcelSheetColumnNumber converter, String input, int expected) {
        int result = converter.titleToNumber(input);
        if (result == expected) {
            System.out.println("Test passed for input \"" + input + "\": " + result);
        } else {
            System.out.println("Test FAILED for input \"" + input + "\". Expected: " + expected + ", Got: " + result);
        }
    }
}
