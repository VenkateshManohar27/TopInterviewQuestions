package com.ven.strings;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * <p>
 *
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public int reverse(int x) {
        int sign = (x >= 0)? 1: -1;

        long rev = 0;
        x = sign * x;
        while(x > 0) {
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;

            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }

        return (int)(sign * rev);
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = -123;
        int result = reverseInteger.reverse(x);
        System.out.println("Reversed integer: " + result); // Output: -321
    }
}
