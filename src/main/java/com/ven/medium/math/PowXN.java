package com.ven.medium.math;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -104 <= xn <= 104
 */
public class PowXN {
    private double binaryExp(double x, long n) {
        // Base case, to stop recursive calls.
        if (n == 0) {
            return 1;
        }

        // Handle case where, n < 0.
        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }

        // Perform Binary Exponentiation.
        // If 'n' is odd we perform Binary Exponentiation on 'n - 1' and multiply result with 'x'.
        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        }
        // Otherwise we calculate result by performing Binary Exponentiation on 'n'.
        else {
            return binaryExp(x * x, n / 2);
        }
    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        double x = 2.00000;
        int n = 10;
        double result = solution.myPow(x, n);
        System.out.println("Result: " + result); // Expected output: 1024.00000
    }

}
