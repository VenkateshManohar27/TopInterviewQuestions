package com.ven.medium.math;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * <p>
 * You must not use any built-in exponent function or operator.
 * <p>
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= x <= 231 - 1
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }

        return right;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(8)); // Output: 2
        System.out.println(sqrtX.mySqrt(4)); // Output: 2
        System.out.println(sqrtX.mySqrt(1)); // Output: 1
        System.out.println(sqrtX.mySqrt(0)); // Output: 0
        System.out.println(sqrtX.mySqrt(16)); // Output: 4
        System.out.println(sqrtX.mySqrt(2147395599)); // Output: 46339
    }
}
