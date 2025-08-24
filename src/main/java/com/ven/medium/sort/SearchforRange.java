package com.ven.medium.sort;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class SearchforRange {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = binarySearch(target, nums, true);

        if (firstOccurence == -1) {
            return new int[]{firstOccurence, firstOccurence};
        }

        int lastOccurence = binarySearch(target, nums, false);


        return new int[]{firstOccurence, lastOccurence};
    }

    private int binarySearch(int target, int[] nums, boolean isFirst) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == start || nums[mid - 1] != target) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }


            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchforRange solution = new SearchforRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("Starting and Ending positions: [" + result[0] + ", " + result[1] + "]");
    }
}
