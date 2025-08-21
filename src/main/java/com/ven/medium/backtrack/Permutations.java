package com.ven.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        generate(visited, nums, new ArrayList<>(), li);
        return li;
    }


    private void generate(boolean[] v, int[] n, List<Integer> p, List<List<Integer>> l) {
        if (p.size() == n.length) {
            l.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < n.length; i++) {
            if (!v[i]) {
                v[i] = true;
                p.add(n[i]);
                generate(v, n, p, l);
                v[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        System.out.println("Generated Permutations: " + permutations);
    }
}
