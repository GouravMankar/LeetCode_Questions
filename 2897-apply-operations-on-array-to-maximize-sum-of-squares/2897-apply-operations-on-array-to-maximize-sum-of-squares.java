class Solution {
    public int maxSum(List<Integer> nums, int k) {
  long MOD = 1_000_000_007L;

        int[] count = new int[31];

        // Count set bits at each position
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    count[bit]++;
                }
            }
        }

        long ans = 0;

        // Construct k numbers greedily
        for (int i = 0; i < k; i++) {
            long current = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (count[bit] > 0) {
                    current |= (1L << bit);
                    count[bit]--;
                }
            }

            ans = (ans + (current * current) % MOD) % MOD;
        }

        return (int) ans;
    }
}