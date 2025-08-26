package com.ven.medium.dp;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount];
        return backtrack(coins, amount, memo);
    }

    private int backtrack(int[] coins, int amount, Integer[] memo) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        if (memo[amount - 1] != null) {
            return memo[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = backtrack(coins, amount - coins[i], memo);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        return memo[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Coins: " + Arrays.toString(coins1) + ", Amount: " + amount1);
        System.out.println("Minimum coins: " + solver.coinChange(coins1, amount1));
        System.out.println();

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Coins: " + Arrays.toString(coins2) + ", Amount: " + amount2);
        System.out.println("Minimum coins: " + solver.coinChange(coins2, amount2));
        System.out.println();

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Coins: " + Arrays.toString(coins3) + ", Amount: " + amount3);
        System.out.println("Minimum coins: " + solver.coinChange(coins3, amount3));
        System.out.println();

        int[] coins4 = {186, 419, 83, 408};
        int amount4 = 6249;
        System.out.println("Coins: " + Arrays.toString(coins4) + ", Amount: " + amount4);
        System.out.println("Minimum coins: " + solver.coinChange(coins4, amount4));
    }
}
