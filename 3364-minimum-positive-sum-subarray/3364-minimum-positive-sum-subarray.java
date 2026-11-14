class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int min = Integer.MAX_VALUE;

        for (int len = l; len <= r; len++) {

            int sum = 0;

            for (int i = 0; i < nums.size(); i++) {

                sum += nums.get(i);

                // Remove element outside current window
                if (i >= len) {
                    sum -= nums.get(i - len);
                }

                // Check only complete windows
                if (i >= len - 1 && sum > 0) {
                    min = Math.min(min, sum);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}