class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;

        long k = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        if (k == 0) {
            return getSum(diff);
        }

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        if (k >= total) {
            return 0;
        }

        int left = 0, right = max;

        // Find the minimum maximum difference level
        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int level = left;
        long remaining = k;
        long ans = 0;

        for (int d : diff) {
            if (d > level) {
                remaining -= d - level;
                ans += (long) level * level;
            } else {
                ans += (long) d * d;
            }
        }

        // Use remaining operations to reduce level-valued differences
        for (int d : diff) {
            if (remaining == 0) break;

            if (d >= level && level > 0) {
                ans -= (long) level * level;
                ans += (long) (level - 1) * (level - 1);
                remaining--;
            }
        }

        return ans;
    }
        private long getSum(int[] diff) {
        long sum = 0;

        for (int d : diff) {
            sum += (long) d * d;
        }

        return sum;
    }
}