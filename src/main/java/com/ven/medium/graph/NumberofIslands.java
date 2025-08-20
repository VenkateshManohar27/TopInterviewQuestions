package com.ven.medium.graph;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //int[][] visited = new int[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visit(i, j, grid, count);
                    // print(visited);
                }
            }
        }

        return count;
    }

    private void visit(int row, int col, char[][] g, int count) {
        if (row < 0 || row >= g.length || col < 0 || col >= g[0].length ||
                g[row][col] == '0') {
            return;
        }
        // System.out.println("eneterd "+row+"x"+col);
        //v[row][col] = count;
        g[row][col] = '0';
        visit(row - 1, col, g, count);
        visit(row + 1, col, g, count);
        visit(row, col - 1, g, count);
        visit(row, col + 1, g, count);
    }

    private void print(int[][] v) {

        for (int i = 0; i < v.length; i++) {
            System.out.print("[");
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + ",");
            }
            System.out.println("]");
        }

        System.out.println("==============================");
    }

    public static void main(String[] args) {
        NumberofIslands solution = new NumberofIslands();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands: " + solution.numIslands(grid1)); // Output: 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + solution.numIslands(grid2)); // Output: 3
    }
}
