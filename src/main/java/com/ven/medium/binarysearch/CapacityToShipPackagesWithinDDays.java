package com.ven.medium.binarysearch;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * <p>
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * Example 2:
 * <p>
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * Example 3:
 * <p>
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0;
        int max = 0;
        for (int w : weights) {
            total += w;
            max = Math.max(max, w);
        }

        int left = max, right = total;

        while (left < right) {
            int mid = (left + right) / 2;

            if (feasible(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean feasible(int[] weights, int weight, int days) {
        int curr = 0;
        int daysNeeded = 1;
        for (int i = 0; i < weights.length; i++) {
            curr += weights[i];
            if (curr > weight) {
                daysNeeded++;
                curr = weights[i];
            }
        }
        return daysNeeded <= days;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays obj = new CapacityToShipPackagesWithinDDays();
        System.out.println(obj.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // 15
        System.out.println(obj.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)); // 6
        System.out.println(obj.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)); // 3
    }
}
