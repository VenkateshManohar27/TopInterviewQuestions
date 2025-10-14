package com.ven.medium.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 * <p>
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 * <p>
 * Implement the Logger class:
 * <p>
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * Output
 * [null, true, true, false, false, false, true]
 * <p>
 * Explanation
 * Logger logger = new Logger();
 * logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
 * logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
 * logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
 * logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
 * logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
 * logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= timestamp <= 109
 * Every timestamp will be passed in non-decreasing order (chronological order).
 * 1 <= message.length <= 30
 * At most 104 calls will be made to shouldPrintMessage.
 */
public class LoggerRateLimiter {
    Map<String, Integer> msgTime;

    public LoggerRateLimiter() {
        msgTime = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // System.out.println(msgTime);
        if (msgTime.containsKey(message)) {
            if (timestamp >= msgTime.get(message)) {
                msgTime.put(message, timestamp + 10);
                return true;
            }
            return false;
        } else {
            msgTime.put(message, timestamp + 10);
            return true;
        }
    }

    public static void main(String[] args) {
        LoggerRateLimiter obj = new LoggerRateLimiter();
        System.out.println(obj.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        System.out.println(obj.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        System.out.println(obj.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println(obj.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println(obj.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(obj.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
    }
}
