package com.ven.medium.design;

/**
 * Design an iterator to flatten a 2D vector. It should support the next and hasNext operations.
 * <p>
 * Implement the Vector2D class:
 * <p>
 * Vector2D(int[][] vec) initializes the object with the 2D vector vec.
 * next() returns the next element from the 2D vector and moves the pointer one step forward. You may assume that all the calls to next are valid.
 * hasNext() returns true if there are still some elements in the vector, and false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Vector2D", "next", "next", "next", "hasNext", "hasNext", "next", "hasNext"]
 * [[[[1, 2], [3], [4]]], [], [], [], [], [], [], []]
 * Output
 * [null, 1, 2, 3, true, true, 4, false]
 * <p>
 * Explanation
 * Vector2D vector2D = new Vector2D([[1, 2], [3], [4]]);
 * vector2D.next();    // return 1
 * vector2D.next();    // return 2
 * vector2D.next();    // return 3
 * vector2D.hasNext(); // return True
 * vector2D.hasNext(); // return True
 * vector2D.next();    // return 4
 * vector2D.hasNext(); // return False
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= vec.length <= 200
 * 0 <= vec[i].length <= 500
 * -500 <= vec[i][j] <= 500
 * At most 105 calls will be made to next and hasNext.
 */
public class Flatten2DVector {
    private int[][] vec;
    private int row;
    private int col;

    public Flatten2DVector(int[][] vec) {
        this.vec = vec;
        this.row = 0;
        this.col = 0;
    }

    public int next() {
        if (!hasNext()) {
            throw new RuntimeException("No more elements");
        }
        return vec[row][col++];
    }

    public boolean hasNext() {
        while (row < vec.length && col >= vec[row].length) {
            row++;
            col = 0;
        }
        return row < vec.length && col < vec[row].length;
    }

    public static void main(String[] args) {
        Flatten2DVector vector2D = new Flatten2DVector(new int[][]{{1, 2}, {3}, {4}});
        System.out.println(vector2D.next());    // return 1
        System.out.println(vector2D.next());    // return 2
        System.out.println(vector2D.next());    // return 3
        System.out.println(vector2D.hasNext()); // return true
        System.out.println(vector2D.hasNext()); // return true
        System.out.println(vector2D.next());    // return 4
        System.out.println(vector2D.hasNext()); // return false
    }
}
