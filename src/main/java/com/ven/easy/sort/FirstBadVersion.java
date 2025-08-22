package com.ven.easy.sort;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 * <p>
 * Input: n = 1, bad = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {
    private int firstBadVersion;

    public FirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid; // mid could be the first bad version
            } else {
                left = mid + 1; // search in the right half
            }
        }
        return left; // left will be the first bad version
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion(4);
        int n = 5;
        int result = firstBadVersion.firstBadVersion(n);
        System.out.println("The first bad version is: " + result); // Output: 4
    }
}
