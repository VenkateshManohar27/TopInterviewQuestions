package com.ven.easy.other;

public class ReverseBits {

    public static void main(String[] args) {
        int n = 43261596; // Example input
        int reversed = reverseBits(n);
        System.out.println("Reversed bits: " + reversed);
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // Shift result to the left
            result |= (n & 1); // Add the last bit of n to result
            n >>= 1; // Shift n to the right
        }
        return result;
    }
}
