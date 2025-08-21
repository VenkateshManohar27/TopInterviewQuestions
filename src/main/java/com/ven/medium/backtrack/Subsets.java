package com.ven.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        generate(0, new ArrayList<>(), li, nums);
        return li;
    }

    private void generate(int in, List<Integer> subs, List<List<Integer>> li, int[] nums) {
        li.add(new ArrayList<>(subs));

        for (int i = in; i < nums.length; i++) {
            subs.add(nums[i]);
            generate(i + 1, subs, li, nums);
            subs.remove(subs.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println("Generated Subsets: " + subsets);
    }
}
