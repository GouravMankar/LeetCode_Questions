class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        // Step 1: Find the common requirement
        long common = Math.min(need1, need2);

        // Step 2: Fulfil common requirements
        long ans = common * Math.min(costBoth, cost1 + cost2);

        // Step 3: Handle remaining type 1 requirements
        long remaining1 = need1 - common;

        ans += remaining1 * Math.min(cost1, costBoth);

        // Step 4: Handle remaining type 2 requirements
        long remaining2 = need2 - common;

        ans += remaining2 * Math.min(cost2, costBoth);

        return ans;
    }
}