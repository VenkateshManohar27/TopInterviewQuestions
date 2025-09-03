package com.ven.hard.array;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and using only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 * <p>
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val] < 0) {
                duplicate = val;
                break;
            }
            nums[val] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        return duplicate;
    }

    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        DuplicateNumber solution = new DuplicateNumber();
        int[] nums1 = {1, 3, 4, 2, 2};
        int result1 = solution.findDuplicate(nums1);
        System.out.println("Output for [1, 3, 4, 2, 2]: " + result1); // Expected: 2

        int[] nums2 = {3, 1, 3, 4, 2};
        int result2 = solution.findDuplicate(nums2);
        System.out.println("Output for [3, 1, 3, 4, 2]: " + result2); // Expected: 3

        int[] nums3 = {3, 3, 3, 3, 3};
        int result3 = solution.findDuplicate(nums3);
        System.out.println("Output for [3, 3, 3, 3, 3]: " + result3); // Expected: 3


        int[] nums4 = {1, 3, 4, 2, 2};
        int result4 = solution.findDuplicate(nums4);
        System.out.println("Output for [1, 3, 4, 2, 2]: " + result4); // Expected: 2

        int[] nums5 = {3, 1, 3, 4, 2};
        int result5 = solution.findDuplicate(nums5);
        System.out.println("Output for [3, 1, 3, 4, 2]: " + result5); // Expected: 3

        int[] nums6 = {3, 3, 3, 3, 3};
        int result6 = solution.findDuplicate(nums6);
        System.out.println("Output for [3, 3, 3, 3, 3]: " + result6); // Expected: 3


    }
}
