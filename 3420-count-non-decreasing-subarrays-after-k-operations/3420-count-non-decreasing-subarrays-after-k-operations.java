class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        long ans = 0;
        long cost = 0;

        Deque<int[]> dq = new ArrayDeque<>();

        int j = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge smaller groups into the current group
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                int nextNum = last[0];
                int nextCount = last[1];

                count += nextCount;

                // Increase the smaller elements to num
                cost += (long) (num - nextNum) * nextCount;
            }

            dq.offerLast(new int[]{num, count});

            // If operations exceed k, shrink from the right
            while (cost > k) {

                int[] first = dq.pollFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                cost -= (long) (rightmostNum - nums[j]);

                j--;

                // Keep the remaining elements of this group
                if (rightmostCount > 1) {
                    dq.offerFirst(
                        new int[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }

            // Count all valid subarrays ending at or before j
            ans += j - i + 1;
        }

        return ans;
    }
}