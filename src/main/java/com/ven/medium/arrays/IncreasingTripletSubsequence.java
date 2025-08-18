package com.ven.medium.arrays;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 * <p>
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 * <p>
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {

            if (first >= n) {
                first = n;
            } else if (second >= n) {
                second = n;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        int[] nums = {1, 2, 3, 4, 5}; // Example input
        boolean result = solution.increasingTriplet(nums);
        System.out.println("Does an increasing triplet subsequence exist? " + result); // Output: true
    }
}
