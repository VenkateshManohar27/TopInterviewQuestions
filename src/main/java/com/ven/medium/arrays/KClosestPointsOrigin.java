package com.ven.medium.arrays;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= points.length <= 104
 * -104 <= xi, yi <= 104
 */
public class KClosestPointsOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(a -> ((a[0]) * (a[0]) + (a[1]) * (a[1]))));
        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
            //System.out.print("["+points[i][0]+","+points[i][1]+"]");
        }
        //System.out.println();
        return res;
    }

    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                b[0] - a[0]
        );

        for (int i = 0; i < points.length; i++) {
            pq.offer(new int[]{squaredDistance(points[i]), i});

            while (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int j = 0;

        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            res[j] = points[point[1]];
            j++;
        }

        return res;
    }

    private int squaredDistance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static void main(String[] args) {
        KClosestPointsOrigin solution = new KClosestPointsOrigin();
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = solution.kClosest(points, k);
        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
