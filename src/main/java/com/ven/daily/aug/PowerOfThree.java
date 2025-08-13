package com.ven.daily.aug;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 27
 * Output: true
 * Explanation: 27 = 33
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3x = 0.
 * Example 3:
 * <p>
 * Input: n = -1
 * Output: false
 * Explanation: There is no x where 3x = (-1).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= n <= 231 - 1
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        int n = 27; // Example input
        System.out.println("Is " + n + " a power of three? " + powerOfThree.isPowerOfThree(n));
    }
}
