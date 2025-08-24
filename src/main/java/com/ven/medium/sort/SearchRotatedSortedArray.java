package com.ven.medium.sort;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int rotatedIdx = find(nums, 0, nums.length - 1);
        //System.out.println("rotatedIdx : "+rotatedIdx);
        if (rotatedIdx == -1) {
            return binarySearch(0, nums.length - 1, nums, target);
        } else {
            int found = binarySearch(0, rotatedIdx, nums, target);
            if (found != -1) {
                return found;
            }

            found = binarySearch(rotatedIdx, nums.length - 1, nums, target);
            if (found != -1) {
                return found;
            }
        }
        return -1;
    }


    private int binarySearch(int left, int right, int[] nums, int target) {
        //System.out.println("left : "+left+" , right: "+right);
        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println("nums[mid] : "+nums[mid]+" , target: "+target);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1; // Move to the left side
            } else {
                left = mid + 1; // Move to the right side
            }
        }

        return -1;
    }


    private int find(int[] nums, int l, int r) {
        //System.out.println("l:"+l+", r:"+r);
        int mid = 0;
        if (l <= r) {
            mid = l + (r - l) / 2;

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }
            int left = find(nums, l, mid - 1);
            if (left != -1) {
                return left;
            }
            int right = find(nums, mid + 1, r);
            if (right != -1) {
                return right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray solution = new SearchRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);

        target = 3;
        result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);

        nums = new int[]{1};
        target = 0;
        result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}
