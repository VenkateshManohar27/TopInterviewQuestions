package com.ven.medium.other;

/**
 * Suppose you are at a party with n people labeled from 0 to n - 1 and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know the celebrity, but the celebrity does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there is not one. You are only allowed to ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given an integer n and a helper function bool knows(a, b) that tells you whether a knows b. Implement a function int findCelebrity(n). There will be exactly one celebrity if they are at the party.
 * <p>
 * Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.
 * <p>
 * Note that the n x n 2D array graph given as input is not directly available to you, and instead only accessible through the helper function knows. graph[i][j] == 1 represents person i knows person j, wherease graph[i][j] == 0 represents person j does not know person i.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 * Example 2:
 * <p>
 * <p>
 * Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
 * Output: -1
 * Explanation: There is no celebrity.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == graph.length == graph[i].length
 * 2 <= n <= 100
 * graph[i][j] is 0 or 1.
 * graph[i][i] == 1
 * <p>
 * <p>
 * Follow up: If the maximum number of allowed calls to the API knows is 3 * n, could you find a solution without exceeding the maximum number of calls?
 */
public class FindtheCelebrity {
    private int N = 0;

    public int findCelebrity(int n) {
        this.N = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < this.N; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }

        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }

        return -1;
    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < this.N; j++) {
            if (i == j) continue;

            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }

    protected boolean knows(int i, int j) {
        int[][] graph = {
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        return graph[i][j] == 1;
    }

    public static void main(String[] args) {
        FindtheCelebrity solution = new FindtheCelebrity();
        int n = 3;
        int result = solution.findCelebrity(n);
        System.out.println("Celebrity: " + result); // Expected: 1
    }
}
