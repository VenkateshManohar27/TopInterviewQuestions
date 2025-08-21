package com.ven.daily.aug;

/**
 * Given an m x n binary matrix mat, return the number of submatrices that have all ones.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
 * Output: 13
 * Explanation:
 * There are 6 rectangles of side 1x1.
 * There are 2 rectangles of side 1x2.
 * There are 3 rectangles of side 2x1.
 * There is 1 rectangle of side 2x2.
 * There is 1 rectangle of side 3x1.
 * Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
 * Example 2:
 * <p>
 * <p>
 * Input: mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
 * Output: 24
 * Explanation:
 * There are 8 rectangles of side 1x1.
 * There are 5 rectangles of side 1x2.
 * There are 2 rectangles of side 1x3.
 * There are 4 rectangles of side 2x1.
 * There are 2 rectangles of side 2x2.
 * There are 2 rectangles of side 3x1.
 * There is 1 rectangle of side 3x2.
 * Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 150
 * mat[i][j] is either 0 or 1.
 */
public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int[][] row = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else {
                    row[i][j] = mat[i][j] == 0 ? 0 : row[i][j - 1] + 1;
                }
                int cur = row[i][j];
                for (int k = i; k >= 0; k--) {
                    cur = Math.min(cur, row[k][j]);
                    if (cur == 0) {
                        break;
                    }
                    res += cur;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubmatricesWithAllOnes solution = new CountSubmatricesWithAllOnes();
        int[][] mat = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        int result = solution.numSubmat(mat);
        System.out.println("Number of submatrices with all ones: " + result); // Output: 13
    }
}
