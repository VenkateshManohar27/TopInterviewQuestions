package com.ven.medium.math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 * <p>
 * Input: n = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 104
 * <p>
 * <p>
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
        System.out.println(ftz.trailingZeroes(3));  // Output: 0
        System.out.println(ftz.trailingZeroes(5));  // Output: 1
        System.out.println(ftz.trailingZeroes(10)); // Output: 2
        System.out.println(ftz.trailingZeroes(25)); // Output: 6
    }
}
