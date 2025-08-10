package com.ven.strings;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: s = "42"
 * <p>
 * Output: 42
 * <p>
 * Explanation:
 * <p>
 * The underlined characters are what is read in and the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * Example 2:
 * <p>
 * Input: s = " -042"
 * <p>
 * Output: -42
 * <p>
 * Explanation:
 * <p>
 * Step 1: "   -042" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -042" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
 *                ^
 * Example 3:
 * <p>
 * Input: s = "1337c0d3"
 * <p>
 * Output: 1337
 * <p>
 * Explanation:
 * <p>
 * Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
 *              ^
 * Example 4:
 * <p>
 * Input: s = "0-1"
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * Step 1: "0-1" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
 *           ^
 * Example 5:
 * <p>
 * Input: s = "words and 987"
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * Reading stops at the first non-digit character 'w'.
 * <p>
 *
 *
 * Constraints:
 * <p>
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
public class StringtoIntegerAtoI {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        long sign = s.charAt(0) == '-' ? -1: 1;

        //System.out.println("sign :"+sign);
        long val = 0;
        char[] ch = s.toCharArray();

        boolean digit = false;
        for(int i = 0; i < ch.length; i++) {
            if(i == 0 && (ch[i] == '+' || ch[i] =='-')){
                continue;
            }
            if(!digit && ch[i] == '0'){
                continue;
            }

            if(ch[i] < '0' || ch[i] > '9'){
                break;
            }
            digit = true;
            int d = (ch[i] - '0');

            // Check overflow and underflow conditions.
            if (
                    (val > Integer.MAX_VALUE / 10) ||
                            (val == Integer.MAX_VALUE / 10 &&
                                    d > Integer.MAX_VALUE % 10)
            ) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            val = val * 10 + d;
        }
        //System.out.println("val :"+val);
        val = (sign*val);

        //System.out.println("val :"+val);

        return (int)val;
    }

    public static void main(String[] args) {
        StringtoIntegerAtoI stringtoIntegerAtoI = new StringtoIntegerAtoI();
        String s = "   -42";
        int result = stringtoIntegerAtoI.myAtoi(s);
        System.out.println("The converted integer is: " + result); // Output: -42
    }
}
