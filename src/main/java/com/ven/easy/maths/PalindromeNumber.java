package com.ven.easy.maths;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int[] digits = new int[32];
        int j = digits.length - 1;
        int i = 0;
        if (x < 0)
            return false;
        while (x > 0) {
            i = j;
            digits[j--] = x % 10;
            x /= 10;
        }

        // for(int n : digits) {
        //     System.out.print(n+",");
        // }
        // System.out.println();

        j = digits.length - 1;

        while (i < j) {
            if (digits[i] != digits[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(121));
        System.out.println(p.isPalindrome(-121));
        System.out.println(p.isPalindrome(10));
        System.out.println(p.isPalindrome(12321));
        System.out.println(p.isPalindrome(123321));
        System.out.println(p.isPalindrome(0));
    }
}
