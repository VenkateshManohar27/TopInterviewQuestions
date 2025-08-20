package com.ven.medium.sort;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * <p>
 * <p>
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroes++;
            if (nums[i] == 1)
                ones++;
        }


        for (int i = 0; i < nums.length; i++) {
            if (zeroes > 0) {
                nums[i] = 0;
                zeroes--;
            } else if (ones > 0) {
                nums[i] = 1;
                ones--;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        System.out.println("Sorted colors: " + java.util.Arrays.toString(nums)); // Output: [0, 0, 1, 1, 2, 2]

        int[] nums2 = {2, 0, 1};
        sortColors.sortColors(nums2);
        System.out.println("Sorted colors: " + java.util.Arrays.toString(nums2)); // Output: [0, 1, 2]
    }
}
