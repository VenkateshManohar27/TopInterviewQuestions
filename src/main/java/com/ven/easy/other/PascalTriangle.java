package com.ven.easy.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numRows <= 30
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(1);
        l.add(li);

        for (int i = 1; i < numRows; i++) {
            li = new ArrayList<>();
            List<Integer> prev = l.get(i - 1);
            li.add(1);
            for (int j = 1; j <= i - 1; j++) {
                li.add(prev.get(j - 1) + prev.get(j));
            }

            li.add(1);
            l.add(li);
        }
        return l;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        int numRows = 5; // Example input
        List<List<Integer>> result = pascalTriangle.generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows: " + result);
    }
}
