package com.ven.medium.dfs;

import java.util.List;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 * <p>
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 * <p>
 * Return the sum of each integer in nestedList multiplied by its depth.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
 * Example 2:
 * <p>
 * <p>
 * Input: nestedList = [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
 * Example 3:
 * <p>
 * Input: nestedList = [0]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nestedList.length <= 50
 * The values of the integers in the nested list is in the range [-100, 100].
 * The maximum depth of any integer is less than or equal to 50.
 */


public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += dfs(ni.getList(), depth + 1);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        NestedListWeightSum solution = new NestedListWeightSum();
        // You can create a test case here using the NestedInteger class
        // Example: [[1,1],2,[1,1]]
        NestedInteger ni1 = new NestedInteger();
        ni1.add(new NestedInteger(1));
        ni1.add(new NestedInteger(1));

        NestedInteger ni2 = new NestedInteger(2);

        NestedInteger ni3 = new NestedInteger();
        ni3.add(new NestedInteger(1));
        ni3.add(new NestedInteger(1));

        List<NestedInteger> nestedList = List.of(ni1, ni2, ni3);

        int result = solution.depthSum(nestedList);
        System.out.println("Result: " + result); // Expected output: 10
    }
}
