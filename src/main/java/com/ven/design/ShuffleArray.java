package com.ven.design;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
 * <p>
 * Implement the Solution class:
 * <p>
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must be equally likely to be returned.
 * // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * All the elements of nums are unique.
 * At most 104 calls in total will be made to reset and shuffle.
 */
public class ShuffleArray {
    private int[] original;
    private int[] shuffled;

    public ShuffleArray(int[] nums) {
        this.original = nums.clone();
        this.shuffled = nums.clone();
    }

    public int[] reset() {
        shuffled = original.clone();
        return shuffled;
    }

    public int[] shuffle() {
        for (int i = shuffled.length - 1; i > 0; i--) {
            swap(i);
        }
        return shuffled;
    }

    private void swap(int i) {
        int j = (int) (Math.random() * (i + 1));
        // Swap shuffled[i] with the element at random index j
        int temp = shuffled[i];
        shuffled[i] = shuffled[j];
        shuffled[j] = temp;
    }

    public static void main(String[] args) {
        ShuffleArray solution = new ShuffleArray(new int[]{1, 2, 3});
        int[] shuffledArray = solution.shuffle();
        System.out.println("Shuffled Array: " + java.util.Arrays.toString(shuffledArray));
        int[] resetArray = solution.reset();
        System.out.println("Reset Array: " + java.util.Arrays.toString(resetArray));
        shuffledArray = solution.shuffle();
        System.out.println("Shuffled Array: " + java.util.Arrays.toString(shuffledArray));
    }
}
