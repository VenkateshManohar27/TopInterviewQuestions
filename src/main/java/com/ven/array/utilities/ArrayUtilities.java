package com.ven.array.utilities;

public class ArrayUtilities {

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
