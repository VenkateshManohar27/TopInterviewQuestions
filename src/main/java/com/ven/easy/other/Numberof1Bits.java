package com.ven.easy.other;

/**
 * Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 11
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * The input binary string 1011 has a total of three set bits.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 128
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * The input binary string 10000000 has a total of one set bit.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 2147483645
 * <p>
 * Output: 30
 * <p>
 * Explanation:
 * <p>
 * The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Numberof1Bits numberof1Bits = new Numberof1Bits();
        int n = 11; // Example input
        int result = numberof1Bits.hammingWeight(n);
        System.out.println("Number of set bits in " + n + " is: " + result);
    }
}
