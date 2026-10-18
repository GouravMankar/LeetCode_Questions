class Solution {

    long MOD = 1_000_000_007L;
    long[][] comb;

    public int numOfWays(int[] nums) {

        int n = nums.length;

        // Pascal Triangle
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =(comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            arr.add(num);
        }

        return (int)((dfs(arr) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> arr) {

        if (arr.size() <= 2) {
            return 1;
        }

        int root = arr.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {

            if (arr.get(i) < root) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);

        long ways =
            comb[left.size() + right.size()][left.size()];

        return (((ways * leftWays) % MOD)
                * rightWays) % MOD;
    }
}