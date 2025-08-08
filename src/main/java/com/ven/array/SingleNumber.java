package com.ven.array;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * <p>
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * <p>
 * Output: 1
 * <p>
 *
 *
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num ^= nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        int uniqueNumber = singleNumber.singleNumber(nums);
        System.out.println("The single number is: " + uniqueNumber); // Output: 4
    }
}
