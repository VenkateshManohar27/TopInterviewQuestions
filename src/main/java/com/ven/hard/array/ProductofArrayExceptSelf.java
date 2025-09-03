package com.ven.hard.array;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] suffix = new int[n + 1];
        suffix[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            res[i] = prefix[i] * suffix[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf solution = new ProductofArrayExceptSelf();
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.print("Output for [1, 2, 3, 4]: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.print("Output for [-1, 1, 0, -3, 3]: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println(); // Output: [0, 0, 9, 0, 0]
    }
}
