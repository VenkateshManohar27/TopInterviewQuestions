package com.ven.medium.backtrack;

import java.util.*;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * Example 2:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        generate(nums, new ArrayList<>(), seen, res);
        return res;
    }

    private void generate(int[] nums, List<Integer> li, Set<Integer> seen, List<List<Integer>> res) {
        if (li.size() == nums.length) {
            res.add(new ArrayList<>(li));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && seen.contains(i - 1)) {
                continue;
            }
            seen.add(i);
            li.add(nums[i]);
            generate(nums, li, seen, res);
            li.remove(li.size() - 1);
            seen.remove(i);
        }
    }

    public static void main(String[] args) {
        PermutationsII obj = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = obj.permuteUnique(nums);
        System.out.println("Unique permutations:");
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
