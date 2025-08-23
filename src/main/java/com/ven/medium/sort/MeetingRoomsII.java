package com.ven.medium.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }else {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> minQ = new PriorityQueue<>((a, b)->{
            return a[1] - b[1];
        });
        int rooms = 0;
        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            while(!minQ.isEmpty() && minQ.peek()[1] <= interval[0]){
                minQ.poll();
            }
            minQ.offer(interval);
            rooms = Math.max(rooms, minQ.size());
        }

        return rooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int result = solution.minMeetingRooms(intervals);
        System.out.println("Minimum number of conference rooms required: " + result); // Output: 2
    }
}
