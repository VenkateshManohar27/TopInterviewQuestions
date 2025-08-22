package com.ven.easy.maths;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: 0
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * @param n the upper limit (exclusive)
     * @return the count of prime numbers less than n
     */
    public int countPrimes(int n) {
        if (n < 2) return 0;

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        int n = 10; // Example input
        System.out.println("Number of primes less than " + n + ": " + countPrimes.countPrimes(n));
    }
}
