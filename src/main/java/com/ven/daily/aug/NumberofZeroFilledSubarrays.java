package com.ven.daily.aug;

/**
 * Given an integer array nums, return the number of subarrays filled with 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,0,0,2,0,0,4]
 * Output: 6
 * Explanation:
 * There are 4 occurrences of [0] as a subarray.
 * There are 2 occurrences of [0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
 * Example 2:
 * <p>
 * Input: nums = [0,0,0,2,0,0]
 * Output: 9
 * Explanation:
 * There are 5 occurrences of [0] as a subarray.
 * There are 3 occurrences of [0,0] as a subarray.
 * There is 1 occurrence of [0,0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
 * Example 3:
 * <p>
 * Input: nums = [2,10,2019]
 * Output: 0
 * Explanation: There is no subarray filled with 0. Therefore, we return 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class NumberofZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long continuos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continuos++;
            } else {
                continuos = 0;
            }
            count += continuos;
        }

        return count;
    }

    public static void main(String[] args) {
        NumberofZeroFilledSubarrays solution = new NumberofZeroFilledSubarrays();
        int[] nums1 = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println("Number of zero filled subarrays: " + solution.zeroFilledSubarray(nums1)); // Output: 6

        int[] nums2 = {0, 0, 0, 2, 0, 0};
        System.out.println("Number of zero filled subarrays: " + solution.zeroFilledSubarray(nums2)); // Output: 9

        int[] nums3 = {2, 10, 2019};
        System.out.println("Number of zero filled subarrays: " + solution.zeroFilledSubarray(nums3)); // Output: 0
    }
}
