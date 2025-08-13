package com.ven.daily.aug;

import java.util.Arrays;

/**
 * Given two positive integers n and x.
 * <p>
 * Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.
 * <p>
 * Since the result can be very large, return it modulo 109 + 7.
 * <p>
 * For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10, x = 2
 * Output: 1
 * Explanation: We can express n as the following: n = 32 + 12 = 10.
 * It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.
 * Example 2:
 * <p>
 * Input: n = 4, x = 1
 * Output: 2
 * Explanation: We can express n in the following ways:
 * - n = 41 = 4.
 * - n = 31 + 11 = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 300
 * 1 <= x <= 5
 */
public class WaystoExpressanIntegerasSumofPowers {

    private static int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int[][] memo = new int[301][301];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return recur(n, 1, 0, x, memo);
    }

    private int recur(int n, int num, int sum, int pow, int[][] memo) {
        if (n == sum) {
            return 1;
        }
        int val = (int) Math.pow(num, pow);

        if (val + sum > n) {
            return 0;
        }
        if (memo[num][sum] != -1)
            return memo[num][sum];
        int take = recur(n, num + 1, sum + val, pow, memo);
        int notTake = recur(n, num + 1, sum, pow, memo);

        return memo[num][sum] = (take + notTake) % MOD;
    }

    public static void main(String[] args) {
        WaystoExpressanIntegerasSumofPowers waysToExpress = new WaystoExpressanIntegerasSumofPowers();
        int n1 = 10, x1 = 2;
        System.out.println("Number of ways to express " + n1 + " as sum of " + x1 + "th powers: " + waysToExpress.numberOfWays(n1, x1)); // Output: 1

        int n2 = 4, x2 = 1;
        System.out.println("Number of ways to express " + n2 + " as sum of " + x2 + "th powers: " + waysToExpress.numberOfWays(n2, x2)); // Output: 2
    }
}
