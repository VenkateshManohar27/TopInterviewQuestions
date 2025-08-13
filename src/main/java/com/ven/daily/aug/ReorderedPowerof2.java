package com.ven.daily.aug;

import java.util.Arrays;

/**
 * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this so that the resulting number is a power of two.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 10
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 109
 */
public class ReorderedPowerof2 {
    public boolean reorderedPowerOf2(int n) {
        int[] A = count(n);

        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(A, count(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] count(int n) {
        int[] res = new int[10];

        while (n > 0) {
            res[n % 10]++;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ReorderedPowerof2 reorderedPowerof2 = new ReorderedPowerof2();
        int n = 46; // Example input
        boolean result = reorderedPowerof2.reorderedPowerOf2(n);
        System.out.println("Can " + n + " be reordered to form a power of two? " + result); // Output: true or false based on the input
    }
}
