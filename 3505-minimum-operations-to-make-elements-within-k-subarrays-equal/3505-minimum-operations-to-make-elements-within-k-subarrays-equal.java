class Solution {

    // Two TreeMaps to maintain the two halves of the window
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    int leftSize = 0;
    int rightSize = 0;

    long leftSum = 0;
    long rightSum = 0;

    // Add an element to the median window
    private void add(int num) {

        if (left.isEmpty() || num <= left.lastKey()) {
            addToLeft(num);
        } else {
            addToRight(num);
        }

        balance();
    }

    // Remove an element from the median window
    private void remove(int num) {

        if (left.containsKey(num)) {
            removeFromLeft(num);
        } else {
            removeFromRight(num);
        }

        balance();
    }

    private void addToLeft(int num) {
        left.put(num, left.getOrDefault(num, 0) + 1);
        leftSize++;
        leftSum += num;
    }

    private void addToRight(int num) {
        right.put(num, right.getOrDefault(num, 0) + 1);
        rightSize++;
        rightSum += num;
    }

    private void removeFromLeft(int num) {
        removeValue(left, num);
        leftSize--;
        leftSum -= num;
    }

    private void removeFromRight(int num) {
        removeValue(right, num);
        rightSize--;
        rightSum -= num;
    }

    // Remove one occurrence of a value from a TreeMap
    private void removeValue(TreeMap<Integer, Integer> map, int num) {

        int frequency = map.get(num);

        if (frequency == 1) {
            map.remove(num);
        } else {
            map.put(num, frequency - 1);
        }
    }

    // Keep the left half equal in size to or one larger than right
    private void balance() {

        while (leftSize > rightSize + 1) {

            int num = left.lastKey();

            removeFromLeft(num);
            addToRight(num);
        }

        while (leftSize < rightSize) {

            int num = right.firstKey();

            removeFromRight(num);
            addToLeft(num);
        }
    }

    // Calculate the minimum cost to make the window equal
    private long getCost() {

        int median = left.lastKey();

        long leftCost = (long) median * leftSize - leftSum;
        long rightCost = rightSum - (long) median * rightSize;

        return leftCost + rightCost;
    }

    // Main LeetCode method
    public long minOperations(int[] nums, int x, int k) {

        // Reset data structures
        left.clear();
        right.clear();

        leftSize = 0;
        rightSize = 0;
        leftSum = 0;
        rightSum = 0;

        int n = nums.length;

        // Store the cost of every window of size x
        long[] cost = new long[n - x + 1];

        // First window
        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        // Slide the window
        for (int i = x; i < n; i++) {

            remove(nums[i - x]);
            add(nums[i]);

            cost[i - x + 1] = getCost();
        }

        // DP: minimum cost to select exactly j windows
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 0; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        // Selecting zero windows costs zero
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        // Build DP
        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Option 1: Do not select a window ending here
                dp[j][i] = dp[j][i - 1];

                // Option 2: Select a window of size x
                if (i >= x && dp[j - 1][i - x] != INF) {

                    long currentCost = dp[j - 1][i - x]
                                     + cost[i - x];

                    dp[j][i] = Math.min(dp[j][i], currentCost);
                }
            }
        }

        return dp[k][n];
    }
}