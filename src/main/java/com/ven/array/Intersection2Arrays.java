package com.ven.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 *
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Intersection2Arrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        while(i < m && j < n) {
            if(nums1[i] < nums2[j]){
                i++;
            }else if (nums2[j] < nums1[i]){
                j++;
            }else if(nums1[i] == nums2[j]){
                li.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[li.size()];

        for(int k = 0; k < res.length; k++) {
            res[k] = li.get(k);
        }

        return res;
    }

    public static void main(String[] args) {
        Intersection2Arrays intersection2Arrays = new Intersection2Arrays();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection2Arrays.intersect(nums1, nums2);
        System.out.println("Intersection: " + java.util.Arrays.toString(result)); // Output: [2, 2]
    }
}
