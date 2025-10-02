package com.ven.hard.stack;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<int[]> min = new Stack<>();
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            while (!min.isEmpty() && min.peek()[0] < height[i]) {
                int[] top = min.pop();
                if (min.isEmpty()) break;
                int distance = i - min.peek()[1] - 1;
                int bounded_height =
                        Math.min(height[i], height[min.peek()[1]]) - height[top[1]];
                total += distance * bounded_height;
            }
            min.push(new int[]{height[i], i});
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappingRainWater.trap(height));
    }

}
