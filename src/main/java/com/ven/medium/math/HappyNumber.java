package com.ven.medium.math;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int count = 0;

        while (n != 1) {
            count++;
            if (count >= 100) {
                return false;
            }

            int sum = 0;

            while (n > 0) {
                int a = n % 10;
                sum += Math.pow(a, 2);
                n /= 10;
            }
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        System.out.println("19 should be true : " + happyNumber.isHappy(19));
        System.out.println("2 should be false : " + happyNumber.isHappy(2));
        System.out.println("7 should be true : " + happyNumber.isHappy(7));
    }
}
