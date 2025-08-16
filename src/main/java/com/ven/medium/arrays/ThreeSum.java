package com.ven.medium.arrays;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.computeIfAbsent(nums[i], k -> new ArrayList()).add(i);
        }

        //System.out.println(freq);
        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num1 = nums[i];

            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = num1 + nums[j];
                if (target != 0) {
                    target = -(target);
                }
                //System.out.println("target : "+target);
                List<Integer> indexes = freq.getOrDefault(target, new ArrayList<>());
                //System.out.println(indexes);
                for (int ind : indexes) {
                    if (ind > i && ind > j) {
                        List<Integer> l = new ArrayList<>();
                        l.add(num1);
                        l.add(nums[j]);
                        l.add(nums[ind]);
                        li.add(l);
                        break;
                    }
                }
            }
        }

        return li;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4}; // Example input
        System.out.println("Triplets that sum to zero: " + threeSum.threeSum(nums));
    }
}
