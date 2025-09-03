package com.ven.medium.other;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * <p>
 * Input: a = 2, b = 3
 * Output: 5
 * <p>
 * Constraints:
 * <p>
 * -1000 <= a, b <= 1000
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // Calculate carry
            a = a ^ b;               // Sum without carry
            b = carry;               // Update b to carry
        }
        return a;
    }

    public static void main(String[] args) {
        SumofTwoIntegers solution = new SumofTwoIntegers();
        int a1 = 1, b1 = 2;
        System.out.println("Sum of " + a1 + " and " + b1 + " is: " + solution.getSum(a1, b1)); // Expected: 3

        int a2 = -2, b2 = 3;
        System.out.println("Sum of " + a2 + " and " + b2 + " is: " + solution.getSum(a2, b2)); // Expected: 1

        int a3 = -5, b3 = -7;
        System.out.println("Sum of " + a3 + " and " + b3 + " is: " + solution.getSum(a3, b3)); // Expected: -12

        int a4 = 0, b4 = 0;
        System.out.println("Sum of " + a4 + " and " + b4 + " is: " + solution.getSum(a4, b4)); // Expected: 0

        int a5 = Integer.MAX_VALUE, b5 = 1;
        System.out.println("Sum of " + a5 + " and " + b5 + " is: " + solution.getSum(a5, b5)); // Expected: Integer.MIN_VALUE (overflow case)
    }
}
