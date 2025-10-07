package com.ven.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.
 * <p>
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * <p>
 * Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: [[2,2],[4,49],[51,74],[76,99]]
 * Explanation: The ranges are:
 * [2,2]
 * [4,49]
 * [51,74]
 * [76,99]
 * Example 2:
 * <p>
 * Input: nums = [-1], lower = -1, upper = -1
 * Output: []
 * Explanation: There are no missing ranges since there are no missing numbers.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -109 <= lower <= upper <= 109
 * 0 <= nums.length <= 100
 * lower <= nums[i] <= upper
 * All the values of nums are unique.
 */
public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(List.of(lower, upper));
            return res;
        }

        if (lower < nums[0]) {
            res.add(List.of(lower, nums[0] - 1));
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                res.add(List.of(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        if (upper > nums[nums.length - 1]) {
            res.add(List.of(nums[nums.length - 1] + 1, upper));
        }
        return res;
    }

    public static void main(String[] args) {
        MissingRanges missingRanges = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<List<Integer>> result = missingRanges.findMissingRanges(nums, lower, upper);
        System.out.println("Missing Ranges: " + result); // Output: [[2,2],[4,49],[51,74],[76,99]]

        nums = new int[]{-1};
        lower = -1;
        upper = -1;
        result = missingRanges.findMissingRanges(nums, lower, upper);
        System.out.println("Missing Ranges: " + result); // Output: []
    }
}
