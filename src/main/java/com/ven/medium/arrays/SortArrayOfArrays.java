package com.ven.medium.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortArrayOfArrays {
    public static void main(String[] args) {
        // Example array of sorted arrays
        int[][] arrayOfSortedArrays = {
                {1, 3, 5},
                {2, 4, 6},
                {0, 7, 8}
        };
        SortArrayOfArrays solution = new SortArrayOfArrays();
        List<Integer> result = solution.merge(arrayOfSortedArrays);
        System.out.println("Merged Sorted List: " + result);
    }

    private List<Integer> merge(int[][] arr) {
        // Create a new list to store all elements
        List<Integer> list = new ArrayList<>();
        int[] index = new int[arr.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new int[]{arr[i][0], i});
            index[i] = 1;
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            list.add(curr[0]);
            if (index[curr[1]] < arr[curr[1]].length) {
                pq.offer(new int[]{arr[curr[1]][index[curr[1]]], curr[1]});
                index[curr[1]]++;
            }
        }

        // Print the sorted list
        return list;
    }
}
