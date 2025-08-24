package com.ven.medium.dp;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastpos = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (lastpos < i || lastpos >= end) {
                break;
            }
            lastpos = Math.max(lastpos, i + nums[i]);
        }
        return lastpos >= end;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums1 = {2, 3, 1, 1, 4};
        boolean result1 = solution.canJump(nums1);
        System.out.println("Can jump to the last index: " + result1); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        boolean result2 = solution.canJump(nums2);
        System.out.println("Can jump to the last index: " + result2); // Output: false
    }
}
