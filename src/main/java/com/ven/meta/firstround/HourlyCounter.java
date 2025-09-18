package com.ven.meta.firstround;


import java.util.concurrent.atomic.AtomicLong;

/**
 * A thread-safe, space-optimized rolling counter for a 1-hour time window.
 * The counter uses a circular array of AtomicLongs to track counts in
 * 60 one-minute buckets.
 */
public class HourlyCounter {

    // One hour in milliseconds
    private static final long ONE_HOUR_IN_MILLIS = 60 * 60 * 1000L;
    // The number of buckets (one per minute)
    private static final int NUM_BUCKETS = 60;
    // The duration of each bucket in milliseconds
    private static final long BUCKET_DURATION_IN_MILLIS = ONE_HOUR_IN_MILLIS / NUM_BUCKETS;

    // Circular array for storing the counts. Volatile for visibility.
    private final AtomicLong[] buckets = new AtomicLong[NUM_BUCKETS];
    // Last recorded timestamp for refreshing buckets. Volatile for visibility.
    private volatile long lastUpdateTimestamp;

    public HourlyCounter() {
        for (int i = 0; i < NUM_BUCKETS; i++) {
            buckets[i] = new AtomicLong(0);
        }
        this.lastUpdateTimestamp = System.currentTimeMillis();
    }

    /**
     * Records a new event by incrementing the counter for the current minute.
     * This operation is highly efficient (O(1)).
     */
    public void bump() {
        long currentMillis = System.currentTimeMillis();
        int currentBucketIndex = (int) ((currentMillis / BUCKET_DURATION_IN_MILLIS) % NUM_BUCKETS);

        // Before bumping, update any expired buckets
        refreshBuckets(currentMillis, currentBucketIndex);
        buckets[currentBucketIndex].incrementAndGet();
    }

    /**
     * Gets the total count of events in the last hour.
     * This operation is O(N) where N is the number of buckets.
     *
     * @return The total count for the past hour.
     */
    public long getCount() {
        long currentMillis = System.currentTimeMillis();
        int currentBucketIndex = (int) ((currentMillis / BUCKET_DURATION_IN_MILLIS) % NUM_BUCKETS);

        refreshBuckets(currentMillis, currentBucketIndex);

        long totalCount = 0;
        for (AtomicLong bucket : buckets) {
            totalCount += bucket.get();
        }
        return totalCount;
    }

    /**
     * Updates and resets any expired buckets based on the current time.
     * This method is synchronized to prevent multiple threads from
     * refreshing buckets simultaneously, which could lead to race conditions.
     *
     * @param currentMillis      The current time in milliseconds.
     * @param currentBucketIndex The index of the current bucket.
     */
    private synchronized void refreshBuckets(long currentMillis, int currentBucketIndex) {
        long elapsedTime = currentMillis - lastUpdateTimestamp;
        if (elapsedTime >= BUCKET_DURATION_IN_MILLIS) {
            int elapsedBuckets = (int) (elapsedTime / BUCKET_DURATION_IN_MILLIS);
            for (int i = 1; i <= elapsedBuckets; i++) {
                int indexToReset = (currentBucketIndex - i + NUM_BUCKETS) % NUM_BUCKETS;
                buckets[indexToReset].set(0);
            }
            lastUpdateTimestamp = currentMillis;
        }
    }

    public static void main(String[] args) {
        HourlyCounter counter = new HourlyCounter();

        // Simulate some events
        counter.bump();
        counter.bump();
        counter.bump();

        System.out.println("Count after 3 bumps: " + counter.getCount()); // Should print 3

        // Simulate waiting for more than a minute
        try {
            Thread.sleep(61 * 1000); // Sleep for 61 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter.bump();
        System.out.println("Count after 1 bump post-wait: " + counter.getCount()); // Should print 1
    }
}
