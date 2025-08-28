package com.ven.medium.other;

import java.util.Arrays;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        MajorityElement finder = new MajorityElement();

        test(finder, new int[]{3, 2, 3}, 3);
        test(finder, new int[]{2, 2, 1, 1, 1, 2, 2}, 2);
        test(finder, new int[]{1, 1, 1, 1, 2, 3, 4}, 1);
        test(finder, new int[]{5, 5, 5, 2, 2, 5, 5}, 5);
        test(finder, new int[]{9}, 9); // single element case
    }

    private static void test(MajorityElement finder, int[] input, int expected) {
        int result = finder.majorityElement(input);
        if (result == expected) {
            System.out.println("Test passed for input " + Arrays.toString(input) + ": " + result);
        } else {
            System.out.println("Test FAILED for input " + Arrays.toString(input) +
                    " | Expected: " + expected + ", Got: " + result);
        }
    }
}
