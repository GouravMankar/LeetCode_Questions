class Solution {

    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;

    private static final long BASE1 = 100_019L;
    private static final long BASE2 = 100_043L;

    private boolean hasUniqueSubarray(
            int[] nums, int len, long[] pow1, long[] pow2) {

        HashMap<Long, Integer> map = new HashMap<>();

        long hash1 = 0;
        long hash2 = 0;

        // Calculate hash of the first window
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * BASE1 + nums[i]) % MOD1;
            hash2 = (hash2 * BASE2 + nums[i]) % MOD2;
        }

        long key = hash1 * MOD2 + hash2;
        map.put(key, 1);

        // Slide the window
        for (int i = len; i < nums.length; i++) {

            long outgoing = nums[i - len];
            long incoming = nums[i];

            hash1 = (hash1 * BASE1 + incoming
                    - (outgoing * pow1[len]) % MOD1 + MOD1) % MOD1;

            hash2 = (hash2 * BASE2 + incoming
                    - (outgoing * pow2[len]) % MOD2 + MOD2) % MOD2;

            key = hash1 * MOD2 + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check whether any subarray occurs exactly once
        for (int frequency : map.values()) {
            if (frequency == 1) {
                return true;
            }
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        // Precompute powers
        for (int i = 1; i <= n; i++) {
            pow1[i] = (pow1[i - 1] * BASE1) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE2) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (hasUniqueSubarray(nums, mid, pow1, pow2)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
