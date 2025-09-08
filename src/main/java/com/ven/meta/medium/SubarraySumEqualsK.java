package com.ven.meta.medium;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        int sum = 0;
        int left = 0;
        int count = 0;

        // System.out.print("[");
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            //    System.out.print(prefix[i] +",");
        }
        // System.out.println("]");

        for (int start = 0; start < prefix.length; start++) {
            for (int end = start + 1; end < prefix.length; end++) {
                if (prefix[end] - prefix[start] == k) {
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Number of subarrays in [1,1,1] that sum to 2: " + solution.subarraySum(nums1, k1)); // Expected: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Number of subarrays in [1,2,3] that sum to 3: " + solution.subarraySum(nums2, k2)); // Expected: 2

        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("Number of subarrays in [1,-1,0] that sum to 0: " + solution.subarraySum(nums3, k3)); // Expected: 3

        int[] nums4 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k4 = 7;
        System.out.println("Number of subarrays in [3,4,7,2,-3,1,4,2] that sum to 7: " + solution.subarraySum(nums4, k4)); // Expected: 4
    }
}
