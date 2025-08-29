package com.ven.medium.design;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= val <= 231 - 1
 * At most 2 * 105 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
public class RandomizedSet {
    Map<Integer, Integer> numToIndex;
    List<Integer> li;
    Random random;

    public RandomizedSet() {
        numToIndex = new HashMap<>();
        li = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        }

        numToIndex.put(val, li.size());
        li.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }

        int index = numToIndex.get(val);
        int temp = li.get(li.size() - 1);
        li.set(index, temp);
        numToIndex.put(temp, index);
        li.remove(li.size() - 1);
        numToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(li.size());
        return li.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();

        // Insert elements
        System.out.println("Insert 10: " + set.insert(10)); // true
        System.out.println("Insert 20: " + set.insert(20)); // true
        System.out.println("Insert 10 again: " + set.insert(10)); // false (duplicate)

        // Remove elements
        System.out.println("Remove 10: " + set.remove(10)); // true
        System.out.println("Remove 10 again: " + set.remove(10)); // false (already removed)

        // Insert after remove
        System.out.println("Insert 30: " + set.insert(30)); // true
        System.out.println("Insert 40: " + set.insert(40)); // true

        // Current state: [20, 30, 40]
        System.out.println("Random values:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Random: " + set.getRandom());
        }

        // Remove all and try getRandom safely
        set.remove(20);
        set.remove(30);
        set.remove(40);

        // Now set is empty; check for safe handling
        try {
            set.getRandom();
        } catch (Exception e) {
            System.out.println("Caught exception on getRandom from empty set: " + e.getMessage());
        }
    }
}
