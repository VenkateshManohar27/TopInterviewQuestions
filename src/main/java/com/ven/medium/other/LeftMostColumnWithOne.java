package com.ven.medium.other;

import java.util.List;

/**
 * A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in non-decreasing order.
 */

// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

class BinaryMatrixImpl implements BinaryMatrix {
    private final int[][] matrix;

    public BinaryMatrixImpl(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int get(int row, int col) {
        return matrix[row][col];
    }

    @Override
    public List<Integer> dimensions() {
        return List.of(matrix.length, matrix[0].length);
    }
}

public class LeftMostColumnWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> li = binaryMatrix.dimensions();
        int rows = li.get(0);
        int cols = li.get(1);
        int leftmost = Integer.MAX_VALUE;
        for (int row = 0; row < rows; row++) {
            int left = 0, right = cols - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (binaryMatrix.get(row, mid) == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (binaryMatrix.get(row, left) == 1) {
                leftmost = Math.min(leftmost, left);
            }
        }

        return leftmost != Integer.MAX_VALUE ? leftmost : -1;
    }

    public static void main(String[] args) {
        LeftMostColumnWithOne obj = new LeftMostColumnWithOne();
        int[][] matrix1 = {
                {0, 0},
                {1, 1}
        };
        BinaryMatrix binaryMatrix1 = new BinaryMatrixImpl(matrix1);
        System.out.println(obj.leftMostColumnWithOne(binaryMatrix1)); // Output: 0

        int[][] matrix2 = {
                {0, 0},
                {0, 1}
        };
        BinaryMatrix binaryMatrix2 = new BinaryMatrixImpl(matrix2);
        System.out.println(obj.leftMostColumnWithOne(binaryMatrix2)); // Output: 1

        int[][] matrix3 = {
                {0, 0},
                {0, 0}
        };
        BinaryMatrix binaryMatrix3 = new BinaryMatrixImpl(matrix3);
        System.out.println(obj.leftMostColumnWithOne(binaryMatrix3)); // Output: -1
    }
}
