class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = -1;
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
            }

            int next = (i + 1) % n;

            if (nums[next] != (nums[i] + 1) % n) {
                ascending = false;
            }

            if (nums[next] != (nums[i] - 1 + n) % n) {
                descending = false;
            }
        }

        if (ascending) {
            return Math.min(zero, n - zero + 2);
        }

        if (descending) {
            int reverseFirst = n - zero;
            int rotateFirst = (zero + 1) % n + 1;

            return Math.min(reverseFirst, rotateFirst);
        }

        return -1;
    }
}